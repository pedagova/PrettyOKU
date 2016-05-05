package exceptions;

public class RegisterException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String data;
	
	public RegisterException(String data) {
		this.data = data;
	}


	public String toString(){
		return this.data;
	}
}
