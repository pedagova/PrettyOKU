package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import factoryDesingPattern.BasicPanel;

public class ItemPanel extends BasicPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImagePanel image;
	
	private ItemInfoPanel info;
	
	private BidPanel bid;
	
	public ItemPanel(Dimension dimension){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(dimension);
		//this.setBorder(new TitledBorder(new EtchedBorder(), "USER LOGIN", 1, 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();
	}
	@Override
	public void initComponets() {
		this.image = new ImagePanel(new Dimension(300,300));
		this.info = new ItemInfoPanel(new Dimension(800,500));
		this.bid  = new BidPanel(new Dimension(500,300));
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
	
	public static void main(String[] arg) {
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		} catch (Exception e) {
			System.err.print("Error at Look And Feel");
		}
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 200));
		frame.add(new ItemPanel(new Dimension(400, 100)));
		frame.setVisible(true);
		frame.pack();
	}


}
