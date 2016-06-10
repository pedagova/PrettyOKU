package view.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import ch.randelshofer.quaqua.ext.base64.Base64;

public class NewAddItem extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel imageLabel;

	private JTextPane title;

	private JTextArea productDescription;

	private JPanel productInfo;

	private JPanel auxPanel;

	private JTextPane productName;

	private JComboBox<String> productCategory;

	private JTextPane productPrice;

	private JButton updatePrice;

	private JPanel showProduct;

	private JButton imageButton;
	
	public NewAddItem() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		initComponent();
		initGUI();
	}

	private void initGUI() {
		this.showProduct.add(Box.createRigidArea(new Dimension(1, 50)));
		this.showProduct.add(title);
		this.showProduct.add(auxPanel);
		this.showProduct.add(productDescription);
		this.add(Box.createRigidArea(new Dimension(300, 1)));
		this.add(showProduct);
		this.add(Box.createRigidArea(new Dimension(300, 1)));
	}

	private void initComponent() {
		imageButton = new JButton("Add image");
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
				// if the user click on save in Jfilechooser
				else if (result == JFileChooser.CANCEL_OPTION) {
					System.out.println("No File Select");
				}
			}
		});
		
		this.showProduct = new JPanel();
		this.showProduct.setBackground(Color.white);
		this.showProduct.setLayout(new BoxLayout(this.showProduct, BoxLayout.Y_AXIS));
		this.setBackground(Color.white);
		// title
		title = new JTextPane();
		generateTextPane(title, "Put here the product title", new Color(255, 96, 0));

		productName = new JTextPane();
		generateTextPane(productName, "Put here the product name", new Color(0, 0, 0));

		String[] categories = new String[5];
		for (int i = 0; i < 5; ++i) {
			categories[i] = "Categorie " + i;
		}
		productCategory = new JComboBox<String>(categories);

		productPrice = new JTextPane();
		generateTextPane(productPrice, " Put the price in �", new Color(0, 0, 0));

		updatePrice = new JButton("Increase price");
		updatePrice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int i = Integer.parseInt(productPrice.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "El precio ha de ser num�rico", "Inane error",
							JOptionPane.ERROR_MESSAGE);
					productPrice.setText(" Put the price in �");
				}
			}
		});

		// image label
		ImageIcon image = new ImageIcon("C:/Users/Javi/git/PrettyOKU/src/images/empty.png");
		imageLabel = new JLabel(image);
		imageLabel.setPreferredSize(new Dimension(400, 400));
		imageLabel.setBorder(null);
		imageLabel.setVisible(true);
		imageLabel.setBackground(Color.white);

		productInfo = new JPanel();
		productInfo.setPreferredSize(new Dimension(200, 300));
		productInfo.setBackground(Color.white);
		productInfo.setLayout(new BoxLayout(productInfo, BoxLayout.Y_AXIS));
		productInfo.add(productName);
		productInfo.add(productPrice);
		productInfo.add(productCategory);
		productInfo.add(imageButton);

		productInfo.add(Box.createRigidArea(new Dimension(1, 100)));
		productInfo.setBorder(null);

		auxPanel = new JPanel();
		auxPanel.setBackground(Color.white);
		auxPanel.add(imageLabel);
		auxPanel.add(productInfo);
		auxPanel.setBorder(null);

		productDescription = new JTextArea(10, 10);
		productDescription.setText("Put here the item description");
		productDescription.setLineWrap(true);
		productDescription.setBackground(null);
		productDescription.setOpaque(false);
		productDescription.setEditable(true);
		productDescription.setFocusable(true);
		productDescription.setFont(new Font("Arial", 0, 22));
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

	private void generateTextPane(JTextPane textPane, String text, Color color) {
		textPane.setText(text);
		textPane.setFont(new Font("Arial", 16, 16));
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

	/*
	 * public static void main(String[] args) { JFrame frame = new
	 * JFrame("example"); frame.pack(); frame.setResizable(false); ItemVO userVO
	 * = new ItemVO("hola", "nick", "forename",
	 * "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"
	 * ); ShowProduct user = new ShowProduct(userVO, null);
	 * user.setVisible(true); frame.add(user); frame.setVisible(true);
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.pack(); }
	 */

	
	
	
	
	// image methods
	
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

				// Converting a Base64 String into Image byte array
				byte[] imageByteArray = decodeImage(imageDataString);

				System.out.println(imageDataString);
				Base64TImage(imageDataString);
				// Write a image byte array into file system
				FileOutputStream imageOutFile = new FileOutputStream(ImagePath);

				imageOutFile.write(imageByteArray);

				imageInFile.close();
				imageOutFile.close();

				System.out.println("Image Successfully Manipulated!");
			} catch (FileNotFoundException e) {
				System.out.println("Image not found" + e);
			} catch (IOException ioe) {
				System.out.println("Exception while reading the Image " + ioe);
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
				System.out.println(imageCodif);
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(btDataFile));

				//JOptionPane.showMessageDialog(null, "", "Image", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image));

				/*
				 * byte[] btDataFile = new BASE64Decoder().decodeBuffer(base64);
				 * File of = new File("yourFile.png"); FileOutputStream osf = new
				 * FileOutputStream(of); osf.write(btDataFile); osf.flush();
				 */
			} catch (IOException ex) {
				// Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE,
				// null, ex);
			}

		}
}