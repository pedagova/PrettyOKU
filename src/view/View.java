package view;

import java.awt.Toolkit;

import controller.Controler;
import factoryDesingPattern.panelList.MainPanel;

public class View {

	public static void main(String[] args) {
		MainPanel panel = new MainPanel(Toolkit.getDefaultToolkit().getScreenSize(), new Controler());

	}
}
