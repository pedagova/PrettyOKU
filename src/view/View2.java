package view;

import java.awt.Color;
import java.awt.Dimension;

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

	private MainSwing panel;

	private JScrollPane sp;

	@Override
	public void start(Controler ctrl) {
		this.setLocationRelativeTo(null);
		this.panel = new MainSwing(ctrl);
		this.panel.setBackground(Color.white);
		JPanel pAux = new JPanel();
		pAux.setBackground(Color.white);
		pAux.setLayout(new BoxLayout(pAux, BoxLayout.X_AXIS));
		pAux.add(Box.createRigidArea(new Dimension(200, 1)));
		pAux.add(panel);
		pAux.add(Box.createRigidArea(new Dimension(200, 1)));
		sp = new JScrollPane(pAux, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.getHorizontalScrollBar().setUnitIncrement(10);
		sp.getVerticalScrollBar().setUnitIncrement(10);
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