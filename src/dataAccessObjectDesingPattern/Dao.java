package dataAccessObjectDesingPattern;

import java.util.List;

public interface Dao {
	
	public List<Item> getAll();
	
	public void update();
	
	public void delete();
	
	public void add();
}
