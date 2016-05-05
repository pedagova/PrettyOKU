package interceptingFilterDesingPattern.filters;

import exceptions.RegisterException;

public class DescriptionFilter implements Filter{

	@Override
	public void execute(String[] request) throws RegisterException {
		// miramos si request[4] cumple condiciones; si no throw, en otro caso ok
		if(request[4].length()>=20){
			throw new RegisterException("Error: the description is too long");
		}
	}

}
