package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import factoryDesingPattern.BasicPanel;

public class ItemPanel extends BasicPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemPanel(Dimension dimension){
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(dimension);
		//this.setBorder(new TitledBorder(new EtchedBorder(), "USER LOGIN", 1, 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();
	}
	@Override
	public void initComponets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initGUI() {
		// TODO Auto-generated method stub
		
	}

}
