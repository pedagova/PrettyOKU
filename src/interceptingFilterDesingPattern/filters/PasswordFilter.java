package interceptingFilterDesingPattern.filters;

import exceptions.RegisterException;

public class PasswordFilter implements Filter{

	@Override
	public void execute(String[] request) throws RegisterException {
		// comparamos request[2] con request[3]; si son iguales y cumplen codiciones ok, sino throw
		if(!request[2].equals(request[3])){
			throw new RegisterException("Error: the password does not match");
		}
	}

}
