package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;
import factoryDesingPattern.BasicPanel;
import utils.Utils;

public class ListPanel extends BasicPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;

	private JPanel containerPanel;

	private JScrollPane scroll;
	private ArrayList<JButton> buttonList;
	private ArrayList<JTextArea> textList;

	private ArrayList<JLabel> labelList;
	private ArrayList<ImageIcon> imageList;

	private ImageIcon imageIcon;

	public ListPanel(Dimension dimension, Controler ctrl) {
		super.setPreferredSize(dimension);
		this.ctrl = ctrl;
	}

	@Override
	public void initComponets() {
		this.containerPanel = new JPanel();
		this.containerPanel.setLayout(new GridBagLayout());
		this.buttonList = new ArrayList<JButton>();
		this.labelList = new ArrayList<JLabel>();
		this.imageList = new ArrayList<ImageIcon>();
		this.textList = new ArrayList<JTextArea>();
	}

	public ImageIcon iconToImageIcon(Icon icon) {
		ImageIcon imageIconRetur = new ImageIcon(this.iconToImage(icon));
		return imageIconRetur;
	}

	public Image iconToImage(Icon icon) {
		if (icon instanceof ImageIcon) {
			return ((ImageIcon) icon).getImage();
		} else {
			int w = icon.getIconWidth();
			int h = icon.getIconHeight();
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gd = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gd.getDefaultConfiguration();
			BufferedImage image = gc.createCompatibleImage(w, h);
			Graphics2D g = image.createGraphics();
			icon.paintIcon(null, g, 0, 0);
			g.dispose();
			return image;
		}
	}

	public Icon bufferedImageToIcon(BufferedImage bufferImage) {
		ImageIcon imgIcon = new ImageIcon(bufferImage);
		Icon iconReturn = (Icon) (imgIcon);
		return iconReturn;
	}

	@Override
	public void initGUI() {
		this.scroll = new JScrollPane(this.containerPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.scroll.setBorder(null);
		this.scroll.getVerticalScrollBar().setUnitIncrement(10);
		this.scroll.setPreferredSize(Utils.adjustDimension(0.7, 0.9, this.getPreferredSize()));
		this.scroll.setVisible(true);
		this.add(scroll);
		this.setBackground(null);
		this.validate();
		this.repaint();
	}

	private String generateItemInfo(String info) {
		try {
			return info.substring(0, 15);
		} catch (Exception e) {
			return info;
		}
	}

	private String generateItemDescription(int i) {
		return "linea descripcion " + i;
	}

	private void buildGUIManager() {
		this.gbc = new GridBagConstraints();
		this.gbc.gridy = 0;
		this.gbc.gridx = 0;
		this.gbc.insets = new Insets(3, 3, 3, 3);
	}

	public void act(List<ItemVO> l, Dimension dimension) {
		this.removeAll();
		this.buildGUIManager();
		this.initComponets();
		for (int i = 0; i < l.size(); ++i) {
			this.imageIcon = new ImageIcon("src/images/sword (2).png");

			buttonList.add(new JButton());
			buttonList.get(i).setToolTipText("Click for more information belongs to the item");
			buttonList.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			imageList.add(this.imageIcon);
			labelList.add(new JLabel(this.imageIcon));
			labelList.get(i).setIcon(this.imageList.get(i));

			ItemVO itemAct = l.get(i);
			this.generateProductPanel(
					new Dimension((int) BasicPanel.screenWidht*2 / 6, (int) BasicPanel.screenHeight*2 / 5), itemAct,
					buttonList.get(i), factory);
			this.generateProductListButton(dimension, itemAct.getName(), buttonList.get(i), this.getBackground());
			this.containerPanel.add(buttonList.get(i), this.gbc);
			++this.gbc.gridx;
			this.containerPanel.add(new JLabel(this.generateItemInfo(itemAct.getDesc())),
					this.gbc);
			--this.gbc.gridx;
			++this.gbc.gridy;
			this.containerPanel.add(this.labelList.get(i), this.gbc);
			++this.gbc.gridx;
			this.textList.add(new JTextArea());
			textList.get(i).setBackground(null);
			textList.get(i).setText("Price: " + itemAct.getPrice() + "\n");
			textList.get(i).append("Last bidder: " + itemAct.getIdCategory() + "\n");
			textList.get(i).append("Owner: " + itemAct.getName() + "\n");
			this.containerPanel.add(textList.get(i), this.gbc);
			++this.gbc.gridy;
			this.gbc.gridx = 0;
			this.imageIcon = Utils.parseIcon(l.get(i).getIdCategory());
			i++;
		}
		this.initGUI();

	}

}
