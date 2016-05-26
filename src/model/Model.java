package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.ActionMapUIResource;

import dataAccessObjectDesingPattern.ItemDao;
import dataAccessObjectDesingPattern.ItemVO;
import dataAccessObjectDesingPattern.UserDao;
import dataAccessObjectDesingPattern.UserVO;

public class Model extends Observer{
	
	private List<AppObserver> observerList;
	private UserDao userConnection;
	private ItemDao itemConnection;
	private List<ItemVO> actList;
	//----------- request ----------------------
	
	public void login(String nick, String pass) {
		//paso filtro
		//execut
		
		UserVO u = userConnection.getUser(nick);
		System.out.println(pass + " " + u.getPass() + " 1");
		if(!pass.equals(u.getPass())) notifyLoginFail(u);
		else notifyLoginRight(u);
	}
	
	public void addObserver(AppObserver o) {
		observerList.add(o);
	}
	
	public void search(String category) {
		List<ItemVO> l = itemConnection.getAllItems(category);
		notifyListAct(l);
	}
	
	
	//------------ notify ------------------------
	private void notifyListAct(List<ItemVO> l) {
		for(AppObserver o: observerList){
			o.OnListAct(l);
		}
	}

	private void notifyLoginRight(UserVO u) {
		for(AppObserver o: observerList){
			o.OnLoginRight(u);
		}
	}

	private void notifyLoginFail(UserVO u) {
		for(AppObserver o: observerList){
			o.OnLoginFail(u);
		}
	}
	
	public Model(){
		this.observerList = new ArrayList<AppObserver>();
		this.itemConnection = new ItemDao();
		this.userConnection = new UserDao();
	}

	public String getUser(String idOwner) {
		
		return userConnection.getUser(idOwner).getId();
	}

	public void getAll(String string) {
		actList = itemConnection.getAllItems(string);
		notifyListAct(actList);
	}
	
}
