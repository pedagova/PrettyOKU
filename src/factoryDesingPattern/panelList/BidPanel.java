package factoryDesingPattern.panelList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;
import factoryDesingPattern.BasicPanel;
import utils.Utils;

public class BidPanel extends BasicPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton increasePrice;
	private JButton refreshPrice;
	private JTextField priceInput;

	private JTextArea productInfo;

	private GridBagConstraints gbc;

	private ItemVO item;
	
	public BidPanel(Dimension dimension, Controler ctrl) {
		super.setPreferredSize(dimension);
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createTitledBorder("BID INFORMATION"));
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		this.gbc = new GridBagConstraints();
		this.productInfo = new JTextArea();
		this.productInfo.setAlignmentX(RIGHT_ALIGNMENT);
		this.productInfo.setEditable(false);
		this.productInfo.setBackground(new Color(232,232,232));
		this.priceInput = new JTextField();

		this.increasePrice = new JButton("New item price");
		this.increasePrice.setAlignmentX(RIGHT_ALIGNMENT);
		this.increasePrice.addActionListener(new ActionListener() {

			private Integer newValue = null;

			@Override
			public void actionPerformed(ActionEvent e) {
				newValue = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor numerico:"));
				priceInput.setText(newValue.toString());
				
				// meter en base de datos
				item.setPrice(newValue.toString());
				setInfo(item);
			}
		});
		

		this.refreshPrice = new JButton("Refresh info");
		

	}

	@Override
	public void initGUI() {
		this.gbc.gridx = 0;
		++this.gbc.gridy;
		this.add(this.productInfo, this.gbc);
		++this.gbc.gridy;
		this.add(this.increasePrice, this.gbc);
		++this.gbc.gridy;
		this.add(this.refreshPrice, this.gbc);

	}

	public void setInfo(ItemVO item) {
		this.item = item;
		this.productInfo.setText(null);
		this.productInfo.append("Product owner : " + item.getIdOwner() + "\n");
		this.productInfo.append("Current bidder : " + item.getIdLastBidder() + "\n");
		this.productInfo.append("Current price: " + item.getPrice());
		this.repaint();
	}

	public static void main(String[] arg) {
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		} catch (Exception e) {
			System.err.print("Error at Look And Feel");
		}
		JFrame frame = new JFrame();
		frame.setPreferredSize(Utils.reSize(0.2, 0.3));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.add(new BidPanel(Utils.reSize(0.2, 0.3), new Controler()));
		frame.setVisible(true);
	}

}
