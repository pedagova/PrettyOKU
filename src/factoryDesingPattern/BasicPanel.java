package factoryDesingPattern;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import controller.Controler;
import factoryDesingPattern.panelList.ItemPanel;
import factoryDesingPattern.panelList.MainPanel;
import utils.Utils;

public abstract class BasicPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Controler ctrl;

	public abstract void initComponets();

	public abstract void initGUI();

	protected void generateTextPane(JTextPane component, String data, double dimension) {
		component.setBackground(null);
		component.setContentType("text/html");
		component.setText(data);
		component.setEditable(false);
		component.setFont(new Font(data, 10, 28));
		component.setVisible(true);
		component.setPreferredSize(Utils.adjustDimension(0.6, dimension, this.getPreferredSize()));
	}

	protected void generateTextField(JTextField component, String data, double dimension) {
		component.setVisible(true);
		component.setText(data);
		component.setPreferredSize(Utils.adjustDimension(0.6, dimension, this.getPreferredSize()));
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
		component.setBackground(new Color(232, 232, 232));
		component.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(), "Eggs are not supposed to be green.", "A plain message",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
	
	protected void genereteBottonBarButton(JButton component, String data, double dimension, int option) {
		String title = "nombre del cuadro";
		component.setText("<HTML><font size=\"6\"><FONT color=\"#000099\"><U>" + data + "</U></FONT></font></HTML>");
		component.setHorizontalAlignment(SwingConstants.CENTER);
		component.setBorderPainted(false);
		component.setOpaque(false);
		component.setBackground(new Color(232, 232, 232));
		component.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTextArea text =new JTextArea();
				text.setEditable(false);
				text.setText(setText());
				JDialog dialog = new JDialog(new JFrame(), title, true);
				
				dialog.setPreferredSize(new Dimension(500, 500));
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(null);
				JOptionPane pane = new JOptionPane();
				pane.add(text);
				pane.showMessageDialog(BasicPanel.this, "hi");
				//JOptionPane.showMessageDialog(new JFrame(), "Eggs are not supposed to be green.", "A plain message",
					//	JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
	
	private String setText(){
		String chain = "";
		for(int i=0; i<500; ++i){
			chain+=i+"";
			chain+="\n";
		}
		return chain;
	}
	
}
