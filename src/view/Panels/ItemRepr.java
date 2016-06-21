package view.Panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;
import view.ViewUtilities;

public class ItemRepr extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ----------anonimus class--------------
	private class Separator extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Separator(Dimension d, Color c) {
			this.setPreferredSize(d);
			this.setMaximumSize(d);
			this.setBackground(c);
		}
	}
	// ---------end anonimus class----------

	// -------------Attributes---------------
	private ItemVO item;
	final private String font = "Cambria";
	// ---------------------------------------

	public ItemRepr(ItemVO it, Controler ctrl) {
		super(ctrl);
		this.item = it;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleMouseClicked();
			}
		});
		initGUI();
	}

	private void handleMouseClicked() {
		ctrl.itemChose(new ShowProduct(item, ctrl));
	}

	private void initGUI() {
		// ---------------general GUI-------------------
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// GridBagConstraints gbc = new GridBagConstraints()
		setPreferredSize(new Dimension(250, 260));
		setBackground(new Color(255, 255, 255));
		setBorder((BorderFactory.createLineBorder(Color.gray)));
		// -----------end general GUI--------------------

		// ----------------image-------------------------
		BufferedImage im;

		im = ViewUtilities.encodeImage(ViewUtilities.formatedString(item.getImg()));
		// 260 256
		JLabel imageLabel = new JLabel(new ImageIcon(im.getScaledInstance(230, 200, Image.SCALE_DEFAULT)));

		imageLabel.setPreferredSize(new Dimension(230, 200));
		imageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		JPanel image = new JPanel();
		image.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		image.setBackground(null);
		image.add(imageLabel, gbc);
		image.setOpaque(true);
		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(230, 200));
		p2.setBackground(null);
		p2.add(Box.createRigidArea(new Dimension(230, 170)));
		image.add(p2, gbc);
		// ----------------end Image---------------------------

		// ---------------tex-------------------------------
		// 50 256
		String info;

		try {
			info = item.getName().substring(0, item.getName().substring(0, 74).lastIndexOf(' ')) + "\n" + item.getPrice() + "£";
		} catch (IndexOutOfBoundsException e) {
			info = item.getName()+ "\n" + item.getPrice() + "£";
		}

		JTextArea textLabel = new JTextArea(info);
		textLabel.setLineWrap(true);
		textLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				handleMouseExited();
			}

			private void handleMouseExited() {
				textLabel.setFont(new Font(font, Font.PLAIN, 14));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				handleMouseEntered();
			}

			private void handleMouseEntered() {
				Font font = textLabel.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_ONE_PIXEL);
				textLabel.setFont(font.deriveFont(attributes));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				handleMouseClicked();
			}

		});

		textLabel.setPreferredSize(new Dimension(240, 35));
		textLabel.setFont(new Font(font, Font.PLAIN, 14));

		textLabel.setBackground(null);
		textLabel.setEditable(false);

		// ----------------end text------------------------

		// -----------place componenents-----------------------

		add(image);

		add(new Separator(new Dimension(230, 1), Color.GRAY));

		add(textLabel);

	}

	// ----------testing---------------

	// ------------------------------
}
