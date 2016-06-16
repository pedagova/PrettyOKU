package dataAccessObjectDesingPattern;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ch.randelshofer.quaqua.ext.base64.Base64;
import dataBaseConection.clientREST;
import view.ViewUtilities;

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

	public List<ItemVO> getAllItems() {
		List<ItemVO> l = new ArrayList<ItemVO>();
		JSONObject o = ddbb.connectionDDBB("GET", "getAllProducts", null);
		try {
			JSONArray a = o.getJSONArray("result");
			for(int i = 0; i < a.length(); i++){
				l.add(new ItemVO(a.getJSONObject(i)));
			}
		} catch (JSONException e) {
			return l;
		}
		
		return l;
	}
	
	public List<ItemVO> getAllItems(String id_category) {
		List<ItemVO> l = new ArrayList<ItemVO>();
		JSONObject o = ddbb.connectionDDBB("POST", "getCategoriesProducts", "id_category= " + id_category);
		try {
			JSONArray a = o.getJSONArray("result");
			for(int i = 0; i < a.length(); i++){
				l.add(new ItemVO(a.getJSONObject(i)));
			}
		} catch (JSONException e) {
			return l;
		}
		
		return l;
	}

	public List<ItemVO> getNItems(int n) {
		List<ItemVO> l = new ArrayList<ItemVO>();
		JSONObject o = ddbb.connectionDDBB("POST", "randomLyst", "number= " + n);
		try {
			JSONArray a = o.getJSONArray("result");
			for(int i = 0; i < a.length(); i++){
				l.add(new ItemVO(a.getJSONObject(i)));
			}
		} catch (JSONException e) {
			
		}
		
		return l;
	}
	
	public void deleteAll(){
		List<ItemVO> l = new ArrayList<ItemVO>();
		JSONObject o = ddbb.connectionDDBB("GET", "getAllProducts", null);
		try {
			JSONArray a = o.getJSONArray("result");
			for(int i = 0; i < a.length(); i++){
				l.add(new ItemVO(a.getJSONObject(i)));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		for(ItemVO it: l){
			this.delete(it);
		}
	}
	
	/*public static void main(String[] args){
		System.out.println(new ItemDao().getItem("29").encodeItem());
	}*/

	public void actPrice(String id, String id2, int i) {
		ddbb.connectionDDBB("POST", "insertBidUp", "id_user= " + id2 + "&id_product= " + id + "&price= " + i);		
	}
	
	
}
