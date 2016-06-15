package view.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;
import dataAccessObjectDesingPattern.UserVO;
import model.AppObserver;
import view.ViewUtilities;

public class MainSwing extends JPanel implements AppObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Color backColor = new Color(255, 69, 0);
	private final int UsesBarSize = 45;

	public JPanel midPanel;

	// ----------anonimus class--------------
	private class Separator extends JPanel {

		public Separator(Dimension d, Color c) {
			this.setPreferredSize(d);
			this.setBackground(c);
		}
	}
	// ---------end anonimus class----------

	// -------------Atributos-----------------
	Controler ctrl;

	// -----------fin Atributos---------------

	// ------------Public---------------------
	// Constructors
	public MainSwing(Controler ctrl) {
		this.ctrl = ctrl;
		midPanel = new ItemsList(new ArrayList<ItemVO>(), this.ctrl);
		initGUI();
		ctrl.add(this);
	}
	// --------end Public---------------------

	// ------------Private--------------------
	public void initGUI() {
		removeAll();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		setBackground(Color.white);

		add(generateLogo());
		add(Box.createRigidArea(new Dimension((int) getPreferredSize().getWidth(), 6)));
		add(tags());
		add(Box.createRigidArea(new Dimension((int) getPreferredSize().getWidth(), 6)));
		add(userBar());
		add(Box.createRigidArea(new Dimension((int) getPreferredSize().getWidth(), 6)));
		add(midPanel);
		add(information());
		validate();
		repaint();
	}

	private Component generateLogo() {
		JPanel p = new JPanel();

		p.setPreferredSize(new Dimension(500, 100));

		return Box.createRigidArea(new Dimension(500, 100));
	}

	private Component tags() {
		JPanel p = new JPanel();
		final Dimension d = new Dimension(1, 1);
		final Color c = Color.GRAY;
		final int N = 20;
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setPreferredSize(new Dimension(500, 30));
		p.setBackground(null);

		// -------------------1 button------------------------
		JButton homeB = ViewUtilities.generateButton("Home", "3", backColor, "#FFF5EE");
		homeB.setPreferredSize(new Dimension(75, 30));
		homeB.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		homeB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getN(N);
			}
		});
		p.add(homeB);
		// ---------------end 1 button -----------------------
		//
		// ------------------2 button-------------------------
		JButton button2 = ViewUtilities.generateButton("Games", "3", backColor, "#FFF5EE");
		button2.setPreferredSize(new Dimension(75, 30));
		button2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("1");
			}
		});
		p.add(button2);
		// ---------------end 2 button-----------------------

		// -------------------3 button------------------------
		JButton button3 = ViewUtilities.generateButton("Manga", "3", backColor, "#FFF5EE");
		button3.setPreferredSize(new Dimension(75, 30));
		button3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("2");
			}
		});
		p.add(button3);
		// ---------------end 3 button -----------------------

		// -------------------4 button------------------------
		JButton button4 = ViewUtilities.generateButton("Merchandasing", "3", backColor, "#FFF5EE");
		button4.setPreferredSize(new Dimension(75, 30));
		button4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("3");
			}
		});
		p.add(button4);
		// ---------------end 4 button -----------------------

		// -----------------5 button---------------------------
		JButton button5 = ViewUtilities.generateButton("miscellaneus", "3", backColor, "#FFF5EE");
		button5.setPreferredSize(new Dimension(75, 30));
		button5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("4");
			}
		});
		p.add(button5);
		// ---------------end 5 button -----------------------

		return p;
	}

	private Component userBar() {

		final String text = "    Bienvenido a Oku, la tienda de subastas para los \"Otaku\"";

		int widht = 750;

		JPanel p = new JPanel();
		p.setBackground(new Color(240, 241, 241));
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setPreferredSize(new Dimension(widht, UsesBarSize));
		p.setBorder(BorderFactory.createLineBorder(new Color(231, 231, 231)));

		JPanel p2 = new JPanel();

		JTextArea t = new JTextArea(text);
		t.setFont(new Font("Microsof sans serif", Font.BOLD, 12));
		t.setBackground(null);
		t.setEditable(false);
		t.setPreferredSize(new Dimension(widht * 50 / 100, UsesBarSize));

		p2.add(t);
		p2.setPreferredSize(t.getPreferredSize());
		p2.setBackground(null);
		p.add(p2);

		p.add(buscador(widht));

		p.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);

		JPanel p3 = new JPanel();
		p3.setBackground(null);
		if (!ctrl.isLoggedOn()) {
			JButton id = new JButton("Identificate");
			id.setFont(new Font("Arial", Font.BOLD, 20));
			id.setBackground(null);
			id.setForeground(Color.GRAY);
			id.setBorder(null);
			id.setPreferredSize(new Dimension((widht * 5 / 100) + 200, UsesBarSize - 20));
			id.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					midPanel = new UserLog();
					initGUI();
				}
			});
			p3.add(id);
		} else {
			JButton id = new JButton("Bienvenid@\n " + "pedagova@gmail.com");
			id.setFont(new Font("Microsof sans serif", Font.BOLD, 20));
			id.setBackground(null);
			id.setForeground(Color.GRAY);
			id.setBorder(null);
			id.setPreferredSize(new Dimension((widht * 20 / 100) + 200, UsesBarSize));
			id.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// lista cuando el usuario yya esta registrado
					// midPanel = new PanelRegistro(ctrl);
				}
			});
			p3.add(id);
		}

		p.add(p3);
		p.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);

		JButton b = new JButton("Add item");
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setFont(new Font("Arial", 20, 20));
		b.setBackground(null);
		b.setBorder(BorderFactory.createLineBorder(Color.red));
		b.setPreferredSize(new Dimension(widht * 15 / 100, 80));
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setPanel(new NewAddItem());
			}
		});

		p.add(b);

		return p;
	}

	private Component buscador(int width) {
		JPanel p = new JPanel();
		p.setBackground(null);

		JTextField tf = new JTextField("Buscador:");
		tf.setFont(new Font("Arial", Font.BOLD, 12));
		tf.setBackground(null);
		tf.setBorder(null);
		tf.setEditable(false);
		tf.setPreferredSize(new Dimension(width * 8 / 100 + 6, UsesBarSize - 20));

		JTextArea t = new JTextArea();
		t.setPreferredSize(new Dimension(width * 20 / 100, UsesBarSize - 20));
		t.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

		JButton b = new JButton("Buscar");
		b.setFont(new Font("Arial", Font.BOLD, 12));
		b.setForeground(Color.WHITE);
		b.setPreferredSize(new Dimension(width * 10 / 100 + 8, UsesBarSize - 20));
		b.setBackground(new Color(162, 147, 135));
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (t.getText() != "") {
					ctrl.find(t.getText());
				}
			}
		});

		p.add(tf);
		p.add(t);
		p.add(b);
		return p;
	}

	/*
	 * private Component interestItems(List<ItemVO> list) { JPanel frame = new
	 * JPanel(); final double NUMCOLS = 4.0; frame.setBackground(null);
	 * GridLayout l = new GridLayout((int) NUMCOLS, (int) Math.ceil(list.size()
	 * / NUMCOLS)); l.setHgap(10); l.setVgap(10); frame.setLayout(l); for (int i
	 * = 0; i < list.size(); ++i) { try{ frame.add(new ItemRepr(list.get(i),
	 * this)); }catch(Exception e){ System.out.println("Hola"); } } return
	 * frame; }
	 */

	private Component information() {
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.white);
		infoPanel.setVisible(true);
		infoPanel.setLayout(new FlowLayout());
		infoPanel.add(Box.createRigidArea(new Dimension(1200, 1)));
		infoPanel.add(this.generateComponent(new JButton("Politicas de empresa"), Color.black, "PENE",
				new Font("Arial", 2, 10)));
		infoPanel.add(this.generateComponent(new JButton("Politicas de empresa"), Color.gray, "PENE",
				new Font("Arial", 2, 10)));
		infoPanel.add(this.generateComponent(new JButton("Politicas de empresa"), Color.gray, "PENE",
				new Font("Arial", 2, 10)));
		infoPanel.add(this.generateComponent(new JButton("Politicas de empresa"), Color.gray, "PENE",
				new Font("Arial", 2, 10)));
		return infoPanel;
	}

	private Component generateComponent(JButton button, Color color, String text, Font font) {
		button = new JButton();
		button.setBackground(Color.white);
		button.setFont(font);
		button.setForeground(color);
		button.setText(text);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello pene");
			}
		});
		return button;
	}

	// --------End Private-------------------

	// ----------testing--------------------

	/*
	 * public static void main(String[] args) { JFrame f = new JFrame();
	 * f.setBackground(Color.white); f.setVisible(true);
	 * //f.setPreferredSize(new Dimension(1200, 900)); f.setLayout(new
	 * BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS)); JScrollPane j = new
	 * JScrollPane(new MainSwing(new Controler()),
	 * JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	 * JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	 * //f.setPreferredSize(j.getSize()); f.add(j); j.setVisible(true);
	 * f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 * //f.setExtendedState(JFrame.MAXIMIZED_BOTH); f.pack();
	 * 
	 * }
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * JFrame f = new JFrame(); f.setBackground(Color.white);
	 * f.setPreferredSize(new Dimension(1200, 900)); f.setLayout(new
	 * BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS)); JScrollPane j = new
	 * JScrollPane(new MainSwing(new Controler(new Model())),
	 * JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	 * JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); j.setPreferredSize(new
	 * Dimension(800, 12000)); j.getVerticalScrollBar().setUnitIncrement(10);
	 * f.add(j); f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 * f.setExtendedState(JFrame.MAXIMIZED_BOTH); j.setVisible(true);
	 * f.setVisible(true);
	 * 
	 * }
	 * 
	 * // ------------End testing--------------------------------
	 */
	@Override
	public void opAppEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void opAppStart(List<ItemVO> actList) {
		midPanel = new ItemsList(actList, ctrl);
		initGUI();
	}

	@Override
	public void OnUserLogOut() {

	}

	@Override
	public void OnLoginRight(UserVO u) {

	}

	@Override
	public void OnLoginFail(UserVO u) {

	}

	@Override
	public void OnListAct(List<ItemVO> list) {
		if (!list.isEmpty()) {
			midPanel = new ItemsList(list, ctrl);
			initGUI();
		} else {
			JOptionPane.showMessageDialog(null, "Empty List");
		}

	}

	public void setPanel(JPanel panel) {
		midPanel = panel;
		initGUI();
	}

	public Controler getControler() {
		return this.ctrl;
	}
}
