package factoryDesingPattern.panelList;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.Utils;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginPanel login;

	private ListPanel aux;

	private ListPanel list;

	private GeneralInfoPanel infoPanel;

	private GridBagConstraints gbc;

	public MainPanel(Dimension dimension) {
		// this.setLayout(new GridBagLayout());
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(dimension);
		// this.setBorder(new TitledBorder(new EtchedBorder(), "USER LOGIN", 1,
		// 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();

	}

	public void initComponets() {
		this.gbc = new GridBagConstraints();
		this.login = new LoginPanel(Utils.adjustDimension(0.4, 0.15, this.getPreferredSize()));
		this.aux = new ListPanel(Utils.adjustDimension(0.4, 0.4, this.getPreferredSize()));
		this.list = new ListPanel(Utils.adjustDimension(1, 1, this.getPreferredSize()));
		this.infoPanel = new GeneralInfoPanel(Utils.adjustDimension(1, 0.3, this.getPreferredSize()));

	}

	public void initGUI() {
		// this.gbc.fill = GridBagConstraints.BOTH;
		JPanel auxLeft = new JPanel();
		auxLeft.setLayout(new BoxLayout(auxLeft, BoxLayout.Y_AXIS));
		auxLeft.setPreferredSize(new Dimension(100, 200));
		auxLeft.add(login);
		auxLeft.add(aux);
		JPanel auxTop = new JPanel();
		/*
		 * gbc.anchor = GridBagConstraints.FIRST_LINE_START; gbc.gridwidth = 5;
		 * gbc.gridheight = 8; this.add(this.login, this.gbc); gbc.anchor =
		 * GridBagConstraints.LINE_START; gbc.gridwidth = 5; this.add(this.aux,
		 * this.gbc);
		 */
		auxTop.setLayout(new BoxLayout(auxTop, BoxLayout.X_AXIS));
		auxTop.add(auxLeft);
		auxTop.add(list);
		/*
		 * gbc.anchor = GridBagConstraints.LINE_END; gbc.gridwidth = 5;
		 * this.add(this.list, this.gbc);
		 */
		this.add(auxTop);
		this.add(infoPanel);
		/*
		 * gbc.anchor = GridBagConstraints.PAGE_END; gbc.gridwidth = 10;
		 * this.add(this.infoPanel, this.gbc);
		 */

	}

	private void adjustGrid(int x, int y) {
		this.gbc.gridx = x;
		this.gbc.gridy = y;
	}

	private void setAnchor(int anchorX, int anchorY) {
		this.gbc.gridwidth = anchorX;
		this.gbc.gridheight = anchorY;
	}

	public static void main(String[] arg) {
		JFrame frame = new JFrame();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		dimension = Utils.reSize(0.7, 0.7);
		MainPanel main = new MainPanel(new Dimension(500, 500));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setPreferredSize(dimension);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
		frame.add(main);

	}

}
