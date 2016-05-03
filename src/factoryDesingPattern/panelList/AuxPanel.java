package factoryDesingPattern.panelList;

import java.awt.Dimension;

import javax.swing.JPanel;

import factoryDesingPattern.Panel;

public class AuxPanel extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuxPanel(Dimension dimension){
		this.setPreferredSize(dimension);
		this.setVisible(true);
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
