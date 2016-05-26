package dataAccessObjectDesingPattern;

public class UserDao {

	public void add(UserVO user) {
				
	}

	public UserVO getUser(String nick) {
		System.out.println("getUser");
		return new UserVO(nick);
		//pedir a la base un usuario con un nick 		
	}

}
