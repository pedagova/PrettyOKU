package view.Panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;

public class ItemsList extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Controler ctrl;
	
	public ItemsList(List<ItemVO> list, Controler ctrl){
		final double NUMCOLS = 4.0;
		this.ctrl = ctrl;
		setBackground(null);
		GridLayout l;
		if((list.size() / NUMCOLS < 3))
			l = new GridLayout(3, (int) NUMCOLS);
		else
			l = new GridLayout( (int) Math.ceil(list.size() / NUMCOLS), (int) NUMCOLS);
		l.setHgap(10);
		l.setVgap(10);	
		setLayout(l);
		for (int i = 0; i < list.size(); ++i) {
			add(new ItemRepr(list.get(i), ctrl));
		}
		if(list.size() % NUMCOLS != 0){
			for(int i = 0; i <  4 - (int)(list.size() % NUMCOLS); i++ ){
				//add(Box.createRigidArea(new ItemRepr(list.get(0), ctrl).getPreferredSize()));
				//add(new ItemRepr(new ItemVO("Holas", "", "", ""), ctrl));
				add(Box.createRigidArea(new Dimension(250, 260)));
			}
			
		}
		if(list.size() / NUMCOLS < 3){
			for(int i = 0; i < 3 - Math.ceil(list.size() / NUMCOLS); i++){
				for(int j = 0; j < NUMCOLS; j++){
					//Component c = Box.createRigidArea(new ItemRepr(new ItemVO("", "", "", ""), ctrl).getPreferredSize());
					//add(new ItemRepr(new ItemVO("Adioses", "", "", ""), ctrl));
					add(Box.createRigidArea(new Dimension(250, 260)));
				}
			}
		}
	}
	
}
