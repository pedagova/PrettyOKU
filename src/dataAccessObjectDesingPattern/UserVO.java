package dataAccessObjectDesingPattern;

public class UserVO {
	private String id;
	private String name;
	private String forename1, forename2;
	public UserVO(String name) {
		super();
		this.name = name;
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
	
	
	
}
