package view;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import ch.randelshofer.quaqua.ext.base64.Base64;
import dataAccessObjectDesingPattern.ItemDao;
import utils.Utils;

/**
 * 
 * @author Permuta Date 31/05/2016 6:41 version 0.0.1
 */
public class ViewUtilities {
	/**
	 * 
	 * @param text
	 *            text shown at button
	 * @param fontSize
	 *            size of the font
	 * @param colorBack
	 *            backgroundColor
	 * @param ColorText
	 *            color to text
	 * @return return a JButton with the set information
	 */
	static public JButton generateButton(String text, String fontSize, Color colorBack, String ColorText) {

		JButton b = new JButton("<HTML><font size=\"" + fontSize + "\"><FONT color=\"" + ColorText + "\">" + text
				+ "</FONT></font></HTML>");
		b.setBackground(colorBack);
		b.setBorderPainted(false);

		return b;
	}

	/**
	 * 
	 * @param chain
	 * @return
	 */
	public static BufferedImage encodeImage(String chain) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new ByteArrayInputStream(Base64.decode(chain)));
		} catch (IOException e) {
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
		}
		return image;
	}

	public static String formatedString (String s){
		String[] g = s.split(" ");
		StringBuilder sb = new StringBuilder(""), c = new StringBuilder("");
		for(String h: g)
			sb.append(h + "+");
		sb.delete(0, 1);
		
		return sb.toString();
	}
}
