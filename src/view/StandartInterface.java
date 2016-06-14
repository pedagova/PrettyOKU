package view;

import javax.swing.JPanel;

import controller.Controler;

public interface StandartInterface {
	void changePanel(JPanel p);
	void start(Controler ctrl);
	void initGUI();
}
