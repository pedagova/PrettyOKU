package factoryDesingPattern;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;

import exceptions.InvalidArgumentException;
import factoryDesingPattern.panelList.AuxPanel;
import factoryDesingPattern.panelList.BidPanel;
import factoryDesingPattern.panelList.ForgotPassPanel;
import factoryDesingPattern.panelList.MainPanel;

public class PanelFactory extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanel getPanel(PanelType panelType, Dimension dimension) {
		switch (panelType) {
		case AUX_PANEL:
			return new AuxPanel(dimension);
		case BID_PANEL:
			return new BidPanel(dimension);
		case FORGOT_PASS_PANEL:
			return new ForgotPassPanel(dimension);
		case GENERAL_INFO_PANEL:
			return new MainPanel(dimension);
		case IMAGE_PANEL:
			return new MainPanel(dimension);
		case ITEM_INFO_PANEL:
			return new MainPanel(dimension);
		case ITEM_PANEL:
			return new MainPanel(dimension);
		case ITEM_REGISTER_PANEL:
			return new MainPanel(dimension);
		case LIST_PANEL:
			return new MainPanel(dimension);
		case LOGIN_PANEL:
			return new MainPanel(dimension);
		case MAIN_PANEL:
			return new MainPanel(dimension);
		case PRICE_PANEL:
			return new MainPanel(dimension);
		case TAG_PANEL:
			return new MainPanel(dimension);
		case USER_INFO_PANEL:
			return new MainPanel(dimension);
		case USER_PERSONAL_INFO:
			return new MainPanel(dimension);
		case USER_REGISTER_PANEL:
			return new MainPanel(dimension);
		default:
			throw new InvalidArgumentException();
		}
	}

}
