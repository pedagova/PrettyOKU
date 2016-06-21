package view.Panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import controller.Controler;

public class UserLog extends Panel {

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

	public UserLog(Controler ctrl) {
		super(ctrl);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(Color.white);
		
		this.initComponents();
		this.initGUI();
	}

	private void initGUI() {
		this.auxLog1.setBackground(Color.white);
		this.auxLog2.setBackground(Color.white);
		this.auxRegister1.setBackground(Color.white);
		this.auxRegister2.setBackground(Color.white);
		
		this.auxRegister1.add(Box.createRigidArea(new Dimension(200, 1)));
		this.auxRegister1.add(registerComponent);

		this.auxRegister2.add(auxRegister1);
		this.auxRegister2.add(Box.createRigidArea(new Dimension(1, 300)));

		this.add(this.auxRegister2);
		

		this.add(Box.createRigidArea(new Dimension(80, 1)));
		this.auxLog1.add(logComponent);
		this.auxLog1.add(Box.createRigidArea(new Dimension(200, 1)));


		this.auxLog2.add(auxLog1);
		this.auxLog2.add(Box.createRigidArea(new Dimension(1,500)));

		this.add(this.auxLog2);
		

	}

	private void initComponents() {
		this.auxRegister1 = new JPanel();
		this.auxRegister1.setLayout(new BoxLayout(this.auxRegister1, BoxLayout.X_AXIS));

		this.auxRegister2 = new JPanel();
		this.auxRegister2.setLayout(new BoxLayout(this.auxRegister2, BoxLayout.Y_AXIS));
		//this.auxRegister2.setPreferredSize(new Dimension(300, 500));

		this.registerComponent = new AddUser(Color.white, Color.black, ctrl);

		
		this.auxLog1 = new JPanel();
		this.auxLog1.setLayout(new BoxLayout(this.auxLog1, BoxLayout.X_AXIS));
		
		this.auxLog2 = new JPanel();
		this.auxLog2.setLayout(new BoxLayout(this.auxLog2, BoxLayout.Y_AXIS));
		//this.auxLog2.setPreferredSize(new Dimension(300, 500));
		
		this.logComponent = new LoadUser(Color.white, Color.black, ctrl);

	}

}
