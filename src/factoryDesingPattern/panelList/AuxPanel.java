package factoryDesingPattern.panelList;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.Controler;
import factoryDesingPattern.BasicPanel;
import utils.Utils;

public class AuxPanel extends BasicPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuxPanel(Dimension dimension, Controler ctrl){
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
	

	/*public static void main(String[] arg) {
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
		frame.add(new AuxPanel(Utils.reSize(0.2, 0.3)));
		frame.setVisible(true);
	}*/
	
	
}
