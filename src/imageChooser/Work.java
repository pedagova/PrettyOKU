package imageChooser;


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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import ch.randelshofer.quaqua.ext.base64.Base64;

public class Work extends JFrame {
	JButton button;
	JLabel label;

	public Work() {
		super("Set Picture Into A JLabel Using JFileChooser In Java");
		button = new JButton("Browse");
		button.setBounds(300, 300, 100, 40);
		label = new JLabel();
		label.setBounds(10, 10, 670, 250);
		add(button);
		add(label);

		button.addActionListener(new ActionListener() {

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

		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(700, 400);
		setVisible(true);
	}

	// Methode to resize imageIcon with the same size of a Jlabel
	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
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
			FileOutputStream imageOutFile = new FileOutputStream(
					ImagePath);

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
			//Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
	
	public static void main(String[] args) {
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		// set the Quaqua Look and Feel in the UIManager
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
			// set UI manager properties here that affect Quaqua
		} catch (Exception e) {
			// take an appropriate action here
		}
		new Work();

		
	}
}
