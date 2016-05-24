package dataAccessObjectDesingPattern;

public class UserVO {
	private String id;
	private String name;
	private String forename1, forename2;
	private String nick;
	private String pass;
	private String eMail;
	public UserVO(String name) {
		this.name = name;
		this.pass = "1234";
		this.forename1 = "g";
		this.forename2 = "v";
		this.nick = "perm";
		this.eMail = "@g";
		this.id = "1";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the forename1
	 */
	public String getForename1() {
		return forename1;
	}
	/**
	 * @param forename1 the forename1 to set
	 */
	public void setForename1(String forename1) {
		this.forename1 = forename1;
	}
	/**
	 * @return the forename2
	 */
	public String getForename2() {
		return forename2;
	}
	/**
	 * @param forename2 the forename2 to set
	 */
	public void setForename2(String forename2) {
		this.forename2 = forename2;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEMail() {
		// TODO Auto-generated method stub
		return this.eMail;
	}
	
	
	
}
