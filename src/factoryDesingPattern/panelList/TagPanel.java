package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import controller.Controler;
import factoryDesingPattern.BasicPanel;

public class TagPanel extends BasicPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextPane titleList;
	private JButton videoGames;
	private JButton manga;
	private JButton merchandising;
	private JButton miscelanius;
	private JButton art;
	private JButton gadgets;

	private GridBagConstraints gbc;

	public TagPanel(Dimension dimension, Controler ctrl) {
		super.setPreferredSize(dimension);
		super.setLayout(new GridBagLayout());
		this.ctrl = ctrl;
		this.initComponets();
		this.initGUI();
		// this.setBorder(new TitledBorder(new EtchedBorder(), "adsad", 1, 1,
		// new Font("", 9, 28)));

	}

	@Override
	public void initComponets() {
		this.gbc = new GridBagConstraints();

		this.titleList = new JTextPane();
		this.generateTextPane(this.titleList, "<font size=\"16\">LIST OF TAGS</font>", 0.1);

		this.videoGames = new JButton("Video games");
		this.videoGames.setToolTipText("Click for see a list of video games");
		//this.genereteLinkButton(this.videoGames, ">> Video games", 0.1);

		this.videoGames.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("1");
			}

		});

		this.manga = new JButton("Manga");
		this.genereteLinkButton(this.manga, " >> Manga", 0.1);

		this.manga.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("2");
			}

		});

		this.merchandising = new JButton("Merchandising");
		this.genereteLinkButton(this.merchandising, " >> Merchandising", 0.1);

		this.merchandising.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("3");
			}

		});

		this.miscelanius = new JButton("Miscelanius");
		this.genereteLinkButton(this.miscelanius, " >> Miscelanius", 0.1);

		this.miscelanius.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("4");
			}

		});

		this.art = new JButton("Art");
		this.genereteLinkButton(this.art, " >> Art", 0.1);
		this.art.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("5");
			}

		});
		this.gadgets = new JButton("Electronic gadgets");
		this.genereteLinkButton(this.gadgets, " >> Gadgets", 0.1);
		this.gadgets.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getAll("6");
			}

		});
	}

	@Override
	public void initGUI() {
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;
		this.gbc.fill = GridBagConstraints.BOTH;
		this.add(this.titleList, this.gbc);
		++this.gbc.gridy;
		this.add(this.videoGames, this.gbc);
		++this.gbc.gridy;
		this.add(this.manga, this.gbc);
		++this.gbc.gridy;
		this.add(this.merchandising, this.gbc);
		++this.gbc.gridy;
		this.add(this.miscelanius, this.gbc);
		++this.gbc.gridy;
		this.add(this.art, this.gbc);
		++this.gbc.gridy;
		this.add(this.gadgets, this.gbc);
		// this.add(Box.createRigidArea(Utils.adjustDimension(1, 0.9,
		// this.getPreferredSize())));
	}

	/*
	 * public static void main(String[] arg) {
	 * System.setProperty("Quaqua.tabLayoutPolicy", "wrap"); try {
	 * UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.
	 * getLookAndFeel()); } catch (Exception e) { System.err.print(
	 * "Error at Look And Feel"); } JFrame frame = new JFrame();
	 * frame.setPreferredSize(new Dimension(300, 400)); frame.pack();
	 * frame.setLocationRelativeTo(null); frame.add(new TagPanel(new
	 * Dimension(300, 400))); frame.setVisible(true); }
	 */

}
