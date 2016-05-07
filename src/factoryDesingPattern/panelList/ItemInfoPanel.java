package factoryDesingPattern.panelList;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import dataAccessObjectDesingPattern.ItemDao;
import factoryDesingPattern.BasicPanel;
import utils.Utils;

public class ItemInfoPanel extends BasicPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea itemInfo;

	private JScrollPane scroll;

	public ItemInfoPanel(Dimension dimension) {
		super.setPreferredSize(dimension);
		// this.setBorder(new TitledBorder(new EtchedBorder(), "BID
		// INFORMATION", 1, 1, new Font("", 9, 28)));
		this.setBorder(BorderFactory.createTitledBorder("PRODUCT INFORMATION"));
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		this.itemInfo = new JTextArea();
		this.itemInfo.setLineWrap(true);
		this.itemInfo.setWrapStyleWord(true);
		this.itemInfo.setEditable(false);
		this.itemInfo.setText("A la casa donde vivía el señor Heathcliff se la llamaba «Cumbres Borrascosas» en el dialecto local. El nombre traducía bien los rigores que allí desencadenaba el viento cuando había tempestad. Ventilación no faltaba sin duda. Se advertía lo mucho que azotaba el aire en la inclinación de unos pinos cercanos y en el hecho de que los matorra-les se doblegaban en un solo sentido, como si se proster-nasen ante el sol. El edificio era sólido, de espesos muros a juzgar por lo hondo de las ventanas, y protegidos por grandes guardacantones. " + this.chain());
		//this.generateTextPane(this.itemInfo, new ItemDao().getItem("9").getDesc(), 0);
		this.scroll = new JScrollPane(this.itemInfo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.scroll.setPreferredSize(Utils.adjustDimension(0.9, 0.9, this.getPreferredSize()));

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
	public static void main(String[] arg) {
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		} catch (Exception e) {
			System.err.print("Error at Look And Feel");
		}
		JFrame frame = new JFrame();
		frame.setPreferredSize(Utils.reSize(0.5, 0.5));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.add(new ItemInfoPanel(Utils.reSize(0.5, 0.45)));
		frame.setVisible(true);
	}

}
