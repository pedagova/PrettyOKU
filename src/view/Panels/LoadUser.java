package view.Panels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import controller.Controler;

public class LoadUser extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Controler ctrl;

	private final static String REGISTER_USER = "  Register user:";

	private final static String NICK = "  Nick:";

	private final static String PASS = "  Password:";

	private JTextPane title;

	private JTextPane eMail;

	private JTextField eMailRequest;

	private JTextPane pass;

	private JPasswordField passRequest;

	private Button enterAccount;

	private Button obtainNewPass;

	private Color color;

	private Color backGround;

	private JPanel auxButtonPanel;

	public LoadUser(Color backGround, Color color) {
		this.color = color;
		this.backGround = backGround;
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
		this.add(Box.createRigidArea(new Dimension(1, 100)));
		this.add(title);
		this.add(generateSeparator());
		this.add(Box.createRigidArea(new Dimension(1, 50)));
		this.add(eMail);
		this.add(eMailRequest);
		this.add(pass);
		this.add(passRequest);
		this.add(Box.createRigidArea(new Dimension(1, 50)));
		this.auxButtonPanel.add(enterAccount);
		this.auxButtonPanel.add(obtainNewPass);
		this.add(auxButtonPanel);
		this.add(Box.createRigidArea(new Dimension(1, 20)));

	}

	private void initComponents() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.auxButtonPanel = new JPanel();
		this.auxButtonPanel.setOpaque(false);
		
		// title of the component
		this.title = new JTextPane();
		this.generateTextPane(title, LoadUser.REGISTER_USER, 28, new Color(255, 96, 0), BorderFactory.createLineBorder(this.color));

		// email text
		this.eMail = new JTextPane();
		this.generateTextPane(eMail, LoadUser.NICK, 20, Color.black, null);

		// email request
		this.eMailRequest = new JTextField(10);
		this.generateTextField(eMailRequest, Color.black, BorderFactory.createLineBorder(color));

		// pass text
		this.pass = new JTextPane();
		this.generateTextPane(pass, LoadUser.PASS, 20, Color.black, null);

		// pass request
		this.passRequest = new JPasswordField(10);
		this.generatePasswordField(passRequest, BorderFactory.createLineBorder(color));

		// create account button
		this.enterAccount = new Button("Access acount");
		enterAccount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.loginUser(eMailRequest.getText(), passRequest.getPassword());
			}
		});
		this.obtainNewPass = new Button("Obtain new password");

	}
	
	private void generatePasswordField(JPasswordField component, Border border){
		component.setForeground(new Color(0, 0, 0));
		component.setBorder(border);
		component.setOpaque(false);
		component.setEditable(true);
		component.setVisible(true);
	}
	
	private void generateTextPane(JTextPane component, String constant, int fontSize, Color fontColor, Border border){
		component.setText(constant);
		component.setBorder(border);
		component.setFont(new Font("Arial", Font.PLAIN, fontSize));
		component.setForeground(fontColor);
		component.setOpaque(false);
		component.setEditable(false);
	}
	
	private void generateTextField(JTextField component, Color fontColor, Border border){
		component.setBorder(border);
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
		private Color color3 = Color.white;

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
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBackground(new Color(0, 0, 0));
		LoadUser user = new LoadUser(new Color(255, 96, 0), Color.black);
		frame.add(user);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
