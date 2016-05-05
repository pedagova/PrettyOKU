package interceptingFilterDesingPattern.filters;

import exceptions.RegisterException;

public class EmailFilter implements Filter{

	@Override
	public void execute(String[] request) throws RegisterException {
		// buscamos request[1] en la base de datos; si esta throw, sino ok
		if(request[1].equals("")){
			throw new RegisterException("Error: the e-mail field is not correct");
		}
	}

}
