package factoryDesingPattern.panelList;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;
import factoryDesingPattern.BasicPanel;
import factoryDesingPattern.PanelType;
import utils.Utils;

public class ItemPanel extends BasicPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImagePanel image;

	private ItemInfoPanel info;

	private BidPanel bid;

	public ItemPanel(Dimension dimension, Controler ctrl){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(dimension);
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		this.image = (ImagePanel) BasicPanel.factory.getPanel(PanelType.IMAGE_PANEL,
				Utils.newDim(this.getPreferredSize().getWidth(), this.getPreferredSize().getHeight(), 0.4, 0.4), ctrl);
		this.bid = (BidPanel) BasicPanel.factory.getPanel(PanelType.BID_PANEL,
				Utils.newDim(this.getPreferredSize().getWidth(), this.getPreferredSize().getHeight(), 0.6, 0.4), ctrl);
		this.info = (ItemInfoPanel) BasicPanel.factory.getPanel(PanelType.ITEM_INFO_PANEL,
				Utils.newDim(this.getPreferredSize().getWidth(), this.getPreferredSize().getHeight(), 1, 0.6), ctrl);
	}

	@Override
	public void initGUI() {
		JPanel horizntal = new JPanel();
		horizntal.setLayout(new BoxLayout(horizntal, BoxLayout.X_AXIS));
		horizntal.add(this.image);
		horizntal.add(this.bid);
		this.add(horizntal);
		this.add(info);

	}
	
	public void addItem(ItemVO item){
		
	}

	public static void main(String[] arg) {
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		} catch (Exception e) {
			System.err.print("Error at Look And Feel");
		}
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(1100,1100));
		frame.add(new ItemPanel(new Dimension(1000,1000), new Controler()));
		frame.setVisible(true);
		//frame.pack();
	}

}
