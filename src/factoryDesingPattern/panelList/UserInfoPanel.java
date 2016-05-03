package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import factoryDesingPattern.Panel;
import utils.Utils;

public class UserInfoPanel extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextPane userName;
	
	public UserInfoPanel(Dimension dimension){
		super.setPreferredSize(dimension);
		this.setLayout(new GridLayout(5,1));
		this.setBorder(new TitledBorder(new EtchedBorder(), "USER INFO PANEL", 1, 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();
	}
	@Override
	public void initComponets() {
		this.userName = new JTextPane();
		this.generateTextPane(this.userName, "Welcome to your account " + "my name", 0.5);
		
	}

	@Override
	public void initGUI() {
		this.add(this.userName);
		
	}

	public static void main(String[] arg){
		JFrame frame = new JFrame();
		frame.setPreferredSize(Utils.reSize(0.5, 0.5));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.add(new UserInfoPanel(Utils.reSize(0.4, 0.5)));
		frame.setVisible(true);
	}
}
