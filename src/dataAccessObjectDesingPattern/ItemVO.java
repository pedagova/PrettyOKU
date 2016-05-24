package dataAccessObjectDesingPattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dataBaseConection.clientREST;

public class ItemVO {

	private String id;
	private String idOwner;
	private String desc;
	private String img;
	private String idCategory;
	private String name;
	//-------------------------------------------
	private String user;
	private String price;
	
	
	public ItemVO(JSONArray jsonArray) {
		try {
			JSONObject ob  = jsonArray.getJSONObject(0);
			this.id = ob.getString("id");
			this.idOwner = ob.getString("id_owner");
			this.idCategory = ob.getString("id_category");
			this.desc = ob.getString("description");
			this.img = ob.getString("img");
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
	}
	public ItemVO(String desc, String user, String price){
		this.desc = desc;
		this.user = user;
		this.price = price;
		this.idOwner = "1";
		this.id = "";
		this.img = "test Image Iphone";
		this.idCategory = "3";
	}
	//create a parse to pack the info from the current Item
	public String encodeItem(){
		return "id= " + id + "&description= " + desc + "&id_category= " + idCategory + "&id_owner= " + idOwner + "&img= " + img;
	}
	public static void main(String args[]){
		
		try {
			System.out.println(new clientREST().connectionDDBB("POST", "insertProduct", new ItemVO(new clientREST().connectionDDBB("POST", "getProduct", "id= 9").getJSONArray("result")).encodeItem()));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the idOwner
	 */
	public String getIdOwner() {
		return idOwner;
	}
	/**
	 * @param idOwner the idOwner to set
	 */
	public void setIdOwner(String idOwner) {
		this.idOwner = idOwner;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @return the idCategory
	 */
	public String getIdCategory() {
		return idCategory;
	}
	/**
	 * @param idCategory the idCategory to set
	 */
	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	
	public String getIdLastBidder() {
		// TODO Auto-generated method stub
		return null;
	}

}
