package view.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import ch.randelshofer.quaqua.ext.base64.Base64;
import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;
import exceptions.NotLoggedException;

public class NewAddItem extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String imageString; 
	
	private JLabel imageLabel;

	private JTextPane title;

	private JTextArea productDescription;

	private JPanel productInfo;

	private JPanel auxPanel;

	private JTextPane productLifeTime;

	private JComboBox<Tags> productCategory;

	private Vector<Tags> categories;

	private JTextPane productPrice;

	private JButton updatePrice;

	private JPanel showProduct;

	private JButton imageButton;
	
	private JButton addItem;

	private Controler ctrl;

	public NewAddItem(Controler ctrl) {
		categories = new Vector<Tags>();
		for(Tags t : Tags.values())
			categories.add(t);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.ctrl = ctrl;
		initComponent();
		initGUI();
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
		this.add(Box.createRigidArea(new Dimension(100, 1)));
	}

	private JSeparator generateSeparator() {
		JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setVisible(true);
		separator.setBorder(BorderFactory.createLineBorder(Color.black));
		return separator;
	}

	private void initComponent() {
		this.itemButton();
		this.generateImageButton();
		this.setBackground(Color.white);
		this.generateItemInfo();
		this.generateCentralPanel();
		this.generateDescription();
	}
	
	private void generateItemInfo(){
		
		this.showProduct = new JPanel();
		this.showProduct.setBackground(Color.white);
		this.showProduct.setLayout(new BoxLayout(this.showProduct, BoxLayout.Y_AXIS));

		// title
		title = new JTextPane();
		generateTextPane(title, "Put here the product title", new Color(255, 96, 0),new Font("Arial", 2, 28));
		
		productLifeTime = new JTextPane();
		generateTextPane(productLifeTime, "Put here the auction days", new Color(0, 0, 0),new Font("Arial", 2, 16));
		
		productCategory = new JComboBox<Tags>(categories);

		productPrice = new JTextPane();
		generateTextPane(productPrice, "Put the price in £", new Color(0, 0, 0),new Font("Arial", 2, 16));

		updatePrice = new JButton("Increase price");
		updatePrice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int i = Integer.parseInt(productPrice.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Price must be a number", "Error",
							JOptionPane.ERROR_MESSAGE);
					productPrice.setText(" Put the price in £");
				}
			}
		});

	}
	
	private void itemButton(){
		addItem = new JButton("Add item");
		addItem.setHorizontalAlignment(SwingConstants.CENTER);
		addItem.setVisible(true);
		addItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Integer.parseInt(productLifeTime.getText());
					try {
						ctrl.addItem(new ItemVO(title.getText(), productDescription.getText(),
								productPrice.getText(), imageString, (Tags)productCategory.getSelectedItem(), productLifeTime.getText()));
						JOptionPane.showMessageDialog(null, "Item added correctly", "information",
								JOptionPane.ERROR_MESSAGE);
						productPrice.setText("Put here the auction days");
					} catch (NotLoggedException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
						productPrice.setText("Put here the auction days");
					}	
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Duration must be a number", "Error",
							JOptionPane.ERROR_MESSAGE);
					productPrice.setText("Put here the auction days");
				}
							
			}
		});
	}
	private void generateImageButton(){
		imageButton = new JButton("Add image");
		imageButton.setHorizontalAlignment(SwingConstants.CENTER);
		imageButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				// filter the files
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				// if the user click on save in Jfilechooser
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					imageLabel.setIcon(ResizeImage(path));
				}
			}
		});
	}

	private void generateCentralPanel() {
		// image label
		ImageIcon image = new ImageIcon("src/images/empty.png");
		imageLabel = new JLabel(image);
		imageLabel.setPreferredSize(new Dimension(400, 400));
		imageLabel.setBorder(null);
		imageLabel.setVisible(true);
		imageLabel.setBackground(Color.white);

		productInfo = new JPanel();
		productInfo.setPreferredSize(new Dimension(200, 300));
		productInfo.setBackground(Color.white);
		productInfo.setLayout(new BoxLayout(productInfo, BoxLayout.Y_AXIS));
		productInfo.add(generateSeparator());
		productInfo.add(productLifeTime);
		productInfo.add(generateSeparator());
		productInfo.add(productPrice);
		productInfo.add(generateSeparator());
		productInfo.add(productCategory);
		productInfo.add(Box.createRigidArea(new Dimension(1, 100)));
		productInfo.setBorder(null);

		JPanel imagePanel = new JPanel();
		imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
		imagePanel.add(imageLabel);
		JPanel aux = new JPanel();
		aux.add(Box.createRigidArea(new Dimension(50, 1)));
		aux.setLayout(new GridLayout(1, 2));
		aux.add(imageButton);
		aux.add(addItem);
		aux.setBackground(null);
		imagePanel.add(aux);
		imagePanel.setBackground(Color.white);
		
		auxPanel = new JPanel();
		auxPanel.setBackground(Color.white);
		auxPanel.add(imagePanel);
		auxPanel.add(Box.createRigidArea(new Dimension(50, 1)));
		auxPanel.add(productInfo);
		auxPanel.setBorder(null);
	}

	private void generateDescription() {

		productDescription = new JTextArea(10, 10);
		productDescription.setText("Put here the item description");
		productDescription.setLineWrap(true);
		productDescription.setBackground(null);
		productDescription.setOpaque(false);
		productDescription.setEditable(true);
		productDescription.setFocusable(true);
		productDescription.setFont(new Font("Arial", 2, 22));
		productDescription.setBorder(null);
		productDescription.setLineWrap(true);
		productDescription.setWrapStyleWord(true);
		productDescription.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (productDescription.getText().equalsIgnoreCase("")) {
					productDescription.setText("Put here the item description");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (productDescription.getText().equalsIgnoreCase("Put here the item description")) {
					productDescription.setText(null);
				}
			}
		});
	}

	private void generateTextPane(JTextPane textPane, String text, Color color, Font font) {
		textPane.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if (textPane.getText().length() == 25) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (textPane.getText().length() == 25) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		textPane.setText(text);
		textPane.setFont(font);
		textPane.setEditable(true);
		textPane.setForeground(color);
		textPane.setBackground(null);
		textPane.setOpaque(false);
		textPane.setFocusable(true);
		textPane.setBorder(null);
		textPane.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (textPane.getText().equalsIgnoreCase("")) {
					textPane.setText(text);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (textPane.getText().equalsIgnoreCase(text)) {
					textPane.setText(null);
				}
			}
		});
	}

	// ---------------------------- METODOS PARA IMAGEN CHOOSER

	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);

		File file = new File(ImagePath);

		try {
			// Reading a Image file from file system
			FileInputStream imageInFile = new FileInputStream(file);
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);

			// Converting Image byte array into Base64 String
			String imageDataString = encodeImage(imageData);
			//System.out.println(imageDataString);
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = decodeImage(imageDataString);
			
			//System.out.println(imageData);
			
			//System.out.println(imageDataString);
			
			String[] s = imageDataString.toString().split("\n");
			imageString = "";
			for(String sAux : s){
				imageString += sAux;
			}
			Base64TImage(imageDataString);
			// Write a image byte array into file system
			FileOutputStream imageOutFile = new FileOutputStream(ImagePath);

			imageOutFile.write(imageByteArray);

			imageInFile.close();
			imageOutFile.close();

			// System.out.println("Image Successfully Manipulated!");
		} catch (FileNotFoundException e) {
			// System.out.println("Image not found" + e);
		} catch (IOException ioe) {
		}

		return image;
	}

	/**
	 * Encodes the byte array into base64 string
	 *
	 * @param imageByteArray
	 *            - byte array
	 * @return String a {@link java.lang.String}
	 */
	public static String encodeImage(byte[] imageByteArray) {
		return Base64.encodeBytes(imageByteArray);
	}

	/**
	 * Decodes the base64 string into byte array
	 *
	 * @param imageDataString
	 *            - a {@link java.lang.String}
	 * @return byte array
	 */
	public static byte[] decodeImage(String imageDataString) {
		return Base64.decode(imageDataString);
	}

	public static void Base64TImage(String base64) {
		try {

			byte[] btDataFile = Base64.decode(base64);
			String imageCodif = Base64.encodeBytes(btDataFile);
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(btDataFile));
		} catch (IOException ex) {

		}

	}
}
