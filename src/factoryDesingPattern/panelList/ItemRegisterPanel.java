package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dataAccessObjectDesingPattern.Dao;
import dataBaseConection.clientREST;
import factoryDesingPattern.Panel;
import utils.Utils;

public class ItemRegisterPanel extends Panel{
	private static final long serialVersionUID = 1L;

	private static final double COMPONENT_DIMENSION_Y = 0.03;

	private JTextPane name;
	private JTextField nameRequest;
	private JTextPane description;
	private JScrollPane descriptionRequest;
	private JTextPane price;
	private JTextField priceRequest;

	//Pedir datos al controlador sobre usuario actual
	private String itemId;
	private String itemOwner;
	private String itemLastBidder;
	
	private JButton createAccount;
	private JPanel auxPanel;

	public ItemRegisterPanel(Dimension dimension) {
		super.setPreferredSize(dimension);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new TitledBorder(new EtchedBorder(), "ITEM REGISTER", 1, 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();
	}

	@Override
	public void initComponets() {
		this.name = new JTextPane();
		this.generateTextPane(this.name, "Item name", COMPONENT_DIMENSION_Y);

		this.nameRequest = new JTextField();
		this.generateTextField(this.nameRequest, "tap the item name", COMPONENT_DIMENSION_Y);

		this.description = new JTextPane();
		this.generateTextPane(this.description, "Item description", COMPONENT_DIMENSION_Y);
		
		this.descriptionRequest = new JScrollPane(new JTextArea(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.descriptionRequest.setPreferredSize(Utils.adjustDimension(1, 0.4, this.getPreferredSize()));

		this.price = new JTextPane();
		this.generateTextPane(this.price, "Item price", COMPONENT_DIMENSION_Y);

		this.priceRequest = new JTextField();
		this.priceRequest.setPreferredSize(Utils.adjustDimension(1, COMPONENT_DIMENSION_Y, this.getPreferredSize()));

		this.createAccount = new JButton("Add the item");
		this.createAccount.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// Instancia ddbb
				clientREST ddbb = new clientREST();
				JSONObject ob = ddbb.connectionDDBB("POST", "getProduct", "id= 9");
				try {
					System.out.println(ob.getJSONArray("result"));
				} catch (JSONException e1) {
					System.out.println("Fail");
				}				
			}
		});
		this.auxPanel = new JPanel();
		this.auxPanel.setLayout(new BoxLayout(this.auxPanel, BoxLayout.X_AXIS));
		this.auxPanel.setPreferredSize(Utils.adjustDimension(1, 0.05, this.getPreferredSize()));
		this.auxPanel.setVisible(true);
		this.descriptionRequest.setVisible(true);

	}

	@Override
	public void initGUI() {
		this.add(this.name);
		this.add(this.nameRequest);

		this.add(this.description);
		this.add(this.descriptionRequest);
		this.add(this.price);
		this.add(this.priceRequest);
		this.add(Box.createRigidArea(Utils.adjustDimension(1, 0.05, this.getPreferredSize())));
		this.auxPanel.add(Box.createHorizontalGlue());
		this.auxPanel.add(this.createAccount);
		this.add(this.auxPanel);

	}

	public static void main(String[] arg) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(Utils.reSize(0.35, 0.4));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.add(new ItemRegisterPanel(Utils.reSize(0.35, 0.4)));
		frame.setVisible(true);
	}
}