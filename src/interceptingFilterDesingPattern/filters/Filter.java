package interceptingFilterDesingPattern.filters;

import exceptions.RegisterException;

public interface Filter {

	public void execute(String[] data) throws RegisterException;

}
