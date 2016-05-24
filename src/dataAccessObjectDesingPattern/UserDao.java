package dataAccessObjectDesingPattern;

public class UserDao {

	public void add(UserVO user) {
				
	}

	public UserVO getUser(String nick) {
		return new UserVO(nick);
		//pedir a la base un usuario con un nick 		
	}

}
