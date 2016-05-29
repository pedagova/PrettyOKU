package factoryDesingPattern.panelList;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.Controler;
import factoryDesingPattern.BasicPanel;
import utils.Utils;

public class ItemInfoPanel extends BasicPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea itemInfo;

	private JScrollPane scroll;

	public ItemInfoPanel(Dimension dimension, Controler ctrl) {
		super.setPreferredSize(dimension);
		this.setBorder(BorderFactory.createTitledBorder("PRODUCT INFORMATION"));
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		this.itemInfo = new JTextArea();
		this.itemInfo.setText("");
		//this.itemInfo.setSize(new Dimension(500,500));
		this.itemInfo.setLineWrap(true);
		this.itemInfo.setWrapStyleWord(true);
		this.itemInfo.setEditable(false);
		this.itemInfo.setBackground(null);
		this.scroll = new JScrollPane(this.itemInfo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scroll.setBorder(null);
		this.scroll.setBackground(null);
		this.scroll.setPreferredSize(Utils.adjustDimension(0.9, 1, this.getPreferredSize()));

	}

	@Override
	public void initGUI() {
		this.add(this.scroll);
	}

	private String chain(){
		String text = "0";
		for(int i=1; i<8000; ++i){
			text += i;
		}
		return text;
	}
}
