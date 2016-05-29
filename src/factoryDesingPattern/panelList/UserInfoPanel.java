package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import controller.Controler;
import dataAccessObjectDesingPattern.UserVO;
import factoryDesingPattern.BasicPanel;

public class UserInfoPanel extends BasicPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea userName;

	private JTextPane panelTitle;

	public UserInfoPanel(Dimension dimension, Controler ctrl) {
		super.setPreferredSize(dimension);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		this.userName = new JTextArea();
		this.userName.setBackground(null);
		this.userName.setFont( new Font("Verdana", Font.BOLD, 18));
		this.userName.setEditable(false);
		this.panelTitle = new JTextPane();
		this.generateTextPane(panelTitle, "<font size=\"16\">USER INFORMATION</font>");
	}

	@Override
	public void initGUI() {
		this.add(Box.createRigidArea(new Dimension(100, 500)));
		JPanel auxPanel = new JPanel();
		auxPanel.setLayout(new BoxLayout(auxPanel, BoxLayout.Y_AXIS));
		auxPanel.add(panelTitle);
		auxPanel.add(userName);
		this.add(auxPanel);

	}

	/*
	 * public static void main(String[] arg) { JFrame frame = new JFrame();
	 * frame.setPreferredSize(Utils.reSize(0.5, 0.5)); frame.pack();
	 * frame.setLocationRelativeTo(null); frame.add(new
	 * UserInfoPanel(Utils.reSize(0.4, 0.5))); frame.setVisible(true); }
	 */

	public void setInfo(UserVO u) {
		this.userName.append("Welcome to your account " + u.getNick() + "\n");
		this.userName.append(" -> Email adress: " + u.getEMail() + "\n");
		this.userName.append(" -> Name: " + u.getName() + " " + u.getForename1() + " " + u.getForename2() + "\n");
		this.userName.append(" -> Pass: " + u.getPass() + "\n");
		this.userName.append(" -> List of product: " + "\n");

	}
}
