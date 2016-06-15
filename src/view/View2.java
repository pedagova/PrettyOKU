package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import controller.Controler;
import view.Panels.MainSwing;

public class View2 extends JFrame implements StandartInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MainSwing panel;

	JScrollPane sp;

	@Override
	public void start(Controler ctrl) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(new Dimension(500, 500));
		this.setLocationRelativeTo(null);
		this.panel = new MainSwing(ctrl);
		this.panel.setBorder(BorderFactory.createLineBorder(Color.blue));
		JPanel pAux = new JPanel();
		pAux.setBackground(null);
		pAux.setLayout(new BoxLayout(pAux, BoxLayout.X_AXIS));
		pAux.add(Box.createRigidArea(new Dimension(100, 1)));
		pAux.add(panel);
		pAux.add(Box.createRigidArea(new Dimension(100, 1)));
		sp = new JScrollPane(pAux, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(sp);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void changePanel(JPanel p) {
		panel.setPanel(p);
	}

	@Override
	public void initGUI() {
		panel.initGUI();

	}
}