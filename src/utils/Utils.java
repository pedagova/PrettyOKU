
package utils;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import Decoder.BASE64Encoder;
import ch.randelshofer.quaqua.ext.base64.Base64;

public class Utils {

	public static Dimension reSize(double width, double height) {
		return new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * width),
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * height));
	}

	public static Dimension adjustDimension(double width, double height, Dimension dimension) {
		return new Dimension((int) (dimension.getWidth() * width), (int) (dimension.getHeight() * height));
	}

	public static Dimension newDim(double widht, double height, double wMod, double hMod) {
		return new Dimension((int) (widht * wMod), (int) (height * hMod));
	}

	/**
	 * Este método coje una cadena (la imagen) y la devuelve codificada
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

	/**
	 * Este método coje una imagen y genera un string apartir de ella
	 * 
	 * @param image
	 * @param type
	 * @return
	 */
	public static String decodeImage(BufferedImage image, String type) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ImageIO.write((RenderedImage) image, type, bos);
		} catch (IOException e) {
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
		}
		byte[] imageBytes = bos.toByteArray();

		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(imageBytes);

	}

	// poner concatenadores de texto para base de datos

	public static void main(String args[]) {
		BufferedImage bImage = new BufferedImage(200, 200, 1);

		System.out.println(Utils.decodeImage(bImage, "jpg"));
	}
}
