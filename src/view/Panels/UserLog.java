package view.Panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserLog extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoadUser logComponent;

	private AddUser registerComponent;

	private JPanel auxRegister1;
	private JPanel auxRegister2;

	private JPanel auxLog1;
	private JPanel auxLog2;

	public UserLog() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.initComponents();
		this.initGUI();
	}

	private void initGUI() {
		this.auxRegister1.add(Box.createRigidArea(new Dimension(400, 300)));
		this.auxRegister1.add(registerComponent);

		this.auxRegister2.add(auxRegister1);
		this.auxRegister2.add(Box.createRigidArea(new Dimension(300, 800)));

		this.add(this.auxRegister2);
		this.auxRegister1.add(Box.createRigidArea(new Dimension(100, 800)));

		this.auxLog1.add(logComponent);
		this.auxLog1.add(Box.createRigidArea(new Dimension(400, 300)));


		this.auxLog2.add(auxLog1);
		this.auxLog2.add(Box.createRigidArea(new Dimension(300, 800)));

		this.add(this.auxLog2);
		
		//this.add(Box.createRigidArea(new Dimension(100, 500)));

	}

	private void initComponents() {
		this.auxRegister1 = new JPanel();
		this.auxRegister1.setLayout(new BoxLayout(this.auxRegister1, BoxLayout.X_AXIS));

		this.auxRegister2 = new JPanel();
		this.auxRegister2.setLayout(new BoxLayout(this.auxRegister2, BoxLayout.Y_AXIS));
		this.auxRegister2.setPreferredSize(new Dimension(300, 500));

		this.registerComponent = new AddUser(Color.white, new Color(0, 96, 255), null);

		
		this.auxLog1 = new JPanel();
		this.auxLog1.setLayout(new BoxLayout(this.auxLog1, BoxLayout.X_AXIS));
		
		this.auxLog2 = new JPanel();
		this.auxLog2.setLayout(new BoxLayout(this.auxLog2, BoxLayout.Y_AXIS));
		this.auxLog2.setPreferredSize(new Dimension(300, 500));
		
		this.logComponent = new LoadUser(new Color(255, 96, 0), Color.black);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("example");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBackground(new Color(0, 0, 0));
		UserLog user = new UserLog();
		user.setVisible(true);
		frame.add(user);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
