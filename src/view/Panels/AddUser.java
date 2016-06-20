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
import javax.swing.JComponent;
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

	public final String EMAIL = "Email:";

	public final String PASS = "Password:";

	public final String PASS_AGAIN = "Password again:";
	public final String NAME = "Name:";

	public final String NICK = "Nick:";
	public final String FORE_NAME_1 = "Forename 1:";
	public final String ADDRESS = "Address:";

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
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setOpaque(false);

		// title of the component
		this.title = new JTextPane();
		this.generateTextPane(title, " New user", 30, new Color(255, 96, 0));

		// email text
		this.eMail = new JTextPane();
		this.generateTextPane(eMail, EMAIL, 22, Color.black);

		// email request
		this.eMailRequest = new JTextField(10);
		this.generateTextField(eMailRequest, Color.black);

		// pass text
		this.pass = new JTextPane();
		this.generateTextPane(pass, PASS, 22, Color.black);

		// pass request
		this.passRequest = new JPasswordField("", 10);
		this.generatePasswordField(passRequest);

		// pass again text
		this.passAgain = new JTextPane();
		this.generateTextPane(passAgain, PASS_AGAIN, 22, Color.black);

		// pass again request
		this.passAgainRequest = new JPasswordField(10);
		this.generatePasswordField(passAgainRequest);

		// create account button
		this.createrAccount = new Button("Create account");
		createrAccount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean correct = true;
				if (passAgainRequest.getPassword().length == passRequest.getPassword().length) {
					for (int i = 0; i < passAgainRequest.getPassword().length; ++i) {
						if (passAgainRequest.getPassword()[i] != passRequest.getPassword()[i]) {
							correct = false;
							break;
						}
					}
				}
				if (correct) {
					try {
						UserVO u = new UserVO(
								nameRequest.getText(), 
								nickRequest.getText(),
								foreName1Request.getText(), 
								foreName2Request.getText(), 
								passRequest.getPassword(),
								eMailRequest.getText(),
								adressRequest.getText());
						ctrl.addUser(u);
						ctrl.loginUser(nickRequest.getText(), passRequest.getPassword());
					} catch (NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Pass can´t be empty", "Inane error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Pass again and pass request are diferent", "Inane error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		// email panel
		this.emailPanel = new JPanel();
		this.generatePanel(emailPanel, eMail, eMailRequest);

		// pass panel
		this.passPanel = new JPanel();
		this.generatePanel(passPanel, pass, passRequest);

		// second pass panel
		this.passAgainPanel = new JPanel();
		this.generatePanel(passAgainPanel, passAgain, passAgainRequest);

		// name text
		this.name = new JTextPane();
		this.generateTextPane(name, NAME, 22, Color.black);

		// name request
		this.nameRequest = new JTextField(10);
		this.generateTextField(nameRequest, Color.black);

		// name panel
		this.namePanel = new JPanel();
		this.generatePanel(namePanel, name, nameRequest);

		// fore name 1 text
		this.foreName1 = new JTextPane();
		this.generateTextPane(foreName1, FORE_NAME_1, 22, Color.black);

		// fore name 1 request
		this.foreName1Request = new JTextField(10);
		this.generateTextField(foreName1Request, Color.black);

		// fore name 1 panel
		this.foreName1Panel = new JPanel();
		this.generatePanel(foreName1Panel, foreName1, foreName1Request);

		// fore name 2 text
		this.foreName2 = new JTextPane();
		this.generateTextPane(foreName2, "Forename 2:", 22, Color.black);

		// fore name 2 request
		this.foreName2Request = new JTextField(10);
		this.generateTextField(foreName2Request, Color.black);

		// fore name 2 panel
		this.foreName2Panel = new JPanel();
		this.generatePanel(foreName2Panel, foreName2, foreName2Request);

		// address text
		this.adress = new JTextPane();
		this.generateTextPane(adress, ADDRESS, 22, Color.black);

		// address request
		this.adressRequest = new JTextField(10);
		this.generateTextField(adressRequest, Color.black);

		// address panel
		this.adressPanel = new JPanel();
		this.generatePanel(adressPanel, adress, adressRequest);

		// nick text
		this.nick = new JTextPane();
		this.generateTextPane(nick, NICK, 22, Color.black);

		// nick request
		this.nickRequest = new JTextField(10);
		this.generateTextField(nickRequest, Color.black);

		// nick panel
		this.nickPanel = new JPanel();
		this.generatePanel(nickPanel, nick, nickRequest);

	}

	private void generatePanel(JComponent comp0, JComponent comp1, JComponent comp2) {
		comp0.setLayout(new FlowLayout(FlowLayout.RIGHT));
		comp0.add(comp1);
		comp0.add(Box.createRigidArea(new Dimension(25, 0)));
		comp0.add(comp2);
		comp0.add(Box.createRigidArea(new Dimension(20, 0)));
		comp0.setVisible(true);
		comp0.setBorder(null);
		comp0.setOpaque(false);
	}

	private void generatePasswordField(JPasswordField component) {
		component.setForeground(new Color(0, 0, 0));
		component.setBorder(BorderFactory.createLineBorder(Color.gray));
		component.setOpaque(false);
		component.setEditable(true);
		component.setVisible(true);
	}

	private void generateTextPane(JTextPane component, String constant, int fontSize, Color fontColor) {
		component.setText(constant);
		component.setBorder(null);
		component.setFont(new Font("Arial", Font.PLAIN, fontSize));
		component.setForeground(fontColor);
		component.setOpaque(false);
		component.setEditable(false);
	}

	private void generateTextField(JTextField component, Color fontColor) {
		component.setBorder(BorderFactory.createLineBorder(Color.gray));
		component.setForeground(fontColor);
		component.setOpaque(false);
		component.setEditable(true);
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
