package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import factoryDesingPattern.BasicPanel;
import utils.Utils;

public class MainPanel extends BasicPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginPanel login;

	private TagPanel aux;

	private ListPanel list;

	private double widthValue;

	private double heigthValue;

	public MainPanel(Dimension dimension) {
		this.widthValue = dimension.getWidth();
		this.heigthValue = dimension.getHeight();
		// this.setLayout(new GridBagLayout());
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(dimension);
		// this.setBorder(new TitledBorder(new EtchedBorder(), "USER LOGIN", 1,
		// 1, new Font("", 9, 28)));
		this.initComponets();
		this.initGUI();

	}

	public void initComponets() {
		this.login = new LoginPanel(new Dimension(400, 100));
		this.aux = new TagPanel(Utils.newDim(widthValue, heigthValue, 0.5, 0.4));
		this.list = new ListPanel(Utils.newDim(widthValue, heigthValue, 0.5, 0.8));

	}

	public void initGUI() {
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
		// dimension = Utils.reSize(0.7, 0.7);
		MainPanel main = new MainPanel(dimension);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setPreferredSize(dimension);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		// frame.pack();
		frame.add(main);

	}

}