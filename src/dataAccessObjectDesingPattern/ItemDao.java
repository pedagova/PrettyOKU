package dataAccessObjectDesingPattern;

import java.util.List;

import org.json.JSONException;

import dataBaseConection.clientREST;

public class ItemDao {
	
	private clientREST ddbb = new clientREST();
	
	public ItemVO getItem(String id){
		
		try {
			return new ItemVO(ddbb.connectionDDBB("POST", "getProduct", "id= " + id).getJSONArray("result"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(ItemVO it){
		ddbb.connectionDDBB("POST", "updateProduct", it.encodeItem());
	}
	
	public void delete(ItemVO it){
		ddbb.connectionDDBB("POST", "deleteProduct", it.encodeItem());
	}
	
	public void add(ItemVO it){
		ddbb.connectionDDBB("POST", "insertProduct", it.encodeItem());
	}

	public List<ItemVO> getAllItems(String category) {
		// TODO Auto-generated method stub
		return null;
	}
}
