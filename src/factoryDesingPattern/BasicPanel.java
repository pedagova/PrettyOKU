package factoryDesingPattern;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import factoryDesingPattern.panelList.BidPanel;
import factoryDesingPattern.panelList.ItemPanel;
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
		// component.setPreferredSize(Utils.adjustDimension(0.6, dimension,
		// this.getPreferredSize()));
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
		component.setHorizontalAlignment(SwingConstants.LEFT);
		component.setBorderPainted(false);
		component.setOpaque(false);
		component.setBackground(null);
	}

	protected void genereteBottonBarButton(JButton component, String data, double dimension, int option) {
		component.setText("<HTML><font size=\"6\"><FONT color=\"#000099\"><U>" + data + "</U></FONT></font></HTML>");
		component.setHorizontalAlignment(SwingConstants.CENTER);
		component.setBorderPainted(false);
		component.setOpaque(false);
		component.setBackground(null);
		component.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame(data);
				frame.setSize(1000,800);

				frame.setLocationRelativeTo(null);
				frame.setVisible(false);
				JPanel panel = new JPanel();
				panel.setPreferredSize(new Dimension(1000,800));
				JTextArea area = new JTextArea();
				area.setLineWrap(true);
				area.setWrapStyleWord(true);
				area.setEditable(false);
				area.setFont(new Font("Times New Roman", 16, 20));
				switch (option) {
				case 0:
					area.append("In 2002 the company emerges exploiting the niche left by sales through the web ." + "\n");
					area.append("The corporate purpose of this company is primarily directed toward consumers interested in products of nature ' otaku ' who usually are hard to find." + "\n");
					area.append("At first , based on this idea and doing a market study on the possible billing that such objects could represent in the economy of the company, we proceed to make an improvement that encompasses both products that can be sold first choice as all those who may be subject to auction , which increase the range of users , allowing interaction between them through bids. In addition, also it carried out a marketing campaign , improving positioning through search engines.");
					area.append("Later, due to the rise of the company and the great impact that had the appearance of applications of buying and selling online for mobile devices, takes advantage of this opportunity to create an application that retained all the functionality of the website and also benefited accessibility offered by mobile devices, providing our customers access to our products." + "\n");
					area.append("This project has been developed by qualified students from the Complutense University of Madrid who have managed to combine the security to be transmitted to the customer with technological innovation , very present today. Today the company continues to grow , so we are grateful for the benefits.");
					
					frame.add(area);
					frame.setVisible(true);
					break;
				case 1:
					area.append("The following credit and debit cards can be used as payment:" + "\n");
					area.append(" -Visa" + "\n");
					area.append(" -Delta" + "\n");
					area.append(" -Visa Electron" + "\n");
					area.append(" -MasterCard" + "\n");
					area.append(" -EuroCard" + "\n");
					area.append(" -American Express" + "\n");
					area.append(" -UK based Maestro and Solo cards" + "\n");
					area.append("If you're paying for your order using a credit or UK debit card you'll be asked to enter your card details as part of the ordering process, and you'll find further instructions when you place your first order." + "\n");
					area.append("There are certain payment methods that you can't. We don't accept:" + "\n");
					area.append(" -Cheques or postal orders." + "\n");
					area.append(" -Cash in any currency." + "\n");	
					frame.add(area);
					frame.setVisible(true);
					break;
				case 2:
					area.append("Cost" + "\n");
					area.append("We calculate the total weight of the items you’ve ordered and apply the appropriate delivery rate." + "\n");
					area.append("Media: £1.99 per delivery on orders weighing up to 0.5kg and £2.99 on orders weighing above 0.5kg. Media consists of Music, DVD, Video Games and Software." + "\n");
					area.append("Books: £2.99 per delivery.");
					area.append("All other product categories: £3.99 per delivery on orders weighing up to 0.5kg and £4.75 per delivery on orders weighing above 0.5kg." + "\n");
					area.append("For orders from multiple product categories, the higher per delivery rate will apply." + "\n");
					area.append("If your order includes £10 or more of eligible books, or £20 or more of eligible items across any product category, your order will qualify for FREE Standard Pickup. Terms and Conditions apply." + "\n");
					area.append("\n" + "Delivery Time" + "\n");
					area.append("1 to 2 business days after dispatch." + "\n");
					area.append("\n" + "Details" + "\n");
					area.append("We’ll show you your total delivery cost during checkout." + "\n");
					area.append("Prime members can get Standard Delivery at no additional cost." + "\n");
					area.append("First Class Delivery has been renamed Standard Delivery, however, you'll still find the same selection of items and same service you've experienced under the First Class Delivery name." + "\n");
					frame.add(area);
					frame.setVisible(true);
					break;
				case 3:
										
					frame.add(area);
					frame.setVisible(true);
					break;
				case 4:
					int confirmed = JOptionPane.showConfirmDialog(null, "Close programm?", "",
							JOptionPane.YES_NO_OPTION);

					if (confirmed == 0) {
						System.exit(0);
					}
					break;
				}
				frame.pack();
			}
		});

		/*
		 * component.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { JTextArea text
		 * = new JTextArea(); text.setEditable(false); text.setText(setText());
		 * JDialog dialog = new JDialog(new JFrame(), data, true);
		 * 
		 * dialog.setPreferredSize(new Dimension(500, 500));
		 * dialog.setVisible(true); dialog.setLocationRelativeTo(null);
		 * JOptionPane pane = new JOptionPane(); pane.add(text);
		 * pane.showMessageDialog(BasicPanel.this, "hi"); //
		 * JOptionPane.showMessageDialog(new JFrame(), "Eggs are not // supposed
		 * to be green.", "A plain message", // JOptionPane.PLAIN_MESSAGE); }
		 * });
		 */
	}


	protected void generateProductListButton(Dimension dimension, String name, JButton button, Color color) {
		button.setText("<HTML><font size=\"6\"><FONT color=\"#000099\"><U>" + name + "</U></FONT></font></HTML>");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBorderPainted(false);
		button.setOpaque(false);
		button.setBackground(null);
	}

	protected void generateProductPanel(Dimension dimension, ItemVO item, JButton button, ComponentFactory factory) {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame(item.getName());
				frame.setLocationRelativeTo(null);
				ItemPanel panel = (ItemPanel) factory.getPanel(PanelType.ITEM_PANEL, dimension, ctrl);
				panel.setInfo(item);
				frame.add(panel);
				frame.pack();
				frame.setVisible(true);

			}
		});

	}
}
