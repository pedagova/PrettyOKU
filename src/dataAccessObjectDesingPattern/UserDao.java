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
	
	public void registerUser(String name,String email,String nick,String password,String last_name_1,String last_name_2,String address){
		ddbb.connectionDDBB("POST", "registerUser", "name= " + name + "&email= " + email + "&nick= " + nick + "&password= " + password + "&last_name_1= " + last_name_1 + "&last_name_2" + last_name_2 + "&address= " + address);
	}
	
	public static void main(String[] args){
		System.out.println(new UserDao().getUser("jeiker26", "12345678").encodeUser());
	}
}
