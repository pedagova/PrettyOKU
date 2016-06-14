package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controler;
import view.Panels.MainSwing;

public class View2 extends JFrame implements StandartInterface{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		MainSwing panel;
		
		JScrollPane sp;

		@Override
		public void start(Controler ctrl) {
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			this.setPreferredSize(dimension);
			this.setLocationRelativeTo(null);
			setLayout(new BorderLayout());
			this.panel = new MainSwing(ctrl);
			
			JPanel pAux = new JPanel();
			
			pAux.add(Box.createRigidArea(new Dimension(40, 1)), BorderLayout.WEST);
			
			
			pAux.add(panel, BorderLayout.CENTER);
			
			pAux.add(Box.createRigidArea(new Dimension(40, 1)), BorderLayout.EAST);
			sp = new JScrollPane(pAux);
			this.add(sp);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.setVisible(true);
			this.setBackground(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

		@Override
		public void changePanel(JPanel p) {
			// TODO Auto-generated method stub
			panel.setPanel(p);
		}

		@Override
		public void initGUI() {
			panel.initGUI();
			
		}

		/*
		 * public static void main(String[] args) { MainPanel panel = new
		 * MainPanel(Toolkit.getDefaultToolkit().getScreenSize(), new Controler());
		 * 
		 * }
		 */

}
