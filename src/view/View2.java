package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controller.Controler;
import view.Panels.MainSwing;

public class View2 extends JFrame{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		MainSwing panel;

		public void start(Controler ctrl) {
			/*System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
			try {
				UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
			} catch (Exception e) {
				System.err.print("Error at Look And Feel");
			}*/
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			this.setPreferredSize(dimension);
			this.setLocationRelativeTo(null);
			this.panel = new MainSwing(ctrl);
			this.add(panel);
			ctrl.add(panel);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.setVisible(true);
			this.setBackground(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		/*
		 * public static void main(String[] args) { MainPanel panel = new
		 * MainPanel(Toolkit.getDefaultToolkit().getScreenSize(), new Controler());
		 * 
		 * }
		 */

}
