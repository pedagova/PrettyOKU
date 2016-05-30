package dataAccessObjectDesingPattern;

import dataBaseConection.clientREST;

public class UserDao {
	
	private clientREST ddbb = new clientREST();
	
	public void add(UserVO user) {
		ddbb.connectionDDBB("POST", "registerUser", user.encodeUser());
	}

	public UserVO getUser(String nick, String passw) {
		return new UserVO(ddbb.connectionDDBB("POST", "loginUser", "nick=" + nick + "&password=" + passw));
	}

	public void insertNewBid(String idItem, String idUser, String price) {
		ddbb.connectionDDBB("POST", "insertBidUp", "idUser= " + idUser + "&idItem= " + idItem + "&price= " + price);
	}
	
	public static void main(String[] args){
		System.out.println(new UserDao().getUser("jeiker26", "12345678").encodeUser());
	}
}
