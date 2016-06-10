package view.Panels;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;

public class ItemsList extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainSwing ctrl;
	
	public ItemsList(List<ItemVO> list, MainSwing ctrl){
		final double NUMCOLS = 4.0;
		this.ctrl = ctrl;
		setBackground(null);
		GridLayout l = new GridLayout((int) NUMCOLS, (int) Math.ceil(list.size() / NUMCOLS));
		l.setHgap(10);
		l.setVgap(10);
		setLayout(l);
		for (int i = 0; i < list.size(); ++i) {
			add(new ItemRepr(list.get(i), ctrl));
		}
	}
	
	public JPanel get(){
		return this;
	}
	
}
