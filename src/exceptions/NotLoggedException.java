package exceptions;

import java.io.IOException;

public class NotLoggedException extends IOException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotLoggedException(String text) {
		super(text);
	}
}
