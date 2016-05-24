package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTextPane;

import factoryDesingPattern.BasicPanel;

public class UserPersonalInfo extends BasicPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * necesito que pidas un paquete con toda la info del user, luego yo la adapto para mostrala por pantalla
	 */

	private JTextPane userInfo;

	public UserPersonalInfo(Dimension dimension) {
		super.setPreferredSize(dimension);
		// this.setBorder(new TitledBorder(new EtchedBorder(), "BID
		// INFORMATION", 1, 1, new Font("", 9, 28)));
		// this.setBorder(BorderFactory.createTitledBorder("PRODUCT
		// INFORMATION"));
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		this.userInfo = new JTextPane();
	}

	@Override
	public void initGUI() {
		// TODO Auto-generated method stub

	}

}
