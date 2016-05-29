package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;
import dataAccessObjectDesingPattern.UserVO;
import factoryDesingPattern.BasicPanel;
import factoryDesingPattern.PanelType;
import model.AppObserver;
import utils.Utils;

public class MainPanel extends BasicPanel implements AppObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginPanel login;

	private UserInfoPanel userInfo;

	private TagPanel tagList;

	private ListPanel list;

	private JPanel auxLeft;

	private JPanel auxTop;

	private JButton info1;
	private JButton info2;
	private JButton info3;
	private JButton info4;
	private JButton info5;

	public MainPanel(Dimension dimension, Controler ctrl) {
		this.ctrl = new Controler();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(dimension);

		this.initComponets();
		this.initGUI();
		this.ctrl.add(this);

	}

	private void initButton() {
		this.info1 = new JButton();
		this.info2 = new JButton();
		this.info3 = new JButton();
		this.info4 = new JButton();
		this.info5 = new JButton();
		super.genereteBottonBarButton(this.info1, "About us", 0.1, 0);
		super.genereteBottonBarButton(this.info2, "Payment methods", 0.1, 1);
		super.genereteBottonBarButton(this.info3, "Deliver rates & policy", 0.1, 2);
		super.genereteBottonBarButton(this.info4, "Help", 0.1, 3);
		super.genereteBottonBarButton(this.info5, "LOGGOUT", 0.1, 4);
		JPanel panela = new JPanel();
		panela.add(info1);
		panela.add(info2);
		panela.add(info3);
		panela.add(info4);
		panela.add(info5);
		this.add(panela);


	}
	
	private void initList(){
		
	}

	public void initComponets() {
		this.login = (LoginPanel) BasicPanel.factory.getPanel(PanelType.LOGIN_PANEL, new Dimension(400, 100),
				this.ctrl);
		this.userInfo = (UserInfoPanel) BasicPanel.factory.getPanel(PanelType.USER_INFO_PANEL,
				Utils.newDim(BasicPanel.screenWidht, BasicPanel.screenHeight, 0.5, 0.5), this.ctrl);
		this.tagList = (TagPanel) BasicPanel.factory.getPanel(PanelType.TAG_PANEL,
				Utils.newDim(BasicPanel.screenWidht, BasicPanel.screenHeight, 0.5, 0.4), ctrl);
		this.list = (ListPanel) BasicPanel.factory.getPanel(PanelType.LIST_PANEL,
				Utils.newDim(BasicPanel.screenWidht, BasicPanel.screenHeight, 0.5, 0.9), ctrl);

	}

	public void initGUI() {
		this.userInfo.setVisible(false);
		auxLeft = new JPanel();
		auxLeft.setLayout(new BoxLayout(auxLeft, BoxLayout.Y_AXIS));
		auxLeft.add(login);
		auxLeft.add(tagList);

		auxTop = new JPanel();

		auxTop.setLayout(new BoxLayout(auxTop, BoxLayout.X_AXIS));
		auxTop.add(auxLeft);
		auxTop.add(list);
		this.add(auxTop);

		this.initButton();
		
		
	}
/*
	public static void main(String[] arg) {
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		} catch (Exception e) {
			System.err.print("Error at Look And Feel");
		}

		JFrame frame = new JFrame();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		MainPanel main = new MainPanel(dimension, new Controler());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setPreferredSize(dimension);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(main);

	}*/

	@Override
	public void opAppEnd() {

	}

	@Override
	public void OnUserLogOut() {
		// popear adios
		// desloguearte
	}

	@Override
	public void OnLoginRight(UserVO u) {
		this.removeAll();
		this.validate();
		this.auxLeft.removeAll();
		this.auxLeft.validate();
		this.auxLeft.setLayout(new BoxLayout(auxLeft, BoxLayout.Y_AXIS));
		this.auxLeft.add(userInfo);
		this.auxLeft.add(tagList);

		this.auxTop.removeAll();
		this.auxTop.validate();
		this.auxTop.setLayout(new BoxLayout(auxTop, BoxLayout.X_AXIS));
		this.auxTop.add(this.auxLeft);
		this.auxTop.add(this.list);

		this.add(auxTop);

		this.initButton();

		login.setVisible(false);
		userInfo.setVisible(true);
		userInfo.setInfo(u);
		this.ctrl.setLoggedOn(true);
		this.repaint();

	}

	@Override
	public void OnLoginFail(UserVO u) {
		// Popear dialog error
		System.out.println("Error");
	}

	@Override
	public void OnListAct(List<ItemVO> l) {
		this.list.act(l, Utils.newDim(BasicPanel.screenWidht, BasicPanel.screenHeight, 0.5, 0.9), factory);
		this.list.repaint();
	}

	@Override
	public void opAppStart(List<ItemVO> actList) {
		this.OnListAct(actList);

	}

}