package view.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;
import exceptions.ActPriceException;
import exceptions.FinishedException;
import exceptions.NotLoggedException;
import model.Tags;
import view.ViewUtilities;

public class ShowProduct extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel imageLabel;

	private JTextPane title;

	private JTextArea productDescription;

	private JPanel productInfo;

	private JPanel auxPanel;

	private ItemVO item;

	private JTextPane productLifeTime;

	private JTextPane productIdentifier;

	private JTextPane productCategory;

	private JTextPane productPrice;

	private JTextPane newPrice;

	private JButton updatePrice;

	private JTextField priceField;


	private JPanel showProduct;

	private Vector<String> tags;

	public ShowProduct(ItemVO it, Controler ctrl) {
		super(ctrl);
		item = it;
		tags = new Vector<String>();
		for (Tags t : Tags.values()) {
			tags.add(t.getName());
		}
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		initComponent();
		initGUI();
	}

	private JSeparator generateSeparator() {
		JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setVisible(true);
		separator.setBorder(BorderFactory.createLineBorder(Color.black));
		return separator;
	}

	private void initGUI() {
		this.showProduct.add(Box.createRigidArea(new Dimension(1, 50)));
		this.showProduct.add(generateSeparator());
		this.showProduct.add(title);
		this.showProduct.add(auxPanel);
		this.showProduct.add(generateSeparator());
		this.showProduct.add(productDescription);
		this.add(Box.createRigidArea(new Dimension(100, 1)));
		this.add(showProduct);
		this.add(Box.createRigidArea(new Dimension(300, 1)));
	}

	private void initComponent() {
		this.showProduct = new JPanel();
		this.showProduct.setBackground(Color.white);
		this.showProduct.setLayout(new BoxLayout(this.showProduct, BoxLayout.Y_AXIS));
		this.setBackground(Color.white);
		// title
		title = new JTextPane();
		generateTextPane(title, item.getName(), new Color(255, 96, 0), new Font("Arial", 16, 28));

		productLifeTime = new JTextPane();
		String chain = "Bid creation date: " + item.getDataCreation();
		if (item.isFinished())
			chain += "\nFINISHED BID";
		else
			chain += "\nRUNNIG BID";
		generateTextPane(productLifeTime, chain, new Color(0, 0, 0), new Font("Arial", 16, 16));

		productIdentifier = new JTextPane();
		generateTextPane(productIdentifier, "Product serial: " + item.getId(), new Color(0, 0, 0),
				new Font("Arial", 16, 16));

		productCategory = new JTextPane();
		generateTextPane(productCategory, "Category: " + tags.get(Integer.parseInt(item.getIdCategory()) - 1),
				new Color(0, 0, 0), new Font("Arial", 16, 16));

		productPrice = new JTextPane();
		generateTextPane(productPrice, "Price: " + item.getPrice() + "£", new Color(0, 0, 0),
				new Font("Arial", 16, 16));

		newPrice = new JTextPane();
		generateTextPane(newPrice, "New price: ", new Color(0, 0, 0), new Font("Arial", 2, 16));

		priceField = new JTextField();

		updatePrice = new JButton("Increase price");
		updatePrice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int i = Integer.parseInt(priceField.getText());
					try {
						ctrl.actPrice(item, i);
						ShowProduct.this.productPrice.setText("Price: " + i + "£");
					} catch (NotLoggedException | ActPriceException | FinishedException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						priceField.setText("");
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Price must be a number", "Error", JOptionPane.ERROR_MESSAGE);
					priceField.setText("");
				}
			}
		});

		// image label
		BufferedImage im = ViewUtilities.encodeImage(ViewUtilities.formatedString(item.getImg()));
		imageLabel = new JLabel(new ImageIcon(im.getScaledInstance(400, 400, Image.SCALE_DEFAULT)));
		imageLabel.setPreferredSize(new Dimension(400, 400));
		imageLabel.setBorder(null);
		imageLabel.setBackground(Color.white);

		productInfo = new JPanel();
		productInfo.setPreferredSize(new Dimension(200, 300));
		productInfo.setBackground(Color.white);
		productInfo.setLayout(new BoxLayout(productInfo, BoxLayout.Y_AXIS));
		productInfo.add(productLifeTime);
		productInfo.add(productIdentifier);
		productInfo.add(productCategory);
		productInfo.add(productPrice);
		if (!item.isFinished() && ctrl.getLoggedUser()!=null) {
			productInfo.add(priceField);
			productInfo.add(updatePrice);
		}
		productInfo.add(Box.createRigidArea(new Dimension(1, 100)));
		productInfo.setBorder(null);

		auxPanel = new JPanel();
		auxPanel.setBackground(Color.white);
		auxPanel.add(imageLabel);
		auxPanel.add(Box.createRigidArea(new Dimension(50, 1)));
		auxPanel.add(productInfo);
		auxPanel.setBorder(null);

		productDescription = new JTextArea(10, 10);
		productDescription.setText(item.getDesc());
		productDescription.setLineWrap(true);
		productDescription.setBackground(null);
		productDescription.setOpaque(false);
		productDescription.setFocusable(false);
		productDescription.setFont(new Font("Arial", 0, 22));
		productDescription.setBorder(null);
		productDescription.setLineWrap(true);
		productDescription.setWrapStyleWord(true);
	}

	private void generateTextPane(JTextPane textPane, String text, Color color, Font font) {
		textPane.setText(text);
		textPane.setFont(font);
		textPane.setEditable(false);
		textPane.setForeground(color);
		textPane.setBackground(null);
		textPane.setOpaque(false);
		textPane.setFocusable(false);
		textPane.setBorder(null);
	}
}
