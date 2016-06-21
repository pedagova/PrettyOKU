package view;

import javax.swing.JPanel;

import controller.Controler;
import model.AppObserver;

public interface StandartInterface{
	void changePanel(JPanel p);
	void start(Controler ctrl);
	void initGUI();
}
