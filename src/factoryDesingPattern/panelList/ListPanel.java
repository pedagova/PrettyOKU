package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import factoryDesingPattern.Panel;
import utils.Utils;

public class ListPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int NUMBER_ITEM = 50;
	
	private ArrayList<JButton> buttonList = new ArrayList<JButton>();
	
	private GridBagConstraints gbc;
	
	private JPanel containerPanel;
	
	private JScrollPane scroll;
	
	public ListPanel(Dimension dimension) {
		super.setPreferredSize(dimension);
		this.setBorder(new TitledBorder(new EtchedBorder(), "General Information", 1, 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();
	}
	
	@Override
	public void initComponets() {
		this.gbc = new GridBagConstraints();
		this.gbc.gridy=0;
		this.gbc.gridx=0;
		this.gbc.insets = new Insets(3, 3, 3, 3);
		this.containerPanel= new JPanel();
		this.containerPanel.setLayout(new GridBagLayout());
		this.scroll = new JScrollPane(this.containerPanel);
		this.scroll.setBorder(null);
		this.scroll.setPreferredSize(Utils.adjustDimension(1, 0.9, this.getPreferredSize()));
		for(int i=0; i< ListPanel.NUMBER_ITEM; ++i){
			buttonList.add(new JButton("See more"));
			buttonList.get(i).setToolTipText("Click for more information belongs to the item");
			buttonList.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
	}
	
	@Override
	public void initGUI() {
		for(JButton button : this.buttonList){
			this.containerPanel.add(button, this.gbc);
			++this.gbc.gridx;
			this.containerPanel.add(new JLabel(this.generateItemInfo()), this.gbc);
			++this.gbc.gridy;
			this.gbc.gridx=0;
		}
		this.add(this.scroll);
		
	}
	
	private String generateItemInfo(){
		return "ejemplo de lo que deberia salir por aqui";
	}

	public static void main(String[] arg) {
		
		JFrame frame = new JFrame("Product List");
		frame.setVisible(true);
		frame.setSize(500, 500);
		ListPanel productPanel = new ListPanel(new Dimension(500, 600));
		frame.add(productPanel);
		frame.pack();

	}
	
}
