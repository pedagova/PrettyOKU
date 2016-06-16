package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.sound.midi.spi.MidiDeviceProvider;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.Controler;
import factoryDesingPattern.panelList.MainPanel;
import view.Panels.ItemRepr;

public class View extends JFrame implements StandartInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MainPanel panel;

	public void start(Controler ctrl) {
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		} catch (Exception e) {
			System.err.print("Error at Look And Feel");
		}
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(dimension);
		this.setLocationRelativeTo(null);
		this.panel = new MainPanel(Toolkit.getDefaultToolkit().getScreenSize(), ctrl);
		this.add(panel);
		ctrl.add(panel);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setBackground(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.pack();
	}

	@Override
	public void changePanel(JPanel p) {
		// TODO Auto-generated method stub
	}

	@Override
	public void initGUI() {
		// TODO Auto-generated method stub
		
	}

	

	/*
	 * public static void main(String[] args) { MainPanel panel = new
	 * MainPanel(Toolkit.getDefaultToolkit().getScreenSize(), new Controler());
	 * 
	 * }
	 */
}
