package factoryDesingPattern.panelList;

import java.awt.Dimension;

import javax.swing.JPanel;

public class AuxPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuxPanel(Dimension dimension){
		this.setPreferredSize(dimension);
		this.setVisible(true);
	}
}
