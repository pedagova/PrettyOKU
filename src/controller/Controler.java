package controller;

import model.Model;
import dataAccessObjectDesingPattern.UserVO;



public class Controler {

	Model model;
	
	public void updateBaseUsser(UserVO user){
		model.updateBaseUsser(user);
	}

	public void loginUser(String nick, String pass) {
		model.login(nick, pass);
	}
}
