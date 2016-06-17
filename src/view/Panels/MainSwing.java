package view.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
	final int N = 20;

	public JPanel midPanel;

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
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(null);

		JPanel auxPanel = new JPanel();
		auxPanel.setLayout(new GridLayout(1, 3));
		if (ctrl.getCategory() != null) {
			TagList tag =new TagList(ctrl);
			auxPanel.add(tag);
		}else{
			auxPanel.add(Box.createRigidArea(new Dimension(100, 1)));
		}
		
		auxPanel.add(Box.createRigidArea(new Dimension(25, 1)));
		auxPanel.setBackground(null);
		panel.add(auxPanel);
		panel.add(midPanel);
		panel.add(Box.createRigidArea(new Dimension(25, 1)));
		add(panel);
		// add(information());
		validate();
		repaint();
	}

	private Component generateLogo() {
		JPanel p = new JPanel();
		p.setBackground(Color.white);
		JButton b = new JButton();
		b.setBorder(null);
		b.setIcon(new ImageIcon("src/images/banner.jpg"));
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.setCategory(null);
				ctrl.getN(N);
			}
		});
		p.setPreferredSize(new Dimension(1100, 150));

		p.add(b);

		return p;
	}

	private Component tags() {
		JPanel p = new JPanel();

		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setPreferredSize(new Dimension(500, 30));
		p.setBackground(null);

		// -------------------1 button------------------------
		JButton homeB = ViewUtilities.generateButton("Home", "3", backColor, "#FFF5EE");
		homeB.setPreferredSize(new Dimension(1, 30));
		homeB.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		homeB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.setCategory(null);
				ctrl.getN(N);
			}
		});
		p.add(homeB);
		// ---------------end 1 button -----------------------
		//
		// ------------------2 button-------------------------
		JButton button2 = ViewUtilities.generateButton("Games", "3", backColor, "#FFF5EE");
		button2.setPreferredSize(new Dimension(1, 30));
		button2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ctrl.setCategory(Tags.VIDEO_GAMES);
				ctrl.getAll("1");
			}
		});
		p.add(button2);
		// ---------------end 2 button-----------------------

		// -------------------3 button------------------------
		JButton button3 = ViewUtilities.generateButton("Manga", "3", backColor, "#FFF5EE");
		button3.setPreferredSize(new Dimension(1, 30));
		button3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ctrl.setCategory(Tags.MANGA);
				ctrl.getAll("4");
			}
		});
		p.add(button3);
		// ---------------end 3 button -----------------------

		// -------------------4 button------------------------
		JButton button4 = ViewUtilities.generateButton("Merchandasing", "3", backColor, "#FFF5EE");
		button4.setPreferredSize(new Dimension(1, 30));
		button4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ctrl.setCategory(Tags.MERCHANDASING);
				ctrl.getAll("3");
			}
		});
		p.add(button4);
		// ---------------end 4 button -----------------------

		// -----------------5 button---------------------------
		JButton button5 = ViewUtilities.generateButton("Art", "3", backColor, "#FFF5EE");
		button5.setPreferredSize(new Dimension(1, 30));
		button5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.setCategory(Tags.ART);
				ctrl.getAll("2");
			}
		});
		p.add(button5);
		// ---------------end 5 button -----------------------

		return p;
	}

	private Component userBar() {
		int widht = 750;

		JPanel p = new JPanel();
		p.setBackground(new Color(240, 241, 241));
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setPreferredSize(new Dimension(widht, UsesBarSize));
		p.setBorder(BorderFactory.createLineBorder(new Color(231, 231, 231)));

		JPanel p2 = new JPanel();

		JTextArea t = new JTextArea("Welcome to Ôku, the auction store for \'Otakus\' ");
		t.setFont(new Font("Microsof sans serif", Font.BOLD, 22));
		t.setBackground(null);
		t.setEditable(false);
		t.setPreferredSize(new Dimension(widht * 50 / 100 + 100, UsesBarSize));

		p2.add(t);
		p2.setPreferredSize(t.getPreferredSize());
		p2.setBackground(null);
		p.add(p2);

		p.add(buscador(widht));

		p.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);

		JButton id;
		if (ctrl.getLoggedUser() == null) {
			id = new JButton("Identify");
			id.setFont(new Font("Arial", Font.BOLD, 20));
			id.setBackground(null);
			id.setForeground(Color.GRAY);
			id.setBorder(null);
			id.setPreferredSize(new Dimension((widht * 5 / 100) + 200, UsesBarSize - 20));
			id.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					midPanel = new UserLog(ctrl);
					initGUI();
				}
			});

		} else {
			id = new JButton("Welcome, " + "pedagova@gmail.com");
			id.setFont(new Font("Microsof sans serif", Font.BOLD, 20));
			id.setBackground(null);
			id.setForeground(Color.GRAY);
			id.setBorder(null);
			id.setPreferredSize(new Dimension((widht * 20 / 100) + 200, UsesBarSize));
			id.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					midPanel = new PersonalAccount(ctrl);
					initGUI();
				}
			});
		}

		p.add(id);
		p.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);

		JButton b = new JButton("Add item");
		b.setBorder(null);
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setFont(new Font("Arial", 20, 20));
		b.setBackground(null);
		b.setPreferredSize(new Dimension(widht * 15 / 100, UsesBarSize - 20));
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setPanel(new NewAddItem(ctrl));
			}
		});

		p.add(b);

		return p;
	}

	private Component buscador(int width) {
		JPanel p = new JPanel();
		p.setBackground(null);
		JTextField tf = new JTextField("Search:  ");
		tf.setFont(new Font("Arial", Font.BOLD, 14));
		tf.setBackground(null);
		tf.setBorder(null);
		tf.setEditable(false);
		tf.setPreferredSize(new Dimension(width * 8 / 100 + 6, UsesBarSize - 20));

		JTextArea t = new JTextArea();
		t.setPreferredSize(new Dimension(width * 20 / 100, UsesBarSize - 20));
		t.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

		JButton b = new JButton("Search");
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
		infoPanel.add(this.generateComponent(new JButton("Politicas de empresa"), Color.black, "B1",
				new Font("Arial", 2, 10)));
		infoPanel.add(this.generateComponent(new JButton("Politicas de empresa"), Color.gray, "B2",
				new Font("Arial", 2, 10)));
		infoPanel.add(this.generateComponent(new JButton("Politicas de empresa"), Color.gray, "B3",
				new Font("Arial", 2, 10)));
		infoPanel.add(this.generateComponent(new JButton("Politicas de empresa"), Color.gray, "B4",
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
		ctrl.getN(N);
	}

	@Override
	public void OnLoginFail(UserVO u) {
		System.out.println("Error");
	}

	@Override
	public void OnListAct(List<ItemVO> list) {
		if (!list.isEmpty()) {
			midPanel = new ItemsList(list, ctrl);
			initGUI();
		} else {
			// JOptionPane.showMessageDialog(null, "Empty List");
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
