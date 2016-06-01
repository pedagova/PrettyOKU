package view.Panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import controller.Controler;
import view.ViewUtilities;

public class MainSwing extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Color backColor = new Color(255, 69, 0);
	
	//----------anonimus class--------------
	private class Separator extends JPanel{
		
		public Separator(Dimension d, Color c){
			this.setPreferredSize(d);
			this.setBackground(c);			
		}
	}
	//---------end anonimus class----------
	
	// -------------Atributos-----------------
	Controler ctrl;

	// -----------fin Atributos---------------

	// ------------Public---------------------
	// Constructors
	public MainSwing(Controler ctrl) {
		this.ctrl = ctrl;
		this.setPreferredSize(new Dimension(500,235));
		initGUI();
	}
	// --------end Public---------------------

	// ------------Private--------------------
	private void initGUI() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		
	
		setBackground(Color.white);
		
		setPreferredSize(new Dimension(800, 2000));
		
		
		add(generateLogo());
		add(Box.createRigidArea(new Dimension((int)getPreferredSize().getWidth(), 6)));
		add(tags());
		add(Box.createRigidArea(new Dimension((int)getPreferredSize().getWidth(), 6)));
		add(userBar());
		add(interestItems());
		//add(information());
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
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setPreferredSize(new Dimension(500, 30));
		p.setBackground(Color.ORANGE);
		
		// -------------------1 button------------------------
		JButton homeB = ViewUtilities.generateButton("Home", "3", backColor, "#FFF5EE");
		homeB.setPreferredSize(new Dimension(75, 30));
		p.add(homeB);
		// ---------------end 1 button -----------------------
		p.add(new Separator(d, c));
		// ------------------2 button-------------------------
		JButton button2 = ViewUtilities.generateButton("button2", "3", backColor, "#FFF5EE");
		button2.setPreferredSize(new Dimension(75, 30));
		p.add(button2);
		// ---------------end 2 button-----------------------
		p.add(new Separator(d, c));
		// -------------------3 button------------------------
		JButton button3 = ViewUtilities.generateButton("button3", "3", backColor, "#FFF5EE");
		button3.setPreferredSize(new Dimension(75, 30));
		p.add(button3);
		// ---------------end 3 button -----------------------
		p.add(new Separator(d, c));
		// -------------------4 button------------------------
		JButton button4 = ViewUtilities.generateButton("button4", "3", backColor, "#FFF5EE");
		button4.setPreferredSize(new Dimension(75, 30));
		p.add(button4);
		// ---------------end 4 button -----------------------
		p.add(new Separator(d, c));
		//-----------------5 button---------------------------
		JButton button5 = ViewUtilities.generateButton("button5", "3", backColor, "#FFF5EE");
		button5.setPreferredSize(new Dimension(75, 30));
		p.add(button5);
		// ---------------end 5 button -----------------------
		p.add(new Separator(d, c));
		
		return p;
	}
	
	private Component userBar() {
		
		final String text = "Bienvenido a Oku, la tiendo de subastas para los \"Otaku\"";
		
		JPanel p = new JPanel();
		p.setBackground(new Color(240, 241, 241));
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setPreferredSize(new Dimension((int)getPreferredSize().getWidth(), 50));
		
		JTextArea t = new JTextArea(text);
		t.setFont(new Font("Microsof sans serif", Font.BOLD, 12));
		t.setBackground(null);
		t.setEditable(false);
		t.setPreferredSize(new Dimension((int)getPreferredSize().getWidth() / 2, 50));
		
		p.add(t);
		
		//p.add(buscador());
		
		p.add(new Separator(new Dimension(1, 2), Color.lightGray));
		
		if(!ctrl.isLoggedOn()){
			JButton id = new JButton("Identificate");
			id.setFont(new Font("Microsof sans serif", Font.BOLD, 10));
			id.setBackground(null);
			id.setForeground(Color.GRAY);
			id.setBorder(null);
			id.setPreferredSize(new Dimension((int)getPreferredSize().getWidth() / 4, 50));
			p.add(id);
		}
		else{
			JButton id = new JButton("Bienvenid@\n" + "pedagova@gmail.com");
			id.setFont(new Font("Microsof sans serif", Font.BOLD, 8));
			id.setBackground(null);
			id.setForeground(Color.GRAY);
			id.setBorder(null);
			id.setPreferredSize(new Dimension((int)getPreferredSize().getWidth() / 4, 50));
			p.add(id);
		}
		return p;
	}
	
	private Component interestItems() {
		JPanel frame = new JPanel();
		frame.setBackground(null);
		frame.setPreferredSize(new Dimension(800, (260 + 10) * 7 ));
		GridLayout l = new GridLayout(7, 3);
		l.setHgap(10);
		l.setVgap(10);
		frame.setLayout(l);
		for (int i = 0; i < 21; ++i) {
			frame.add(new ItemRepr());
		}
		return frame;
	}

	private Component information() {
		// TODO Auto-generated method stub
		return null;
	}

	// --------End Private-------------------

	// ----------testing--------------------

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setBackground(Color.white);
		f.setVisible(true);
		f.setPreferredSize(new Dimension(1200, 900));
		f.setLayout(new BoxLayout(f.getContentPane(),BoxLayout.Y_AXIS));
		JScrollPane j = new JScrollPane(new MainSwing(new Controler()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		j.setPreferredSize(new Dimension(800, 12000));
		j.setVisible(true);
		f.add(j);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	// -----End testing---------------------
}
