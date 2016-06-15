package view.Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.Controler;
import model.Model;
import view.View2;

public class TagList extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Controler ctrl;

	private String[] chain;

	public TagList(Controler ctrl, String[] chain) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.initComponent(ctrl, chain);
		this.initGUI();

	}

	private void initGUI() {
		JButton modalTextPane = null;
		if (this.chain.length == 0) {
			this.generateComponent(modalTextPane, new Color(0), " Empty category", new Font("Arial", 16, 16));
			return;
		} else {
			this.generateComponent(modalTextPane, new Color(0), " " + Tags.VIDEO_GAMES, new Font("Arial", 16, 16));
		}
		for (int i = 0; i < this.chain.length; ++i) {
			this.generateComponent(modalTextPane, new Color(255, 96, 0), "  > " + chain[i], new Font("Arial", 16, 16));
		}
	}

	private void generateComponent(JButton modalTextPane, Color color, String text, Font font) {
		modalTextPane = new JButton();
		modalTextPane.setFont(font);
		modalTextPane.setForeground(color);
		modalTextPane.setText(text);
		modalTextPane.setOpaque(false);
		modalTextPane.setContentAreaFilled(false);
		modalTextPane.setBorderPainted(false);
		modalTextPane.setBorder(null);
		modalTextPane.setBorderPainted(false);
		modalTextPane.setFocusPainted(false);
		modalTextPane.setOpaque(true);
		modalTextPane.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello pene");
			}
		});
		this.add(modalTextPane);
	}

	private void initComponent(Controler ctrl, String[] chain) {
		this.ctrl = ctrl;
		this.chain = chain;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("example");
		frame.pack();
		frame.setBackground(new Color(0, 0, 0));
		String[] chain = { "aaaaaaaaaa", "bbbbbbbb", "cccccccc", "dddddddd", "eeeeeeeee", "ffffffffffffffffff",
				"sfdsdfs", "sdfsdfs", "sdfsfsd", "fhgfghfgh", "hjkhkhjk", "iyiyuy", "eteteter", "asdaad", "zczxczc",
				"xcvxcvxcv", "cvbnfggfh", "fdgdfgdfgd", "dfgdgdf", "dgdfgdf" };
		TagList user = new TagList(new Controler(new Model(), new View2()), chain);
		user.setVisible(true);
		frame.add(user);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
}
