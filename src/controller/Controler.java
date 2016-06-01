package controller;

import java.util.List;

import dataAccessObjectDesingPattern.ItemVO;
import dataAccessObjectDesingPattern.UserVO;
import model.AppObserver;
import model.Model;
import view.View;



public class Controler implements AppObserver{

	Model model;
	
	private boolean loggedOn;
	
	private View view;
	
	private UserVO loggedUser;
	
	public Controler(Model model, View view){
		loggedUser = null;
		this.loggedOn = false;
		this.model = model;
		this.view = view;
		this.model.addObserver(this);
	}
	
	public void loginUser(String nick, String pass) {
		this.loggedUser = new UserVO("permuta", "pedro", "gonzalez", "vazquez", "p@gmail.com", "2" );
		model.login(loggedUser);
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
		return false;
	}

	public void setLoggedOn(boolean loggedOn) {
		this.loggedOn = loggedOn;
	}

	public List<ItemVO> getList() {
		return this.model.getList();
	}
	
	public static void main(String[] args) {
		Controler ctrl = new Controler(new Model(), new View());
		ctrl.start();
	}

	private void start() {
		this.view.start(this);
		this.model.start();
	}

	public String loggedUser() {
		return this.loggedUser.getId();
	}

	public void newUserItem(ItemVO item, String price) {
		model.insertNewBid(item.getId(), loggedUser.getId(), price);		
	}

	public ItemVO getItem(String id) {
		return model.getItem(id);
	}

	@Override
	public void opAppEnd() {
		loggedOn = false;		
	}

	@Override
	public void opAppStart(List<ItemVO> actList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnUserLogOut() {
		loggedUser = null;
		loggedOn = false;
	}

	@Override
	public void OnLoginRight(UserVO u) {
		// TODO Auto-generated method stub
		loggedUser = u;
		loggedOn = true;
	}

	@Override
	public void OnLoginFail(UserVO u) {
		u = null;
		loggedOn = false;
	}

	@Override
	public void OnListAct(List<ItemVO> l) {
	}

	public void addItem(ItemVO it) {
		it.setIdOwner(loggedUser.getId());
		model.addItem(it);		
	}

	public void addUser(UserVO userVO) {
		model.addUser(userVO);
		
	}
}

