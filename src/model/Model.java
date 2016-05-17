package model;

import java.util.List;

import dataAccessObjectDesingPattern.ItemDao;
import dataAccessObjectDesingPattern.UserDao;
import dataAccessObjectDesingPattern.UserVO;

public class Model extends Observer{
	
	private List<AppObserver> observerList;
	private UserDao userConnection;
	private ItemDao itemConnection;
	
	//----------- request ----------------------
	public void updateBaseUsser(UserVO user) {
		new UserDao().add(user);
		notifyUpdateBase(user);
	}
	
	public void login(String nick, String pass) {
		UserVO user = new UserDao().getUser(nick);
		if(pass != user.getPass()) notifyLoginFail();
		else loginRight();
	}
	
	//------------ notify ------------------------
	private void notifyUpdateBase(UserVO user){
		for(AppObserver o: observerList){
			o.OnUserBaseUpdate(user);
		}
	}

	private void loginRight() {
		for(AppObserver o: observerList){
			o.OnLoginFail();
		}
	}

	private void notifyLoginFail() {
		for(AppObserver o: observerList){
			o.OnLoginRight();
		}
	}

}
