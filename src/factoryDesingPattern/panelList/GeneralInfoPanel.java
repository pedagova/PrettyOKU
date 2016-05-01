package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import factoryDesingPattern.Panel;

public class GeneralInfoPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton[] buttons = new JButton[12];

	static final String[] buttonNames = { "...", "Payment methods", "Currency converter", "Shipping policy",
			"Shipping rates", "VAD (value added tax) on assets", "...", "How to add products?", "How to bid?", "...",
			"Logistics", "..." };

	/*
	 * static final String[] buttonDescription = { "...", "Payment methods",
	 * "Currency converter", "Shipping policy", "Shipping rates",
	 * "VAD (value added tax) on assets", "...", "How to add products?",
	 * "How to bid?", "...", "Logistics", "..." };
	 */
	
	

	public GeneralInfoPanel(Dimension dimension) {
		super.setPreferredSize(dimension);
		this.setLayout(new GridLayout(6, 2));
		this.setBorder(new TitledBorder(new EtchedBorder(), "General Information", 1, 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		for (int i = 0; i < this.buttons.length; ++i) {
			this.buttons[i] = new JButton();
			this.buttons[i].setText(GeneralInfoPanel.buttonNames[i]);
			this.buttons[i].setToolTipText("Click this button for see " + GeneralInfoPanel.buttonNames[i].toLowerCase());
			this.buttons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					JButton button = (JButton) arg0.getSource();
					
					System.out.println(button.getText());
					// TODO Auto-generated method stub

				}
			});
			this.buttons[i].setVisible(true);
		}
		this.setVisible(true);

	}

	@Override
	public void initGUI() {
		for(JButton button : this.buttons){
			this.add(button);
		}

	}
	
	public static void main(String[] arg) {
		
		JFrame frame = new JFrame("Product List");
		frame.setVisible(true);
		frame.setSize(500, 500);
		
		GeneralInfoPanel productPanel = new GeneralInfoPanel(new Dimension(500, 600));
		frame.add(productPanel);
		frame.pack();

	}

}
