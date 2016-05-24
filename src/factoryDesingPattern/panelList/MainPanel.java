package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.Controler;
import dataAccessObjectDesingPattern.ItemVO;
import dataAccessObjectDesingPattern.UserVO;
import factoryDesingPattern.BasicPanel;
import model.AppObserver;
import utils.Utils;

public class MainPanel extends BasicPanel implements AppObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginPanel login;

	private UserInfoPanel userInfo;
	
	private TagPanel aux;

	private ListPanel list;

	private double widthValue;

	private double heigthValue;

	public MainPanel(Dimension dimension, Controler ctrl) {
		this.widthValue = dimension.getWidth();
		this.heigthValue = dimension.getHeight();
		// this.setLayout(new GridBagLayout());
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(dimension);
		// this.setBorder(new TitledBorder(new EtchedBorder(), "USER LOGIN", 1,
		// 1, new Font("", 9, 28)));
		this.ctrl = new Controler();
		this.initComponets();
		this.initGUI();
		this.ctrl.add(this);
		
	}

	public void initComponets() {
		this.login = new LoginPanel(new Dimension(400, 100), ctrl);
		this.userInfo = new UserInfoPanel(new Dimension(400, 100), ctrl);
		this.aux = new TagPanel(Utils.newDim(widthValue, heigthValue, 0.5, 0.4), ctrl);
		this.list = new ListPanel(Utils.newDim(widthValue, heigthValue, 0.5, 0.8), ctrl);

	}

	public void initGUI() {
		this.userInfo.setVisible(false);
		JPanel auxLeft = new JPanel();
		auxLeft.setLayout(new BoxLayout(auxLeft, BoxLayout.Y_AXIS));
		// auxLeft.setPreferredSize(new Dimension(100, 200));
		auxLeft.add(login);
		auxLeft.add(aux);

		JPanel auxTop = new JPanel();

		auxTop.setLayout(new BoxLayout(auxTop, BoxLayout.X_AXIS));
		auxTop.add(auxLeft);
		auxTop.add(list);

		this.add(auxTop);

		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		JButton b4 = new JButton();
		super.genereteLinkButton(b1, "About us", 0.1);
		super.genereteLinkButton(b2, "Payment methods", 0.1);
		super.genereteLinkButton(b3, "Deliver rates & policy", 0.1);
		super.genereteLinkButton(b4, "Help", 0.1);

		JPanel panela = new JPanel();
		panela.add(b1);
		panela.add(b2);
		panela.add(b3);
		panela.add(b4);
		this.add(panela);

	}

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

	}

	@Override
	public void opAppEnd() {
		//popear estas seguro de salir		
	}

	@Override
	public void onUserLogOut() {
		//popear adios
		//desloguearte
	}

	@Override
	public void OnLoginRight(UserVO u) {
		login.setVisible(false);
		userInfo.setVisible(true);
		userInfo.setInfo(u);
		this.repaint();
	}

	@Override
	public void OnLoginFail(UserVO u) {
		//Popear dialog error
		System.out.println("Error");
	}

	@Override
	public void OnListAct(List<ItemVO> l) {
		this.list.act(l);
		this.list.repaint();
	}

}