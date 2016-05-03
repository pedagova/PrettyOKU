package dataAccessObjectDesingPattern;

import java.util.List;

public interface ItemDao extends Dao{

	public List<Item> getAll();
	
	public void update();
	
	public void delete();
	
	public void add();
}
