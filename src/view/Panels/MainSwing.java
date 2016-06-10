package view.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.plaf.IconUIResource;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;
import dataAccessObjectDesingPattern.UserVO;
import factoryDesingPattern.panelList.ListPanel;
import model.AppObserver;
import model.Model;
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
		midPanel = new ItemsList(new ArrayList<ItemVO>(), this);
		initGUI();
		ctrl.add(this);
	}
	// --------end Public---------------------

	// ------------Private--------------------
	public void initGUI() {

		removeAll();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		setBackground(Color.white);

		// setPreferredSize(new Dimension(800, 2000));

		add(generateLogo());
		add(Box.createRigidArea(new Dimension((int) getPreferredSize().getWidth(), 6)));
		add(tags());
		add(Box.createRigidArea(new Dimension((int) getPreferredSize().getWidth(), 6)));
		add(userBar());
		add(Box.createRigidArea(new Dimension((int) getPreferredSize().getWidth(), 6)));
		add(midPanel);
		// add(information());
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
		final Dimension d = new Dimension(1, 2);
		final Color c = Color.GRAY;
		final int N = 20;
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setPreferredSize(new Dimension(500, 30));
		p.setBackground(Color.ORANGE);

		// -------------------1 button------------------------
		JButton homeB = ViewUtilities.generateButton("Home", "3", backColor, "#FFF5EE");
		homeB.setPreferredSize(new Dimension(75, 30));
		homeB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getN(N);
			}
		});
		p.add(homeB);
		// ---------------end 1 button -----------------------
		p.add(new Separator(d, c));
		// ------------------2 button-------------------------
		JButton button2 = ViewUtilities.generateButton("Games", "3", backColor, "#FFF5EE");
		button2.setPreferredSize(new Dimension(75, 30));
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("1");
			}
		});
		p.add(button2);
		// ---------------end 2 button-----------------------
		p.add(new Separator(d, c));
		// -------------------3 button------------------------
		JButton button3 = ViewUtilities.generateButton("Manga", "3", backColor, "#FFF5EE");
		button3.setPreferredSize(new Dimension(75, 30));
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("2");
			}
		});
		p.add(button3);
		// ---------------end 3 button -----------------------
		p.add(new Separator(d, c));
		// -------------------4 button------------------------
		JButton button4 = ViewUtilities.generateButton("Merchandasing", "3", backColor, "#FFF5EE");
		button4.setPreferredSize(new Dimension(75, 30));
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("3");
			}
		});
		p.add(button4);
		// ---------------end 4 button -----------------------
		p.add(new Separator(d, c));
		// -----------------5 button---------------------------
		JButton button5 = ViewUtilities.generateButton("miscellaneus", "3", backColor, "#FFF5EE");
		button5.setPreferredSize(new Dimension(75, 30));
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("4");
			}
		});
		p.add(button5);
		// ---------------end 5 button -----------------------
		p.add(new Separator(d, c));

		return p;
	}

	private Component userBar() {

		final String text = "Bienvenido a Oku, la tienda de subastas para los \"Otaku\"";

		int widht = 800;

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
			id.setFont(new Font("Arial", Font.BOLD, 12));
			id.setBackground(null);
			id.setForeground(Color.GRAY);
			id.setBorder(null);
			id.setPreferredSize(new Dimension(widht * 20 / 100, UsesBarSize - 18));
			p3.add(id);
		} else {
			JButton id = new JButton("Bienvenid@\n" + "pedagova@gmail.com");
			id.setFont(new Font("Microsof sans serif", Font.BOLD, 8));
			id.setBackground(null);
			id.setForeground(Color.GRAY);
			id.setBorder(null);
			id.setPreferredSize(new Dimension(widht * 20 / 100, UsesBarSize));
			p3.add(id);
		}

		p.add(p3);
		p.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);

		JButton b = new JButton("add item");
		b.setBackground(null);
		b.setBorder(null);
		b.setPreferredSize(new Dimension(widht * 10 / 100, UsesBarSize));
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hola");
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

	/*private Component interestItems(List<ItemVO> list) {
		JPanel frame = new JPanel();
		final double NUMCOLS = 4.0;
		frame.setBackground(null);
		GridLayout l = new GridLayout((int) NUMCOLS, (int) Math.ceil(list.size() / NUMCOLS));
		l.setHgap(10);
		l.setVgap(10);
		frame.setLayout(l);
		for (int i = 0; i < list.size(); ++i) {
			try{
				frame.add(new ItemRepr(list.get(i), this));
			}catch(Exception e){
				System.out.println("Hola");
			}
		}
		return frame;
	}*/

	private Component information() {
		// TODO Auto-generated method stub
		return null;
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
	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.setBackground(Color.white);
		f.setPreferredSize(new Dimension(1200, 900));
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
		JScrollPane j = new JScrollPane(new MainSwing(new Controler(new Model())),
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		j.setPreferredSize(new Dimension(800, 12000));
		j.getVerticalScrollBar().setUnitIncrement(10);
		f.add(j);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		j.setVisible(true);
		f.setVisible(true);

	}

	// ------------End testing--------------------------------

	@Override
	public void opAppEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void opAppStart(List<ItemVO> actList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnUserLogOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnLoginRight(UserVO u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnLoginFail(UserVO u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnListAct(List<ItemVO> list) {
		midPanel = new ItemsList(list, this);
		initGUI();
	}

	public void start(Controler controler) {
		// TODO Auto-generated method stub
		
	}

	public void setPanel(ShowProduct panel) {
		midPanel = panel;
		initGUI();
	}

	public Controler getControler() {
		// TODO Auto-generated method stub
		return this.ctrl;
	}
}
