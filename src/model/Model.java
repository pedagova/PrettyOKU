package model;

import java.util.ArrayList;
import java.util.List;

import dataAccessObjectDesingPattern.ItemDao;
import dataAccessObjectDesingPattern.ItemVO;
import dataAccessObjectDesingPattern.UserDao;
import dataAccessObjectDesingPattern.UserVO;
import exceptions.ActPriceException;

public class Model{

	private List<AppObserver> observerList;
	private UserDao userConnection;
	private ItemDao itemConnection;
	private List<ItemVO> actList;
	// ----------- request ----------------------

	public void login(String nick, String pass) {
		UserVO u = userConnection.getUser(nick, pass);
		
		if(u.getName() == null)
			notifyLoginFail(u);
		else
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
		this.actList = itemConnection.getNItems(20);
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

	public void getN(int i) {
		actList = itemConnection.getNItems(i);
		notifyListAct(actList);
	}
	
	public void find(String text) {
		List<ItemVO> aux = itemConnection.getAllItems();
		actList = new ArrayList<ItemVO>();
		for(int i = 0; i < aux.size(); i++){
			if(aux.get(i).getName().toLowerCase().contains(text.toLowerCase())){
				actList.add(aux.get(i));
			}
		}
		notifyListAct(actList);
	}


	public void find(String text, String category) {
		List<ItemVO> aux = itemConnection.getAllItems(category);
		actList = new ArrayList<ItemVO>();
		for(int i = 0; i < aux.size(); i++){
			if(aux.get(i).getName().toLowerCase().contains(text.toLowerCase())){
				actList.add(aux.get(i));
			}
		}
		notifyListAct(actList);
	}

	public void actPrice(ItemVO item, int i, UserVO user) throws ActPriceException {
		if(Integer.parseInt(itemConnection.getItem(item.getId()).getPrice()) > i){
			throw new ActPriceException("el precio no puede ser menor que el anterior");
		}
		else{
			itemConnection.actPrice(item.getId(), user.getId(), i);
		}
	}
	
	public void getBidItems(String id){
		actList = userConnection.actualBidProduct(id);
		System.out.println(actList.size());
		notifyListAct(actList);
	}
	
	public void getBoughtProducts(String id){
		actList = userConnection.boughtProducts(id);
		notifyListAct(actList);
	}
	
	public void getSellProducts(String id){
		actList = userConnection.sellProducts(id);
		notifyListAct(actList);
	}

	public void loggOut() {
		notifyLogOut();		
	}

	private void notifyLogOut() {
		for (AppObserver o : observerList) {
			o.OnUserLogOut();
		}
	}
	
}
