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
import view.StandartInterface;
import view.View;
import view.View2;
import view.Panels.ItemRepr;
import view.Panels.MainSwing;
import view.Panels.ShowProduct;



public class Controler implements AppObserver{

	Model model;
	
	private StandartInterface view;
	
	private UserVO loggedUser;
	
	private String category;	
	
	public Controler(Model model, StandartInterface view){
		loggedUser = null;
		this.model = model;
		this.view = view;
		this.model.addObserver(this);
		//view.start(this);
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
		return false;
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
		// TODO Auto-generated method stub
		loggedUser = u;
	}

	@Override
	public void OnLoginFail(UserVO u) {
		loggedUser = null;
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
		view.changePanel(showProduct);	
		view.initGUI();
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

