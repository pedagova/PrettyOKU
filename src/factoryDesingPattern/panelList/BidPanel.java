package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import controller.Controler;
import factoryDesingPattern.BasicPanel;
import utils.Utils;

public class BidPanel extends BasicPanel {

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
	private JButton increasePrice;
	private JButton refreshPrice;
	private JTextField priceInput;

	private JTextArea productInfo;

	private GridBagConstraints gbc;

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

		/*
		 * this.productInfo = new JTextArea(); this.currentBidderId = new
		 * JTextPane(); this.generateTextPane(this.currentBidderId,
		 * "  *Current bidder: " + "data base info");
		 */
		/*
		 * this.ownerId = new JTextPane(); this.generateTextPane(this.ownerId,
		 * "  *Product owner: " + "data base info");
		 */
		/*
		 * this.currentPrice = new JTextPane();
		 * this.generateTextPane(this.currentPrice, "  *Current price: " +
		 * "data base info");
		 */
		/*
		 * this.originalPrice = new JTextPane();
		 * this.generateTextPane(this.originalPrice, "  *Original price: " +
		 * "data base info");
		 */
		/*
		 * this.bidNumber = new JTextPane();
		 * this.generateTextPane(this.bidNumber, "  *Number of bids: " +
		 * "data base info");
		 */

		/*
		 * this.price = new JTextPane(); this.generateTextPane(this.price,
		 * "  *Product price: ");
		 */

		this.productInfo = new JTextArea();
		this.productInfo.setBackground(null);
		this.setInfo();
		this.priceInput = new JTextField();
		this.generateTextField(this.priceInput, "pedir a base de datos precio base", COMPONENT_DIMENSION_Y);

		this.increasePrice = new JButton();
		this.generateButton(increasePrice, "Increase item price", COMPONENT_DIMENSION_Y);

		this.refreshPrice = new JButton();
		this.generateButton(this.refreshPrice, "Refresh info", COMPONENT_DIMENSION_Y);

	}

	@Override
	public void initGUI() {
		/*
		 * JPanel panel = new JPanel(); panel.setLayout(new BoxLayout(panel,
		 * BoxLayout.X_AXIS)); panel.add(this.price); panel.add(new
		 * JPanel().add(this.priceInput));
		 */
		/*
		 * ++this.gbc.gridy; this.add(this.currentBidderId, this.gbc);
		 * ++this.gbc.gridy; this.add(this.ownerId, this.gbc); ++this.gbc.gridy;
		 * this.add(this.currentPrice, this.gbc); ++this.gbc.gridy;
		 * this.add(this.originalPrice, this.gbc); ++this.gbc.gridy;
		 * this.add(this.bidNumber, this.gbc); ++this.gbc.gridy;
		 * this.add(this.price, this.gbc); ++this.gbc.gridy;
		 */

		this.gbc.gridx=0;
		++this.gbc.gridy;

		this.add(this.productInfo, this.gbc);
		++this.gbc.gridy;

		this.add(this.increasePrice, this.gbc);
		++this.gbc.gridy;
		this.add(this.priceInput, this.gbc);
		++this.gbc.gridy;
		this.add(this.refreshPrice, this.gbc);

	}

	private void setInfo() {
		this.productInfo.append("  *Current bidder: " + "data base info" + "\n");
		this.productInfo.append("  *Product owner: " + "data base info"+ "\n");
		this.productInfo.append("  *Current price: " + "data base info"+ "\n");
		this.productInfo.append("  *Original price: " + "data base info"+ "\n");
		this.productInfo.append("  *Number of bids: " + "data base info"+ "\n");
		this.productInfo.append("  *Product price: " + "data base info");
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
