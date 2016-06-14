package main;

import controller.Controler;
import model.Model;
import view.View2;

public class Main {
	public static void main(String[] args){
		Controler ctrl = new Controler(new Model(), new View2());
		ctrl.start();
	}
}
