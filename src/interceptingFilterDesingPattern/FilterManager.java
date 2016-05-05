package interceptingFilterDesingPattern;

import interceptingFilterDesingPattern.filters.*;
import exceptions.RegisterException;
public class FilterManager {
	FilterChain filterChain;

	public FilterManager(Target target) {
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}

	public void setFilter(Filter filter) {
		filterChain.addFilter(filter);
	}

	public void filterRequest(String[] chain) throws RegisterException {
		filterChain.execute(chain);

	}
}