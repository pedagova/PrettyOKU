package model;

import java.util.ArrayList;
import java.util.List;

import dataAccessObjectDesingPattern.ItemDao;
import dataAccessObjectDesingPattern.ItemVO;
import dataAccessObjectDesingPattern.UserDao;
import dataAccessObjectDesingPattern.UserVO;

public class Model extends Observer {

	private List<AppObserver> observerList;
	private UserDao userConnection;
	private ItemDao itemConnection;
	private List<ItemVO> actList;
	// ----------- request ----------------------

	public void login(/*String nick, String pass*/ UserVO u) {
		//UserVO u = userConnection.getUser(nick, pass);
		
		/*if(u.getName() == null)
			notifyLoginFail(u);
		else*/
			notifyLoginRight(u);
	}

	public void addObserver(AppObserver o) {
		observerList.add(o);
	}

	public void search(String category) {
		List<ItemVO> l = itemConnection.getAllItems(category);
		notifyListAct(l);
	}

	// ------------ notify ------------------------
	private void notifyListAct(List<ItemVO> l) {
		for (AppObserver o : observerList) {
			o.OnListAct(l);
		}
	}

	private void notifyLoginRight(UserVO u) {
		for (AppObserver o : observerList) {
			o.OnLoginRight(u);
		}
	}

	private void notifyLoginFail(UserVO u) {
		for (AppObserver o : observerList) {
			o.OnLoginFail(u);
		}
	}

	public Model() {
		this.observerList = new ArrayList<AppObserver>();
		this.itemConnection = new ItemDao();
		this.userConnection = new UserDao();
	}

	public String getUser(String idOwner) {

		return userConnection.getUser(idOwner, null).getId();
	}

	public void getAll(String string) {
		actList = itemConnection.getAllItems(string);
		notifyListAct(actList);
	}

	public void start() {
		this.actList = itemConnection.getNItems(1);
		for(AppObserver o : this.observerList){
			o.opAppStart(this.actList);
		}
	}

	public List<ItemVO> getList() {
		return this.actList;
	}

	public void insertNewBid(String idItem, String idUser,String price) {
		userConnection.insertNewBid(idItem, idUser, price);		
	}

	public ItemVO getItem(String id) {
		return itemConnection.getItem(id);
	}

	public void addItem(ItemVO it) {
		itemConnection.add(it);
		
	}

	public void addUser(UserVO userVO) {
		userConnection.add(userVO);
	}

}
