import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class testing {
	/**
	 * Example of Fonts.
	 * 
	 * @author Chuidiang
	 *
	 */
	public static class FontsExample {

		public static void main(String[] args) throws InterruptedException {
			// List all available fonts.
			String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
			System.out.println(Arrays.toString(fontNames));

			// A windows with a label.
			JFrame frame = new JFrame("Fonts Example");
			JLabel label = new JLabel();
			label.setHorizontalAlignment(SwingConstants.CENTER);
			frame.getContentPane().add(label);
			frame.setSize(400, 100);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);

			// Show a text for each font
			for (String font : fontNames) {
				label.setText("Hi, I'm " + font);
				label.setFont(new Font(font, Font.PLAIN, 15));
				Thread.sleep(1000);
			}
		}
	}

	public static class Component extends JPanel {

		private static final int ARC_W = 45;
		private static final int ARC_H = 45;
		private static final int ELEMENTS = 30;

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// Colores basicos del panel
		private Color colorPrimario = new Color(255, 250, 250);
		private Color colorSecundario = new Color(241, 241, 241);
		private Color colorContorno = new Color(255, 255, 255);

		public Component() {
			super();
			// Componente de texto
			JTextArea panel = new JTextArea();
			panel.setLineWrap(true);
			panel.setWrapStyleWord(true);
			panel.setText("\n" + "Hola Permuta");
			panel.setEditable(false);
			panel.setPreferredSize(new Dimension(100, 150));
			panel.setOpaque(false);

			this.add(panel);
			this.initGUI();

		}

		private void initGUI() {

			this.setPreferredSize(new Dimension(120, 150));
			this.setVisible(true);
			setOpaque(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			// Controlamos los valores de los algoritmos de renderizado
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			Paint oldPaint = g2.getPaint();
			// Pintamos rectangulo 2d con bordes 45º
			RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight() - 1, ARC_W, ARC_H);
			// Metemos la nueva figura en el panel
			g2.clip(r2d);
			// Pintamos el color primario (amarillo)
			g2.setPaint(new GradientPaint(0.0f, 0/*getHeight() / 3*/, getColorPrimario().brighter(), 0.0f, getHeight(),
					getColorSecundario().darker()));
			// Añadimos al panel
			g2.fillRect(0, 0, getWidth(), getHeight());

			// Cramos el objeto usado durante la renderización
			g2.setStroke(new BasicStroke(4f));

			// Pintamos el borde
			g2.setPaint(new GradientPaint(0.0f, 0.0f, getColorContorno(), 0.0f, getHeight(), getColorContorno()));
			// Añadimos al panel
			g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, ARC_W, ARC_W);

			g2.setPaint(oldPaint);
			super.paintComponent(g);
		}

		public Color getColorPrimario() {
			return colorPrimario;
		}

		public Color getColorSecundario() {
			return colorSecundario;
		}

		public Color getColorContorno() {
			return colorContorno;
		}

		public static void main(String[] args) {
			JFrame frame = new JFrame();
			frame.setPreferredSize(new Dimension(1000, 1000));
			frame.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(2, 2, 5, 5);
			gbc.gridx = 0;
			gbc.gridy = 0;
			for (int i = 0; i < Component.ELEMENTS; ++i) {
				frame.add(new Component(), gbc);
				gbc.gridx++;
				if (gbc.gridx == 9) {
					gbc.gridx = 0;
					gbc.gridy++;
				}

			}
			frame.setVisible(true);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
	}

	public static void main(String[] args) {
		Component.main(null);

	}
}
