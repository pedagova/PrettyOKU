package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

import factoryDesingPattern.BasicPanel;
import utils.Utils;

public class MainPanel extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginPanel login;
	
	private AuxPanel aux;
	
	private ListPanel list;
	
	private GeneralInfoPanel infoPanel;
	
	private GridBagConstraints gbc;
	
	public MainPanel(Dimension dimension){
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(dimension);
		//this.setBorder(new TitledBorder(new EtchedBorder(), "USER LOGIN", 1, 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();
		
	}
	
	
	public void initComponets() {
		this.gbc = new GridBagConstraints();
		this.login = new LoginPanel(Utils.adjustDimension(0.3, 0.3, this.getPreferredSize()));
		this.aux = new AuxPanel(Utils.adjustDimension(0.3, 0.4, this.getPreferredSize()));
		this.list  =new ListPanel(Utils.adjustDimension(0.7, 0.7, this.getPreferredSize()));
		this.infoPanel  = new GeneralInfoPanel(Utils.adjustDimension(1, 0.3, this.getPreferredSize()));
		
	}

	
	
	public void initGUI() {
		this.adjustGrid(0, 0);
		this.add(this.login, this.gbc);
		this.adjustGrid(1,1);
		this.add(this.aux, this.gbc);
		this.adjustGrid(2,2);
		this.add(this.list, this.gbc);
		this.adjustGrid(3,3);
		this.add(this.infoPanel, this.gbc);
		
	}
	
	private void adjustGrid(int x, int y){
		this.gbc.gridx=x;
		this.gbc.gridy=y;
	}
	
	public static void main(String[] arg) {		
		MainPanel main = new MainPanel(Toolkit.getDefaultToolkit().getScreenSize());
		main.getExtendedState();
		main.setLocationRelativeTo(null);
		main.setVisible(true);
		
	}

}
