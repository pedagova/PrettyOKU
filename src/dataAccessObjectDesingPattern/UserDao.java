package dataAccessObjectDesingPattern;

import dataBaseConection.clientREST;

public class UserDao {
	
	private clientREST ddbb = new clientREST();
	
	public void add(UserVO user) {
		ddbb.connectionDDBB("POST", "registerUser", user.encodeUser());
	}

	public UserVO getUser(String nick, String passw) {
		return new UserVO(ddbb.connectionDDBB("POST", "loginUser", "nick= " + nick + "password= " + passw));
		
	}

}
