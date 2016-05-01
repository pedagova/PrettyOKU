
package utils;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Utils {

	public static Dimension reSize(double width, double height) {
		return new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * width),
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * height));
	}
	
	public static Dimension adjustDimension(double width, double height, Dimension dimension) {
		return new Dimension((int) (dimension.getWidth()*width), (int) (dimension.getHeight()*height));
	}
}
