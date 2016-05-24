package factoryDesingPattern;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;

import controller.Controler;
import exceptions.InvalidArgumentException;
import factoryDesingPattern.panelList.AuxPanel;
import factoryDesingPattern.panelList.BidPanel;
import factoryDesingPattern.panelList.ForgotPassPanel;
import factoryDesingPattern.panelList.GeneralInfoPanel;
import factoryDesingPattern.panelList.ImagePanel;
import factoryDesingPattern.panelList.ItemInfoPanel;
import factoryDesingPattern.panelList.ItemPanel;
import factoryDesingPattern.panelList.ItemRegisterPanel;
import factoryDesingPattern.panelList.ListPanel;
import factoryDesingPattern.panelList.LoginPanel;
import factoryDesingPattern.panelList.MainPanel;
import factoryDesingPattern.panelList.TagPanel;
import factoryDesingPattern.panelList.UserInfoPanel;
import factoryDesingPattern.panelList.UserRegisterPanel;

public class PanelFactory extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanel getPanel(PanelType panelType, Dimension dimension, Controler ctrl) {
		switch (panelType) {
		case AUX_PANEL:
			return new AuxPanel(dimension,ctrl);
		case BID_PANEL:
			return new BidPanel(dimension,ctrl);
		case FORGOT_PASS_PANEL:
			return new ForgotPassPanel(dimension,ctrl);
		case GENERAL_INFO_PANEL:
			return new GeneralInfoPanel(dimension,ctrl);
		case IMAGE_PANEL:
			return new ImagePanel(dimension,ctrl);
		case ITEM_INFO_PANEL:
			return new ItemInfoPanel(dimension,ctrl);
		case ITEM_PANEL:
			return new ItemPanel(dimension,ctrl);
		case ITEM_REGISTER_PANEL:
			return new ItemRegisterPanel(dimension,ctrl);
		case LIST_PANEL:
			return new ListPanel(dimension,ctrl);
		case LOGIN_PANEL:
			return new LoginPanel(dimension,ctrl);
		case MAIN_PANEL:
			return new MainPanel(dimension,ctrl);
		case TAG_PANEL:
			return new TagPanel(dimension,ctrl);
		case USER_INFO_PANEL:
			return new UserInfoPanel(dimension,ctrl);
		case USER_REGISTER_PANEL:
			return new UserRegisterPanel(ctrl);
		default:
			throw new InvalidArgumentException();
		}
	}

}
