package factoryDesingPattern.panelList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

	private JPanel auxLeft;

	private JPanel auxTop;

	public MainPanel(Dimension dimension, Controler ctrl) {
		this.widthValue = dimension.getWidth();
		this.heigthValue = dimension.getHeight();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(dimension);

		this.ctrl = new Controler();
		this.initComponets();
		this.initGUI();
		this.ctrl.add(this);

	}

	public void initComponets() {
		this.login = new LoginPanel(new Dimension(400, 100), ctrl);
		this.userInfo = new UserInfoPanel(Utils.newDim(widthValue, heigthValue, 0.5, 0.5), ctrl);
		this.aux = new TagPanel(Utils.newDim(widthValue, heigthValue, 0.5, 0.4), ctrl);
		this.list = new ListPanel(Utils.newDim(widthValue, heigthValue, 0.5, 0.9), ctrl);

	}

	public void initGUI() {
		this.userInfo.setVisible(false);
		auxLeft = new JPanel();
		auxLeft.setLayout(new BoxLayout(auxLeft, BoxLayout.Y_AXIS));
		// auxLeft.setPreferredSize(new Dimension(100, 200));
		auxLeft.add(login);
		auxLeft.add(aux);

		auxTop = new JPanel();

		auxTop.setLayout(new BoxLayout(auxTop, BoxLayout.X_AXIS));
		auxTop.add(auxLeft);
		auxTop.add(list);

		this.add(auxTop);

		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		JButton b4 = new JButton();
		super.genereteBottonBarButton(b1, "About us", 0.1, 0);
		super.genereteBottonBarButton(b2, "Payment methods", 0.1, 1);
		super.genereteBottonBarButton(b3, "Deliver rates & policy", 0.1, 1);
		super.genereteBottonBarButton(b4, "Help", 0.1, 1);

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

	}

	@Override
	public void onUserLogOut() {
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
		this.auxLeft.add(aux);

		this.auxTop.removeAll();
		this.auxTop.validate();
		this.auxTop.setLayout(new BoxLayout(auxTop, BoxLayout.X_AXIS));
		this.auxTop.add(this.auxLeft);
		this.auxTop.add(this.list);

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

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog();
				dialog.setSize(new Dimension(500, 700));
				JPanel panel = new JPanel();
				panel.setPreferredSize(new Dimension(500, 500));
				panel.setBackground(Color.RED);
				dialog.add(panel);
				dialog.setModal(true);
				dialog.setVisible(true);
				dialog.pack();
				dialog.setLocationRelativeTo(MainPanel.this);
			}
		});

		panela.add(b1);
		panela.add(b2);
		panela.add(b3);
		panela.add(b4);
		this.add(panela);

		login.setVisible(false);
		userInfo.setVisible(true);
		userInfo.setInfo(u);
		this.repaint();
	}

	@Override
	public void OnLoginFail(UserVO u) {
		// Popear dialog error
		System.out.println("Error");
	}

	@Override
	public void OnListAct(List<ItemVO> l) {
		this.list.act(l, Utils.newDim(widthValue, heigthValue, 0.5, 0.9));
		this.list.repaint();
		this.list.setVisible(true);
	}

}