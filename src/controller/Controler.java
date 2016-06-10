package controller;

import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dataAccessObjectDesingPattern.ItemVO;
import dataAccessObjectDesingPattern.UserVO;
import exceptions.ActPriceException;
import exceptions.NotLoggedException;
import model.AppObserver;
import model.Model;
import view.View;
import view.View2;
import view.Panels.ItemRepr;
import view.Panels.MainSwing;
import view.Panels.ShowProduct;



public class Controler implements AppObserver{

	Model model;
	
	private MainSwing view;
	
	private UserVO loggedUser;
	
	private String category;	
	
	public Controler(Model model){
		loggedUser = null;
		this.model = model;
		this.view = new MainSwing(this);
		this.model.addObserver(this);
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
		return false;
	}

	public List<ItemVO> getList() {
		return this.model.getList();
	}
	
	public static void main(String[] args) {
		Controler ctrl = new Controler(new Model());
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
		// TODO Auto-generated method stub
		loggedUser = u;
	}

	@Override
	public void OnLoginFail(UserVO u) {
		u = null;
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

	public void getN(int i) {
		model.getN(i);		
	}

	public void find(String text) {
		if(category == null){
			model.find(text);
		}
		else{
			model.find(text, category);
		}
	}

	public void itemChose(ShowProduct showProduct) {
		view.setPanel(showProduct);		
	}

	public void actPrice(ItemVO item, int i) throws NotLoggedException, ActPriceException {
		// TODO Auto-generated method stub
		if(loggedUser != null)
			model.actPrice(item, i,loggedUser);
		else{
			throw new NotLoggedException("Necesitas estar logeado para poder pujar por un item");
		}
	}
}

