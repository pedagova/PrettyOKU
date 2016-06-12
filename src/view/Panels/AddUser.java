package view.Panels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import controller.Controler;
import dataAccessObjectDesingPattern.UserVO;

public class AddUser extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String EMAIL = "Email:";

	public static final String PASS = "Password:";

	public static final String PASS_AGAIN = "Password again:";
	public static final String NAME = "Name:";

	public static final String NICK = "Nick:";
	public static final String FORE_NAME_1 = "Surename:";
	public static final String ADDRESS = "Address:";

	private JTextPane title;

	private JTextPane eMail;

	private JTextField eMailRequest;

	private JTextPane pass;

	private JPasswordField passRequest;

	private JTextPane passAgain;

	private JPasswordField passAgainRequest;

	private JTextPane nick;

	private JTextField nickRequest;

	private JTextPane adress;

	private JTextField adressRequest;

	private JTextPane name;

	private JTextField nameRequest;
	private JTextPane foreName1;

	private JTextField foreName1Request;
	private JTextPane foreName2;

	private JTextField foreName2Request;
	private Button createrAccount;

	private Color color;

	private Color backGround;

	private JPanel emailPanel;

	private JPanel passPanel;

	private JPanel passAgainPanel;

	private JPanel nickPanel;
	private JPanel adressPanel;
	private JPanel namePanel;
	private JPanel foreName1Panel;
	private JPanel foreName2Panel;

	private Controler ctrl;

	public AddUser(Color backGround, Color color, Controler ctrl) {
		this.color = color;
		this.backGround = backGround;
		this.ctrl = ctrl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setOpaque(false);
		this.initComponents();
		this.initGUI();
	}

	private JSeparator generateSeparator() {
		JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setVisible(true);
		separator.setBorder(BorderFactory.createLineBorder(color));
		return separator;
	}

	private void initGUI() {
		this.add(Box.createRigidArea(new Dimension(1, 20)));
		this.add(title);
		this.add(generateSeparator());
		this.add(Box.createRigidArea(new Dimension(1, 10)));
		this.add(emailPanel);
		this.add(this.passPanel);
		this.add(this.passAgainPanel);
		this.add(this.namePanel);
		this.add(this.foreName1Panel);
		this.add(this.foreName2Panel);
		this.add(this.nickPanel);
		this.add(this.adressPanel);
		this.add(Box.createRigidArea(new Dimension(1, 100)));
		this.add(createrAccount);
		this.add(Box.createRigidArea(new Dimension(1, 20)));

	}

	private void initComponents() {

		// title of the component
		this.title = new JTextPane();
		this.title.setText(" New user:");
		this.title.setFont(new Font("Arial", Font.PLAIN, 20));
		this.title.setForeground(color);
		this.title.setOpaque(false);
		this.title.setEditable(false);

		// email text
		this.eMail = new JTextPane();
		this.eMail.setText(AddUser.EMAIL);
		this.eMail.setFont(new Font("Arial", Font.PLAIN, 16));
		this.eMail.setOpaque(false);
		this.eMail.setEditable(false);

		// email request
		this.eMailRequest = new JTextField(10);
		this.eMailRequest.setBorder(null);
		this.eMailRequest.setBorder(BorderFactory.createRaisedBevelBorder());
		this.eMailRequest.setForeground(new Color(0, 0, 0));
		this.eMailRequest.setOpaque(false);
		this.eMailRequest.setEditable(true);

		// pass text
		this.pass = new JTextPane();
		this.pass.setText(AddUser.PASS);
		this.pass.setBorder(BorderFactory.createLineBorder(Color.red));
		this.pass.setFont(new Font("Arial", Font.PLAIN, 16));
		this.pass.setForeground(new Color(0, 0, 0));
		this.pass.setOpaque(false);
		this.pass.setEditable(false);

		// pass request
		this.passRequest = new JPasswordField("", 10);
		this.passRequest.setForeground(new Color(0, 0, 0));
		this.passRequest.setBorder(BorderFactory.createLineBorder(Color.red));
		this.passRequest.setOpaque(false);
		this.passRequest.setEditable(true);

		// pass again text
		this.passAgain = new JTextPane();
		this.passAgain.setText(AddUser.PASS_AGAIN);
		this.passAgain.setFont(new Font("Arial", Font.PLAIN, 16));
		this.passAgain.setForeground(new Color(0, 0, 0));
		this.passAgain.setOpaque(false);
		this.passAgain.setEditable(false);
		this.passAgain.setBorder(BorderFactory.createLineBorder(Color.red));

		// pass again request
		this.passAgainRequest = new JPasswordField(10);
		this.passAgainRequest.setForeground(new Color(0, 0, 0));
		this.passAgainRequest.setBorder(BorderFactory.createLineBorder(Color.red));
		this.passAgainRequest.setOpaque(false);
		this.passAgainRequest.setEditable(true);

		// create account button
		this.createrAccount = new Button("Create account");
		createrAccount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (passAgainRequest.equals(passRequest)) {
					try{
					ctrl.addUser(new UserVO(nameRequest.getText(), nickRequest.getText(),
							foreName1Request.getText(), foreName2Request.getText(), passRequest.getPassword(),eMailRequest.getText(),
							adressRequest.getText()));
					}catch(NullPointerException n){
						JOptionPane.showMessageDialog(null,
							    "pass cant be empty",
							    "Inane error",
							    JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
						    "pass again and pass request are diferent",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		// email panel
		this.emailPanel = new JPanel();
		this.emailPanel.setVisible(true);
		this.emailPanel.setBorder(null);
		this.emailPanel.setOpaque(false);
		this.emailPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.emailPanel.add(eMail);
		this.emailPanel.add(Box.createRigidArea(new Dimension(25, 0)));
		this.emailPanel.add(eMailRequest);
		this.emailPanel.add(Box.createRigidArea(new Dimension(20, 0)));

		// pass panel
		this.passPanel = new JPanel();
		this.passPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.passPanel.add(pass);
		this.passPanel.add(Box.createRigidArea(new Dimension(25, 0)));
		this.passPanel.add(passRequest);
		this.passPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		this.passPanel.setVisible(true);
		this.passPanel.setBorder(null);
		this.passPanel.setOpaque(false);

		// second pass panel
		this.passAgainPanel = new JPanel();
		this.passAgainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.passAgainPanel.add(passAgain);
		this.passAgainPanel.add(Box.createRigidArea(new Dimension(25, 0)));
		this.passAgainPanel.add(passAgainRequest);
		this.passAgainPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		this.passAgainPanel.setVisible(true);
		this.passAgainPanel.setBorder(null);
		this.passAgainPanel.setOpaque(false);

		// new form here till the bottom
		// ---------------------------------------------------------------------------------

		// name text
		this.name = new JTextPane();
		this.name.setText(AddUser.NAME);
		this.name.setBorder(BorderFactory.createLineBorder(Color.red));
		this.name.setFont(new Font("Arial", Font.PLAIN, 16));
		this.name.setForeground(new Color(0, 0, 0));
		this.name.setOpaque(false);
		this.name.setEditable(false);

		// name request
		this.nameRequest = new JTextField(10);
		this.nameRequest.setBorder(null);
		this.nameRequest.setBorder(BorderFactory.createRaisedBevelBorder());
		this.nameRequest.setForeground(new Color(0, 0, 0));
		this.nameRequest.setOpaque(false);
		this.nameRequest.setEditable(true);

		// name panel
		this.namePanel = new JPanel();
		this.namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.namePanel.add(name);
		this.namePanel.add(Box.createRigidArea(new Dimension(25, 0)));
		this.namePanel.add(nameRequest);
		this.namePanel.add(Box.createRigidArea(new Dimension(20, 0)));
		this.namePanel.setVisible(true);
		this.namePanel.setBorder(null);
		this.namePanel.setOpaque(false);

		// fore name 1 text
		this.foreName1 = new JTextPane();
		this.foreName1.setText(AddUser.FORE_NAME_1);
		this.foreName1.setBorder(BorderFactory.createLineBorder(Color.red));
		this.foreName1.setFont(new Font("Arial", Font.PLAIN, 16));
		this.foreName1.setForeground(new Color(0, 0, 0));
		this.foreName1.setOpaque(false);
		this.foreName1.setEditable(false);

		// fore name 2 request
		this.foreName1Request = new JTextField(10);
		this.foreName1Request.setBorder(null);
		this.foreName1Request.setBorder(BorderFactory.createRaisedBevelBorder());
		this.foreName1Request.setForeground(new Color(0, 0, 0));
		this.foreName1Request.setOpaque(false);
		this.foreName1Request.setEditable(true);

		// fore name 1 panel
		this.foreName1Panel = new JPanel();
		this.foreName1Panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.foreName1Panel.add(foreName1);
		this.foreName1Panel.add(Box.createRigidArea(new Dimension(25, 0)));
		this.foreName1Panel.add(foreName1Request);
		this.foreName1Panel.add(Box.createRigidArea(new Dimension(20, 0)));
		this.foreName1Panel.setVisible(true);
		this.foreName1Panel.setBorder(null);
		this.foreName1Panel.setOpaque(false);

		// fore name 2 text
		this.foreName2 = new JTextPane();
		this.foreName2.setText("Fore name 2:");
		this.foreName2.setBorder(BorderFactory.createLineBorder(Color.red));
		this.foreName2.setFont(new Font("Arial", Font.PLAIN, 16));
		this.foreName2.setForeground(new Color(0, 0, 0));
		this.foreName2.setOpaque(false);
		this.foreName2.setEditable(false);

		// fore name 2 request
		this.foreName2Request = new JTextField(10);
		this.foreName2Request.setBorder(null);
		this.foreName2Request.setBorder(BorderFactory.createRaisedBevelBorder());
		this.foreName2Request.setForeground(new Color(0, 0, 0));
		this.foreName2Request.setOpaque(false);
		this.foreName2Request.setEditable(true);

		// fore name 2 panel
		this.foreName2Panel = new JPanel();
		this.foreName2Panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.foreName2Panel.add(foreName2);
		this.foreName2Panel.add(Box.createRigidArea(new Dimension(25, 0)));
		this.foreName2Panel.add(foreName2Request);
		this.foreName2Panel.add(Box.createRigidArea(new Dimension(20, 0)));
		this.foreName2Panel.setVisible(true);
		this.foreName2Panel.setBorder(null);
		this.foreName2Panel.setOpaque(false);

		// address text
		this.adress = new JTextPane();
		this.adress.setText(AddUser.ADDRESS);
		this.adress.setBorder(BorderFactory.createLineBorder(Color.red));
		this.adress.setFont(new Font("Arial", Font.PLAIN, 16));
		this.adress.setForeground(new Color(0, 0, 0));
		this.adress.setOpaque(false);
		this.adress.setEditable(false);

		// address request
		this.adressRequest = new JTextField(10);
		this.adressRequest.setBorder(null);
		this.adressRequest.setBorder(BorderFactory.createRaisedBevelBorder());
		this.adressRequest.setForeground(new Color(0, 0, 0));
		this.adressRequest.setOpaque(false);
		this.adressRequest.setEditable(true);

		// address panel
		this.adressPanel = new JPanel();
		this.adressPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.adressPanel.add(adress);
		this.adressPanel.add(Box.createRigidArea(new Dimension(25, 0)));
		this.adressPanel.add(adressRequest);
		this.adressPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		this.adressPanel.setVisible(true);
		this.adressPanel.setBorder(null);
		this.adressPanel.setOpaque(false);

		// nick text
		this.nick = new JTextPane();
		this.nick.setText(AddUser.NICK);
		this.nick.setBorder(BorderFactory.createLineBorder(Color.red));
		this.nick.setFont(new Font("Arial", Font.PLAIN, 16));
		this.nick.setForeground(new Color(0, 0, 0));
		this.nick.setOpaque(false);
		this.nick.setEditable(false);

		// nick request
		this.nickRequest = new JTextField(10);
		this.nickRequest.setBorder(null);
		this.nickRequest.setBorder(BorderFactory.createRaisedBevelBorder());
		this.nickRequest.setForeground(new Color(0, 0, 0));
		this.nickRequest.setOpaque(false);
		this.nickRequest.setEditable(true);

		// nick panel
		this.nickPanel = new JPanel();
		this.nickPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.nickPanel.add(nick);
		this.nickPanel.add(Box.createRigidArea(new Dimension(25, 0)));
		this.nickPanel.add(nickRequest);
		this.nickPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		this.nickPanel.setVisible(true);
		this.nickPanel.setBorder(null);
		this.nickPanel.setOpaque(false);

	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Paint oldPaint = g2.getPaint();
		RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight() - 1, 45, 45);
		g2.clip(r2d);
		g2.setPaint(new GradientPaint(0.0f, getHeight() / 2, Color.white.brighter(), getHeight() / 2, getHeight(),
				backGround));
		g2.fillRect(0, 0, getWidth(), getHeight());

		g2.setStroke(new BasicStroke(4f));

		g2.setPaint(new GradientPaint(0.0f, getHeight() / 4, color.brighter(), getHeight() / 4, getHeight(),
				color.brighter()));
		g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 45, 45);

		g2.setPaint(oldPaint);
		super.paintComponent(g);
	}

	class Button extends JButton {

		/**
		 * ESTA CLASE NO HACE FALTA QUE LA ENTIENDAS, SOLO ES UN BOTON CON COLOR
		 * QUE PUEDES CAMBIAR EN ARTIB PRIVADOS PUEDES AÑADIRLE UN LISTENER Y
		 * ESO
		 */

		private static final long serialVersionUID = 1L;
		private Color color1 = color;
		private Color color2 = new Color(0, 0, 0);
		private Color color3 = Color.BLACK;

		public Button(String text) {
			this.setText(text);
			setOpaque(false);
			setContentAreaFilled(false);
			setForeground(Color.WHITE);
			setFocusPainted(false);
			setBorderPainted(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Color c1, c2, c3;
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			ButtonModel m = getModel();

			Paint oldPaint = g2.getPaint();
			if (m.isArmed()) {
				c2 = color1.darker();
				c1 = color2.darker();
				c3 = color3;
			} else {
				c1 = color1.darker();
				c2 = color2.darker();
				c3 = color3.brighter();
			}
			if (!m.isEnabled()) {
				c2 = color1.brighter();
				c1 = color2.brighter();
				c3 = color3.darker();
			}
			RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight() - 1, 20, 20);
			g2.clip(r2d);
			g2.setPaint(new GradientPaint(0.0f, 0.0f, c1, 0.0f, getHeight(), c2));
			g2.fillRect(0, 0, getWidth(), getHeight());

			g2.setStroke(new BasicStroke(4f));
			g2.setPaint(new GradientPaint(0.0f, 0.0f, c3, 0.0f, getHeight(), c3));
			g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 18, 18);

			g2.setPaint(oldPaint);
			super.paintComponent(g);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("example");
		frame.pack();
		frame.setBackground(new Color(0, 0, 0));
		AddUser user = new AddUser(Color.white, new Color(255, 96, 0), null);
		user.setVisible(true);
		frame.add(user);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

}
