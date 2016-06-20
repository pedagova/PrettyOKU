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

	public TagList(Controler ctrl) {
		this.initComponent(ctrl);
		this.initGUI();

	}

	private void initGUI() {
		JButton modalTextPane = null;
		if (this.chain.length == 0) {
			this.generateComponent(modalTextPane, new Color(0), "  Empty category", new Font("Arial", 16, 16));
			return;
		} else {
			this.generateComponent(modalTextPane, new Color(0), "    " + ctrl.getCategory().getName(), new Font("Arial", 16, 20));
		}
		for (int i = 0; i < this.chain.length; ++i) {
			this.generateComponent(modalTextPane, new Color(255, 96, 0), "         > " + chain[i], new Font("Arial", 16, 16));
		}
	}

	private void generateComponent(JButton modalTextPane, Color color, String text, Font font) {
		modalTextPane = new JButton();
		modalTextPane.setFont(font);
		modalTextPane.setBackground(Color.white);
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
				ctrl.find(text.substring(11,text.length()));
				System.err.println(text.substring(11,text.length()));
			}
		});
		this.add(modalTextPane);
	}

	private void initComponent(Controler ctrl) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.white);
		this.ctrl = ctrl;
		this.chain = ctrl.getCategory().getChain();
	}

}
