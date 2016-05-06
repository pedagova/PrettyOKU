package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import factoryDesingPattern.Panel;
import utils.Utils;

public class UserRegisterPanel extends Panel {

	private static final long serialVersionUID = 1L;

	private static final double COMPONENT_DIMENSION_Y = 0.03;

	private JTextPane name;
	private JTextField nameRequest;
	private JTextPane email;
	private JTextField emailRequest;
	private JTextPane pass;
	private JPasswordField passRequest;
	private JTextPane passConf;
	private JPasswordField passConfRequest;
	private JScrollPane scroll;
	private JCheckBox checkPoint;
	private JButton createAccount;
	private JPanel auxPanel;
	
	public UserRegisterPanel(Dimension dimension) {
		super.setPreferredSize(dimension);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new TitledBorder(new EtchedBorder(), "USER REGISTER", 1, 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		this.name = new JTextPane();
		this.generateTextPane(this.name, "Your name", COMPONENT_DIMENSION_Y);

		this.nameRequest = new JTextField();
		this.generateTextField(this.nameRequest, "tap here your e-mail",COMPONENT_DIMENSION_Y);

		this.email = new JTextPane();
		this.generateTextPane(this.email, "Your e-mail",COMPONENT_DIMENSION_Y);

		this.emailRequest = new JTextField();
		this.generateTextField(this.emailRequest, "tap here your e-mail",COMPONENT_DIMENSION_Y);

		this.pass = new JTextPane();
		this.generateTextPane(this.pass, "Password",COMPONENT_DIMENSION_Y);

		this.passRequest = new JPasswordField();
		this.passRequest.setPreferredSize(Utils.adjustDimension(1, COMPONENT_DIMENSION_Y, this.getPreferredSize()));

		this.passConf = new JTextPane();
		this.generateTextPane(this.passConf, "Password",COMPONENT_DIMENSION_Y);

		this.passConfRequest = new JPasswordField();
		this.passConfRequest.setPreferredSize(Utils.adjustDimension(1, COMPONENT_DIMENSION_Y, this.getPreferredSize()));

		this.scroll = new JScrollPane(new JTextArea(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.scroll.setPreferredSize(Utils.adjustDimension(1, 0.5, this.getPreferredSize()));

		this.checkPoint = new JCheckBox("I agree with politics");
		this.createAccount = new JButton("Create an Ôku account");

		this.auxPanel = new JPanel();
		this.auxPanel.setLayout(new BoxLayout(this.auxPanel, BoxLayout.X_AXIS));
		this.auxPanel.setPreferredSize(Utils.adjustDimension(1, 0.05, this.getPreferredSize()));
		this.auxPanel.setVisible(true);
		this.scroll.setVisible(true);

	}

	@Override
	public void initGUI() {
		this.add(this.name);
		this.add(this.nameRequest);
		this.add(this.email);
		this.add(this.emailRequest);
		this.add(this.pass);
		this.add(this.passRequest);
		this.add(this.passConf);
		this.add(this.passConfRequest);
		this.add(Box.createRigidArea(Utils.adjustDimension(1, 0.05, this.getPreferredSize())));
		this.add(this.scroll);
		this.auxPanel.add(this.checkPoint);
		this.auxPanel.add(Box.createHorizontalGlue());
		this.auxPanel.add(this.createAccount);
		this.add(this.auxPanel);

	}

	public static void main(String[] arg) {
		
		JFrame frame = new JFrame();
		frame.setPreferredSize(Utils.reSize(0.35, 0.7));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.add(new UserRegisterPanel(Utils.reSize(0.35, 0.7)));
		frame.setVisible(true);
	}
}