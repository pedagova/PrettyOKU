package controller;

import model.AppObserver;
import model.Model;
import dataAccessObjectDesingPattern.UserVO;



public class Controler {

	Model model;
	
	public void loginUser(String nick, String pass) {
		model.login(nick, pass);
	}

	public String getUser(String idOwner) {
		// TODO Auto-generated method stub
		return model.getUser(idOwner);
	}

	public void add(AppObserver o) {
		model.addObserver(o);
	}
	
	public Controler(){
		model = new Model();
	}
}
