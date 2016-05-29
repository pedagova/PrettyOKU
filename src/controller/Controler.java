package controller;

import java.util.List;

import dataAccessObjectDesingPattern.ItemVO;
import model.AppObserver;
import model.Model;
import view.View;



public class Controler {

	Model model;
	
	private boolean loggedOn;
	
	private View view;
	
	public Controler(Model model, View view){
		this.loggedOn = false;
		this.model = model;
		this.view = view;
	}
	
	public void loginUser(String nick, String pass) {
		model.login(nick, pass);
	}

	public String getUser(String idOwner) {
		return model.getUser(idOwner);
	}

	public void add(AppObserver o) {
		model.addObserver(o);
	}
	
	public Controler(){
		model = new Model();
	}

	public void getAll(String string) {
		model.getAll(string);
		
	}

	public boolean isLoggedOn() {
		return loggedOn;
	}

	public void setLoggedOn(boolean loggedOn) {
		this.loggedOn = loggedOn;
	}

	public List<ItemVO> getList() {
		return this.model.getList();
	}
	
	public static void main(String[] args) {
		System.out.println("controller");
		Controler ctrl = new Controler(new Model(), new View());
		ctrl.start();
	}

	private void start() {
		this.view.start(this);
		this.model.start();
	}
}
