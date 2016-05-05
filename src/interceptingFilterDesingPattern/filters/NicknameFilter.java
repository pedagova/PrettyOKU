package interceptingFilterDesingPattern.filters;

import exceptions.RegisterException;

public class NicknameFilter implements Filter{

	@Override
	public void execute(String[] request) throws RegisterException {
		// buscamos request[0] en la base de datos; si esta throw, sino ok
		if(request[0].equals("")){
			throw new RegisterException("Error: the user field is empty");
		}
	}

}
