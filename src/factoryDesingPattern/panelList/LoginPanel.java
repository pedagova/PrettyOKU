package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import factoryDesingPattern.Panel;

public class LoginPanel extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextPane name;
	
	private JTextArea pass;
	
	private JTextArea requestName;
	
	private JTextArea requestPass;
	
	private JButton accept;
	
	private JButton cancel;
	
	private JButton changePass;
	
	private JButton createUser;
	
	public LoginPanel(Dimension dimension){
		this.setLayout(new GridLayout(3,2));
		this.setPreferredSize(dimension);
		this.setBorder(new TitledBorder(new EtchedBorder(), "USER LOGIN", 1, 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();
	}
	@Override
	public void initComponets() {
		this.name = new JTextPane();
		this.pass = new JTextArea("Your pass");
		this.pass.setEditable(false);
		this.requestName = new JTextArea();
		this.requestPass = new JTextArea();
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
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500,500));
		frame.add(new LoginPanel(new Dimension(400,400)));
		frame.setVisible(true);
		frame.pack();
	}

}
