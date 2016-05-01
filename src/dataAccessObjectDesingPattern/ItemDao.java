package dataAccessObjectDesingPattern;

import java.util.List;

public interface ItemDao {

	public List<Item> getAllItem();
	
	public void updateItem();
	
	public void deleteItem();
	
	public void addItem();
}
