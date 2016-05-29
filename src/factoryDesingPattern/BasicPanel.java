package factoryDesingPattern;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;
import utils.Utils;

public abstract class BasicPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Controler ctrl;

	protected final static double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	protected final static double screenWidht = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	protected final static ComponentFactory factory = new ComponentFactory();
	
	public abstract void initComponets();

	public abstract void initGUI();

	protected void generateTextPane(JTextPane component, String data) {
		component.setBackground(null);
		component.setContentType("text/html");
		component.setText(data);
		component.setEditable(false);
		component.setFont(new Font(data, 10, 28));
		component.setVisible(true);
		//component.setPreferredSize(Utils.adjustDimension(0.6, dimension, this.getPreferredSize()));
	}

	protected void generateTextField(JTextField component, String data, double dimension) {
		component.setVisible(true);
		component.setText(data);
		//component.setPreferredSize(Utils.adjustDimension(0.6, dimension, this.getPreferredSize()));
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
				JPanel pan = new JPanel();
				pan.setLayout(new FlowLayout());

				pan.add(new JLabel("label"));
				pan.add(new JButton("button"));

				JDialog jd = new JDialog();

				jd.add(pan);
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
				JTextArea text = new JTextArea();
				text.setEditable(false);
				text.setText(setText());
				JDialog dialog = new JDialog(new JFrame(), title, true);

				dialog.setPreferredSize(new Dimension(500, 500));
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(null);
				JOptionPane pane = new JOptionPane();
				pane.add(text);
				pane.showMessageDialog(BasicPanel.this, "hi");
				// JOptionPane.showMessageDialog(new JFrame(), "Eggs are not
				// supposed to be green.", "A plain message",
				// JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

	private String setText() {
		String chain = "";
		for (int i = 0; i < 500; ++i) {
			chain += i + "";
			chain += "\n";
		}
		return chain;
	}

	protected void generateRegisterButton(Dimension dimension, String name, JButton button) {

	}

	protected void generateProductListButton(Dimension dimension, String name, JButton button, Color color) {
		button.setText("<HTML><font size=\"6\"><FONT color=\"#000099\"><U>" + name + "</U></FONT></font></HTML>");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBorderPainted(false);
		button.setOpaque(false);
		button.setBackground(new Color(232, 232, 232));
	}

	protected void generateProductPanel(Dimension dimension, ItemVO item, JButton button, ComponentFactory factory) {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame(item.getName());
				frame.setLocationRelativeTo(null);
				frame.add(factory.getPanel(PanelType.ITEM_PANEL, dimension, ctrl));
				frame.pack();
				frame.setVisible(true);

			}
		});

	}
}
