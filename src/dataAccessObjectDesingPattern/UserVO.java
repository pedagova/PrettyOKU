package dataAccessObjectDesingPattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserVO {
	private String id;
	private String name;
	private String forename1, forename2;
	private String nick;
	private String pass;
	private String eMail;
	private String id_owner;
	
	public UserVO(String name) {
		this.name = name;
		this.pass = "1234";
		this.forename1 = "g";
		this.forename2 = "v";
		this.nick = "perm";
		this.eMail = "@g";
	}
	public UserVO(JSONObject ob) {
		try {
			this.name = ob.getString("name");
			this.id = ob.getString("id");
			this.forename1 = ob.getString("forename1");
			this.forename2 = ob.getString("forename2");
			this.nick = ob.getString("key");
			this.pass = ob.getString("pass");
			this.eMail = ob.getString("email");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public UserVO(JSONArray ar){
		try {
			JSONObject ob = ar.getJSONObject(0);
			
			this.name = ob.getString("name");
			this.id = ob.getString("id");
			this.forename1 = ob.getString("forename1");
			this.forename2 = ob.getString("forename2");
			this.nick = ob.getString("key");
			this.pass = ob.getString("pass");
			this.eMail = ob.getString("email");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String encodeUser() {
		return "id= " + id + "name= " + name + "forename1= " + forename1 + "forename2= " + forename2 + 
				"nick= " + nick + "pass= " + pass + "email= " + eMail;
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
