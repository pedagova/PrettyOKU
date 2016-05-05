package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import factoryDesingPattern.Panel;

import utils.Utils;

public class BidPanel extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final double COMPONENT_DIMENSION_Y = 0.15;

	private JTextPane currentBidderId;
	private JTextPane ownerId;
	private JTextPane currentPrice;
	private JTextPane originalPrice;
	private JTextPane bidNumber;
	private JTextPane price;
	private JButton refreshPrice;
	
	public BidPanel(Dimension dimension) {
		super.setPreferredSize(dimension);
		this.setLayout(new GridLayout(7, 1));
		//this.setBorder(new TitledBorder(new EtchedBorder(), "BID INFORMATION", 1, 1, new Font("", 9, 28)));
		this.setBorder(BorderFactory.createTitledBorder("BID INFORMATION"));
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		this.currentBidderId = new JTextPane();
		this.generateTextPane(this.currentBidderId, "  *Current bidder: " + "data base info", COMPONENT_DIMENSION_Y);

		this.ownerId = new JTextPane();
		this.generateTextPane(this.ownerId, "  *Product owner: " + "data base info", COMPONENT_DIMENSION_Y);

		this.currentPrice = new JTextPane(); 
		this.generateTextPane(this.currentPrice, "  *Current price: " + "data base info", COMPONENT_DIMENSION_Y);

		this.originalPrice = new JTextPane();
		this.generateTextPane(this.originalPrice, "  *Original price: " + "data base info", COMPONENT_DIMENSION_Y);
		
		this.bidNumber = new JTextPane();
		this.generateTextPane(this.bidNumber, "  *Number of bids: " + "data base info", COMPONENT_DIMENSION_Y);
		
		this.price = new JTextPane();
		this.generateTextPane(this.price, "  *Product price: " + "data base info", COMPONENT_DIMENSION_Y);
		
		this.refreshPrice = new JButton();
		this.generateButton(this.refreshPrice, "Refresh info", COMPONENT_DIMENSION_Y);
		
	}

	@Override
	public void initGUI() {
		this.add(this.currentBidderId);
		this.add(this.ownerId);
		this.add(this.currentPrice);
		this.add(this.originalPrice);
		this.add(this.bidNumber);
		this.add(this.price);
		this.add(this.refreshPrice);
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
		frame.add(new BidPanel(Utils.reSize(0.2, 0.3)));
		frame.setVisible(true);
	}
}
