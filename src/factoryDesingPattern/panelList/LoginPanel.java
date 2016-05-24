package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import controller.Controler;
import factoryDesingPattern.BasicPanel;

public class LoginPanel extends BasicPanel {

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

	private GridBagConstraints gbc;

	public LoginPanel(Dimension dimension, Controler ctrl) {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(dimension);
		this.ctrl = ctrl;
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		this.name = new JTextPane();
		this.generateTextPane(this.name, "<font size=\"12\">Your name</font>", 0.5);
		this.pass = new JTextPane();
		this.generateTextPane(this.pass, "<font size=\"12\">Your pass</font>", 0.5);
		this.requestName = new JTextField();
		this.generateTextField(this.requestName, "", 0.3);
		this.requestPass = new JPasswordField();
		this.generateTextField(this.requestPass, "", 0.3);
		this.accept = new JButton("       Accept       ");
		this.accept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.loginUser(requestName.getText(), requestPass.getText());
			}
		});

		this.cancel = new JButton("Cancel");
		this.changePass = new JButton("Forgot password");
		this.changePass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						ForgotPassPanel.createAndShowGUI();
					}
				});
			}
		});
		this.createUser = new JButton("New user");
		this.createUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						new UserRegisterPanel(ctrl);
						// añadir que se logee solo
					}
				});
			}
		});
	}

	@Override
	public void initGUI() {
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;
		this.add(this.name, this.gbc);
		++this.gbc.gridx;
		this.add(this.requestName, this.gbc);
		--this.gbc.gridx;
		++this.gbc.gridy;
		this.add(this.pass, this.gbc);
		++this.gbc.gridx;
		this.add(this.requestPass, this.gbc);
		--this.gbc.gridx;
		++this.gbc.gridy;
		this.add(this.accept, this.gbc);
		++this.gbc.gridx;
		this.add(this.cancel, this.gbc);
		--this.gbc.gridx;
		++this.gbc.gridy;
		this.add(this.changePass, this.gbc);
		++this.gbc.gridx;
		this.add(this.createUser, this.gbc);
	}

	/*public static void main(String[] arg) {
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		} catch (Exception e) {
			System.err.print("Error at Look And Feel");
		}
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 200));
		frame.add(new LoginPanel(new Dimension(400, 100)));
		frame.setVisible(true);
		frame.pack();
	}*/

}
