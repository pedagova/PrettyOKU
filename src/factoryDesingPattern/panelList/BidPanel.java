package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import factoryDesingPattern.Panel;
import utils.Utils;

public class BidPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final double COMPONENT_DIMENSION_Y = 0.2;

	private JTextPane currentBidderId;
	private JTextPane ownerId;
	private JTextPane currentPrice;
	private JTextPane originalPrice;
	private JTextPane bidNumber;
	
	public BidPanel(Dimension dimension) {
		super.setPreferredSize(dimension);
		this.setLayout(new GridLayout(5, 8));
		this.setBorder(new TitledBorder(new EtchedBorder(), "BID INFORMATION", 1, 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		this.currentBidderId = new JTextPane();
		this.generateTextPane(this.currentBidderId, "Current bidder: " + "data base info", COMPONENT_DIMENSION_Y);

		this.ownerId = new JTextPane();
		this.generateTextPane(this.ownerId, "Product owner: " + "data base info", COMPONENT_DIMENSION_Y);

		this.currentPrice = new JTextPane();
		this.generateTextPane(this.currentPrice, "Current price: " + "data base info", COMPONENT_DIMENSION_Y);

		this.originalPrice = new JTextPane();
		this.generateTextPane(this.originalPrice, "Original price: " + "data base info", COMPONENT_DIMENSION_Y);
		
		this.bidNumber = new JTextPane();
		this.generateTextPane(this.bidNumber, "Number of bids: " + "data base info", COMPONENT_DIMENSION_Y);
	}

	@Override
	public void initGUI() {
		this.add(this.currentBidderId);
		this.add(this.ownerId);
		this.add(this.currentPrice);
		this.add(this.originalPrice);
		this.add(this.bidNumber);
	}

	public static void main(String[] arg) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(Utils.reSize(0.2, 0.3));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.add(new BidPanel(Utils.reSize(0.2, 0.3)));
		frame.setVisible(true);
	}

}
