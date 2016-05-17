package factoryDesingPattern;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import controller.Controler;
import factoryDesingPattern.panelList.ItemPanel;
import utils.Utils;

public abstract class BasicPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Controler ctrl = new Controler();
	
	public abstract void initComponets();

	public abstract void initGUI();
	
	protected void generateTextPane(JTextPane component, String data, double dimension) {
		component.setBackground(null);
		component.setContentType("text/html");
		component.setText(data);
		component.setEditable(false);
		component.setFont(new Font(data, 10, 28));
		component.setVisible(true);
		component.setPreferredSize(Utils.adjustDimension(0.9, dimension, this.getPreferredSize()));
	}

	protected void generateTextField(JTextField component, String data, double dimension) {
		component.setVisible(true);
		component.setText(data);
		component.setPreferredSize(Utils.adjustDimension(0.9, dimension, this.getPreferredSize()));
	}

	protected void generateButton(JButton component, String data, double dimension) {
		component.setBackground(null);
		component.setText(data);
		component.setFont(new Font(data, 10, 14));
		component.setVisible(true);
		component.setPreferredSize(Utils.adjustDimension(0.9, dimension, this.getPreferredSize()));
	}

	protected void genereteLinkButton(JButton component, String data, double dimension) {
		component.setText("<HTML><font size=\"6\"><FONT color=\"#000099\"><U>" + data + "</U></FONT></font></HTML>");
		component.setHorizontalAlignment(SwingConstants.LEFT);
		component.setBorderPainted(false);
		component.setOpaque(false);
		component.setBackground(new Color(232,232,232));
		component.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame j = new JFrame();
				j.setPreferredSize(new Dimension(600, 600));
				j.setVisible(true);
				j.add(new ItemPanel(new Dimension(500, 500)));
			}
		});
	}
}
