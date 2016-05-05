package interceptingFilterDesingPattern;

import java.util.ArrayList;

import interceptingFilterDesingPattern.filters.Filter;
import exceptions.RegisterException;
public class FilterChain {
	private ArrayList<Filter> filters = new ArrayList<Filter>();
	private Target target;

	public void addFilter(Filter filter) {
		filters.add(filter);
	}

	public void execute(String[] data) throws RegisterException {
		for (Filter filter : filters) {
			filter.execute(data);
			
		}
		target.execute(data);
	}

	public void setTarget(Target target) {
		this.target = target;
	}
}
