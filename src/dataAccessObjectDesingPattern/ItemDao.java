package dataAccessObjectDesingPattern;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

	public List<ItemVO> getAllItems(String id_category) {
		List<ItemVO> l = new ArrayList<ItemVO>();
		JSONObject o = ddbb.connectionDDBB("POST", "getCategoriesProducts", "id_category= " + id_category);
		System.out.println(o.toString());
		try {
			JSONArray a = o.getJSONArray("result");
			for(int i = 0; i < a.length(); i++){
				l.add(new ItemVO(a.getJSONObject(i)));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
}
