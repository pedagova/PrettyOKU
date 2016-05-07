package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import factoryDesingPattern.BasicPanel;

public class LoginPanel extends BasicPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextPane name;
	
	private JTextPane pass;
	
	private JTextField requestName;
	
	private JTextField requestPass;
	
	private JButton accept;
	
	private JButton cancel;
	
	private JButton changePass;
	
	private JButton createUser;
	
	public LoginPanel(Dimension dimension){
		this.setLayout(new GridLayout(4,1));
		this.setPreferredSize(dimension);
		this.setBorder(new TitledBorder(new EtchedBorder(), "USER LOGIN", 1, 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();
	}
	@Override
	public void initComponets() {
		this.name = new JTextPane();
		this.generateTextPane(this.name, "Your name", 0.3);
		this.pass = new JTextPane();
		this.generateTextPane(this.pass, "Your pass", 0.3);
		this.requestName = new JTextField();
		this.generateTextField(this.requestName, "", 0.3);
		this.requestPass = new JTextField();
		this.generateTextField(this.requestPass, "", 0.3);
		this.accept = new JButton("Accept");
		this.cancel  =new JButton("Cancel");
		this.changePass = new JButton("Forgot password");
		this.createUser = new JButton("New user");
	}

	@Override
	public void initGUI() {
		this.add(this.name);
		this.add(this.requestName);
		this.add(this.pass);
		this.add(this.requestPass);
		this.add(this.accept);
		this.add(this.cancel);
		this.add(this.changePass);
		this.add(this.createUser);
	}
	
	public static void main(String[] arg){
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		} catch (Exception e) {
			System.err.print("Error at Look And Feel");
		}
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500,200));
		frame.add(new LoginPanel(new Dimension(400,100)));
		frame.setVisible(true);
		frame.pack();
	}

}
