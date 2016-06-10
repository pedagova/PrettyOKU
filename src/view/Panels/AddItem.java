package view.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import ch.randelshofer.quaqua.ext.base64.Base64;

public class AddItem extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextPane title;
	private JTextPane name;
	private JTextField nameRequest;
	private JTextPane description;
	private JScrollPane descriptionRequest;
	private JTextPane price;
	private JTextField priceRequest;
	private JTextArea descriptionRequestArea;
	private JPanel auxPanel;
	// Pedir datos al controlador sobre usuario actual

	private JButton createAccount;
	private JButton imageButton;
	private JLabel label;
	private JPanel auxPanelButton;

	public AddItem() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponent();
		initGUI();
	}

	private void initGUI() {
		add(Box.createRigidArea(new Dimension(1, 50)));
		add(title);
		add(name);
		add(nameRequest);
		add(description);
		add(descriptionRequest);
		add(auxPanel);
		add(auxPanelButton);
		add(label);
	}

	private void initComponent() {
		// title
		title = new JTextPane();
		generateTextPane(title, "NEW ITEM", new Color(255, 96, 0));
		// name
		name = new JTextPane();
		generateTextPane(name, "Put your name", Color.black);
		nameRequest = new JTextField(10);
		// description + scroll for description
		description = new JTextPane();
		generateTextPane(description, "Item description", Color.black);
		descriptionRequestArea = new JTextArea();
		descriptionRequestArea.setLineWrap(true);
		descriptionRequest = new JScrollPane(descriptionRequestArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		descriptionRequest.setPreferredSize(new Dimension(1, 300));
		// price panel
		price = new JTextPane();
		generateTextPane(price, "Item price", Color.black);
		priceRequest = new JTextField(10);
		auxPanel = new JPanel();
		auxPanel.setLayout(new BoxLayout(auxPanel, BoxLayout.X_AXIS));
		auxPanel.add(price);
		auxPanel.add(priceRequest);
		// button panel
		auxPanelButton = new JPanel();
		auxPanelButton.setLayout(new BoxLayout(auxPanelButton, BoxLayout.X_AXIS));
		createAccount = new JButton("Add item");
		label = new JLabel();
		label.setBounds(10, 10, 670, 250);
		label.setPreferredSize(new Dimension(200, 200));
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
					label.setIcon(ResizeImage(path));
				}
				// if the user click on save in Jfilechooser
				else if (result == JFileChooser.CANCEL_OPTION) {
					System.out.println("No File Select");
				}
			}
		});
		auxPanelButton.add(imageButton);
		auxPanelButton.add(createAccount);
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

	public static void main(String[] args) {
		JFrame frame = new JFrame("example");
		frame.pack();
		AddItem user = new AddItem();
		user.setVisible(true);
		frame.add(user);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	// ---------------------------- METODOS PARA IMAGEN CHOOSER

	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
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

			JOptionPane.showMessageDialog(null, "", "Image", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image));

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
