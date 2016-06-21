package view.Panels;

import javax.swing.JPanel;

import controller.Controler;

public abstract class Panel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Controler ctrl;
	
	Panel(Controler ctrl){
		this.ctrl = ctrl;
	}
}
