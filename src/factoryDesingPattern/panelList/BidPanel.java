package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import factoryDesingPattern.Panel;
import utils.Utils;

public class BidPanel extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextPane currentBidderId;
	private JTextPane ownerId;
	private JTextPane currentPrice;
	private JTextPane originalPrice;
	
	public BidPanel(Dimension dimension){
		super.setPreferredSize(dimension);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new TitledBorder(new EtchedBorder(), "BID INFORMATION", 1, 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();
	}
	
	@Override
	public void initComponets() {
		this.currentBidderId = new JTextPane();
		this.generateTextPane(this.currentBidderId, "Last bidder: "+"data base info", 0.3);
		
		this.ownerId = new JTextPane();
		this.generateTextPane(this.ownerId, "Product owner: "+"data base info", 0.3);
		
		this.currentPrice = new JTextPane();
		this.generateTextPane(this.currentPrice, "Current price: " + "data base info", 0.3);
		
		this.originalPrice = new JTextPane();
		this.generateTextPane(this.originalPrice, "Original price" + "data base info", 0.1);
		
		this.setVisible(true);
		
	}

	@Override
	public void initGUI() {
		this.add(this.currentBidderId);
		this.add(this.originalPrice);
		this.add(this.ownerId);
		this.add(this.originalPrice);
	}
	
	public static void main(String[] arg) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(Utils.reSize(0.35, 0.7));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.add(new BidPanel(Utils.reSize(0.35, 0.7)));
		frame.setVisible(true);
	}

}
