package main;

import model.Model;
import view.View2;
import controller.Controler;

public class Main {
	public static void main(String[] args){
		Controler ctrl = new Controler(new Model(), new View2());
		ctrl.start();
	}
}
