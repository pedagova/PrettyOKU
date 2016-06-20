package controller;

import java.util.List;

import dataAccessObjectDesingPattern.ItemVO;
import dataAccessObjectDesingPattern.UserVO;
import exceptions.ActPriceException;
import exceptions.FinishedException;
import exceptions.NotLoggedException;
import model.AppObserver;
import model.Model;
import model.Tags;
import view.StandartInterface;
import view.View2;
import view.Panels.ShowProduct;



public class Controler implements AppObserver{

	Model model;
	
	private StandartInterface view;
	
	private UserVO loggedUser;
	
	private Tags category;	
	
	public Controler(Model model, StandartInterface view){
		category = null;
		loggedUser = null;
		this.model = model;
		this.view = view;
this.model.addObserver(this);
	}
	
	public void loginUser(String nick, char[] cs) {
		String s = "";
		for(char st : cs){
			s+= st;
		}
		model.login(nick, s);
	}

	public String getUser(String idOwner) {
		return model.getUser(idOwner);
	}

	public void add(AppObserver o) {
		model.addObserver(o);
	}

	public void getAll(String string) {
		model.getAll(string);
		
	}

	public boolean isLoggedOn() {
		return true;
	}

	public List<ItemVO> getList() {
		return this.model.getList();
	}
	
	public static void main(String[] args) {
		Controler ctrl = new Controler(new Model(), new View2());
		ctrl.start();
	}

	public void start() {
		view.start(this);
		model.start();
	}

	public String loggedUser() {
		return loggedUser.getId();
	}

	public void newUserItem(ItemVO item, String price) {
		model.insertNewBid(item.getId(), loggedUser.getId(), price);		
	}

	public ItemVO getItem(String id) {
		return model.getItem(id);
	}

	@Override
	public void opAppEnd() {
		loggedUser = null;
	}

	@Override
	public void opAppStart(List<ItemVO> actList) {
		// TODO Auto-generated method stub
	}

	@Override
	public void OnUserLogOut() {
		loggedUser = null;
		
	}

	@Override
	public void OnLoginRight(UserVO u) {
		loggedUser = u;
	}

	@Override
	public void OnLoginFail(UserVO u) {
		loggedUser = null;
	}

	@Override
	public void OnListAct(List<ItemVO> l) {
		
	}

	public void addItem(ItemVO it) throws NotLoggedException {
		if(loggedUser != null){
			it.setIdOwner(loggedUser.getId());
		}
		else{
			throw new NotLoggedException("You must be logged to add an Item");
		}
		model.addItem(it);		
	}

	public void addUser(UserVO userVO) {
		model.addUser(userVO);
		
	}

	public void getN(int i) {
		model.getN(i);		
	}

	public void find(String text) {
		if(category == null){
			model.find(text);
		}
		else{
			model.find(text, "1");
		}
	}

	public void itemChose(ShowProduct showProduct) {
		view.changePanel(showProduct);	
		view.initGUI();
	}

	public void actPrice(ItemVO item, int i) throws NotLoggedException, ActPriceException, FinishedException {
		if(loggedUser != null)
			model.actPrice(item, i,loggedUser);
		else{
			throw new NotLoggedException("You must to be logged to bid on a product");
		}
	}

	public void getBidItems(){
		model.getBidItems(loggedUser.getId());
	}
	
	public void getBoughtProducts(){
		model.getBoughtProducts(loggedUser.getId());
	}
	
	public void getSellProducts(){
		model.getSellProducts(loggedUser.getId());
	}
	
	public Tags getCategory() {
		return this.category;
	}
	
	public UserVO getLoggedUser(){
		return loggedUser;
	}

	public void setCategory(Tags c) {
		category = c;
		
	}

	public void loggOut() {
		model.loggOut();		
	}
	
}

