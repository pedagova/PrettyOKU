package factoryDesingPattern.panelList;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import factoryDesingPattern.BasicPanel;
import utils.Utils;

public class ListPanel extends BasicPanel {

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
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		this.gbc = new GridBagConstraints();
		this.gbc.gridy = 0;
		this.gbc.gridx = 0;
		this.gbc.insets = new Insets(3, 3, 3, 3);
		this.containerPanel = new JPanel();
		this.containerPanel.setLayout(new GridBagLayout());
		this.scroll = new JScrollPane(this.containerPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.scroll.setBorder(null);
		this.scroll.setPreferredSize(Utils.adjustDimension(1, 0.9, this.getPreferredSize()));
		this.scroll.setVisible(true);
		for (int i = 0; i < ListPanel.NUMBER_ITEM; ++i) {
			buttonList.add(new JButton("See more"));
			buttonList.get(i).setToolTipText("Click for more information belongs to the item");
			buttonList.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
		}

	}

	@Override
	public void initGUI() {
		for (JButton button : this.buttonList) {
			this.containerPanel.add(button, this.gbc);
			++this.gbc.gridx;
			this.containerPanel.add(new JLabel(this.generateItemInfo()), this.gbc);
			++this.gbc.gridy;
			this.gbc.gridx = 0;
		}
		this.add(this.scroll);

	}

	private String generateItemInfo() {
		return "ejemplo de lo que deberia salir por aqui";
	}

	
	  public static void main(String[] arg) {
	  
	  JFrame frame = new JFrame("Product List"); frame.setVisible(true);
	  frame.setSize(500, 500); ListPanel productPanel = new ListPanel(new
	  Dimension(500, 600)); frame.add(productPanel); frame.pack();
	  
	  }
	 
	/*public static void main(String[] args) throws URISyntaxException {
		final URI uri = new URI("http://java.sun.com");
		class OpenUrlAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				open(uri);
			}
		}
		JFrame frame = new JFrame("Links");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 400);
		Container container = frame.getContentPane();
		container.setLayout(new GridBagLayout());
		JButton button = new JButton();
		button.setText(
				"<HTML>Click the <FONT color=\"#000099\"><U>link</U></FONT>" + " to go to the Java website.</HTML>");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBorderPainted(false);
		button.setOpaque(false);
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame j = new JFrame();
				j.setPreferredSize(new Dimension(600, 600));
				j.setVisible(true);
				j.add(new MainPanel(new Dimension(500, 500)));
			}
		});
		container.add(button);
		frame.setVisible(true);
	}

	private static void open(URI uri) {
		if (true) {
			new MainPanel(new Dimension(500, 500));
		} else {
	}*/

}
