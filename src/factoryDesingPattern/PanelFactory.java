package factoryDesingPattern;

import javax.swing.JComponent;
import javax.swing.JPanel;

import exceptions.InvalidArgumentException;

public class PanelFactory extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public JPanel getPanel(PanelType panelType){
	      switch(panelType){
	      case MAIN_PANEL:
	    	  return null;
	    	  //break;
	      case ITEM_PANEL:
	    	  return null;
	    	  //break;
	      default:
	    	  throw new InvalidArgumentException();
	      }
	      //return null;
	   }

}
