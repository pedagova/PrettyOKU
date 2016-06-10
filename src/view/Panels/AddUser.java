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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import controller.Controler;

public class AddUser extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String EMAIL = "Email:";

	public static final String PASS = "Password:";

	public static final String PASS_AGAIN = "Password again:";

	private JTextPane title;

	private JTextPane eMail;

	private JTextField eMailRequest;

	private JTextPane pass;

	private JPasswordField passRequest;

	private JTextPane passAgain;

	private JPasswordField passAgainRequest;

	private Button createrAccount;

	private Color color;
	
	private Color backGround;

	private JPanel emailPanel;

	private JPanel passPanel;

	private JPanel passAgainPanel;
	
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
				if(passAgainRequest.equals(passRequest)){
				}else{
					
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
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Paint oldPaint = g2.getPaint();
		RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight() - 1, 45, 45);
		g2.clip(r2d);
		g2.setPaint(
				new GradientPaint(0.0f, getHeight() / 2, Color.white.brighter(), getHeight() / 2, getHeight(), backGround));
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
		 * ESTA CLASE NO HACE FALTA QUE LA ENTIENDAS, SOLO ES UN BOTON CON COLOR QUE PUEDES CAMBIAR EN ARTIB PRIVADOS
		 * PUEDES AÑADIRLE UN LISTENER Y ESO
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
		AddUser user = new AddUser(Color.white,new Color(255, 96, 0), null);
		user.setVisible(true);
		frame.add(user);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
}
