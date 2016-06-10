package view.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;
import exceptions.ActPriceException;
import exceptions.NotLoggedException;
import view.ViewUtilities;

public class ShowProduct extends JPanel {

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

	private JTextPane productName;

	private JTextPane productIdentifier;

	private JTextPane productCategory;

	private JTextPane productPrice;

	private JTextPane newPrice;

	private JButton updatePrice;

	private JTextField priceField;

	private JPanel inputPrice;

	private Controler ctrl;
	
	public ShowProduct(ItemVO it, Controler ctrl) {
		item = it;
		this.ctrl = ctrl;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponent();
		initGUI();
	}

	private void initGUI() {
		add(Box.createRigidArea(new Dimension(1, 50)));
		add(title);
		add(auxPanel);
		add(inputPrice);
		add(productDescription);

	}

	private void initComponent() {
		// title
		title = new JTextPane();
		generateTextPane(title, item.getDesc().toUpperCase(), new Color(255,96,0));

		productName = new JTextPane();
		generateTextPane(productName, " >Bid: " + item.getName(), new Color(0,0,0));

		productIdentifier = new JTextPane();
		generateTextPane(productIdentifier, " >Product cod.: " + item.getId(), new Color(0,0,0));

		productCategory = new JTextPane();
		generateTextPane(productCategory, " >Product category.: " + item.getIdCategory(), new Color(0,0,0));

		productPrice = new JTextPane();
		generateTextPane(productPrice, " >Product price.: " + item.getPrice() + "€", new Color(0,0,0));

		newPrice = new JTextPane();
		generateTextPane(newPrice, " >Put the new price:", new Color(0,0,0));

		priceField = new JTextField();
		
		updatePrice = new JButton("Increase price");
		updatePrice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int i = Integer.parseInt(priceField.getText());
					try {
						ctrl.actPrice(item, i);
					} catch (NotLoggedException | ActPriceException e1) {
						JOptionPane.showMessageDialog(null,
								e1.getMessage(),
							    "Inane error",
							    JOptionPane.ERROR_MESSAGE);
						priceField.setText("");
					}
					ShowProduct.this.productPrice.setText(" >Product price.: " + i + "€");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
						    "El precio ha de ser numérico",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
					priceField.setText("");
				}
			}
		});

		inputPrice = new JPanel();
		inputPrice.setPreferredSize(new Dimension(1, 25));
		inputPrice.setLayout(new BoxLayout(inputPrice, BoxLayout.X_AXIS));
		inputPrice.add(newPrice);
		inputPrice.add(priceField);
		inputPrice.add(updatePrice);

		// image label
		BufferedImage im = ViewUtilities.encodeImage(item.getImg());
		imageLabel = new JLabel(new ImageIcon(im.getScaledInstance(230, 200, Image.SCALE_DEFAULT)));
		imageLabel.setPreferredSize(new Dimension(300, 300));
		imageLabel.setBorder(BorderFactory.createLineBorder(Color.red));

		
		
		
		productInfo = new JPanel();
		productInfo.setPreferredSize(new Dimension(200, 300));
		productInfo.setLayout(new BoxLayout(productInfo, BoxLayout.Y_AXIS));
		productInfo.add(productName);
		productInfo.add(productIdentifier);
		productInfo.add(productCategory);
		productInfo.add(productPrice);
		productInfo.add(Box.createRigidArea(new Dimension(1, 100)));
		productInfo.setBorder(BorderFactory.createLineBorder(Color.red));

		auxPanel = new JPanel();
		auxPanel.add(imageLabel);
		auxPanel.add(productInfo);
		auxPanel.setBorder(BorderFactory.createLineBorder(Color.red));

		productDescription = new JTextArea();
		productDescription.setText(item.getDesc() + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
				+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
		productDescription.setLineWrap(true);
		productDescription.setBackground(null);
		productDescription.setOpaque(false);
		productDescription.setFocusable(false);
		productDescription.setBorder(BorderFactory.createLineBorder(Color.red));

	}

	private void generateTextPane(JTextPane textPane, String text, Color color) {
		textPane.setText(text);
		textPane.setFont(new Font("Arial", 16, 16));
		textPane.setEditable(false);
		textPane.setForeground(color);
		textPane.setBackground(null);
		textPane.setOpaque(false);
		textPane.setFocusable(false);
		textPane.setBorder(BorderFactory.createLineBorder(Color.red));
	}

	/*public static void main(String[] args) {
		JFrame frame = new JFrame("example");
		frame.pack();
		frame.setResizable(false);
		ShowProduct user = new ShowProduct(null);
		user.setVisible(true);
		frame.add(user);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}*/

}
