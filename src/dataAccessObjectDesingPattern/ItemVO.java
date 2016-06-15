package dataAccessObjectDesingPattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ItemVO {

	private String id;
	private String idOwner;
	private String desc;
	private String img;
	private String idCategory;
	private String name;
	//-------------------------------------------
	private String price;
	private String date_creation;
	private String idLastBid;
	public String getIdLastBid() {
		return idLastBid;
	}
	public void setIdLastBid(String idLastBid) {
		this.idLastBid = idLastBid;
	}

	private String duration_bid;
	
	
	public ItemVO(JSONArray jsonArray) {
		try {
			JSONObject ob  = jsonArray.getJSONObject(0);
			this.id = ob.getString("id");
			this.idOwner = ob.getString("id_owner");
			this.idCategory = ob.getString("id_category");
			this.desc = ob.getString("description");
			this.img = ob.getString("img");
			//this.img = "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";
			this.name = ob.getString("name");
			this.price = ob.getString("price");
			this.date_creation = ob.getString("date_creation");
			this.idLastBid = ob.getString("idLastBid");
			this.duration_bid = ob.getString("duration_bid");
		} catch (JSONException e) {
		
		}
		
	}
	public ItemVO(JSONObject obs) {
		try {
			this.id = obs.getString("id");
			this.idOwner = obs.getString("id_owner");
			this.idCategory = obs.getString("id_category");
			this.desc = obs.getString("description");
			this.img = obs.getString("img");
			//this.img = "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";
			this.name = obs.getString("name");
			this.price = obs.getString("price");
			this.date_creation = obs.getString("date_creation");
			this.idLastBid = obs.getString("idLastBid");
			this.duration_bid = obs.getString("duration_bid");
		} catch (JSONException e) {
		
		}
		
	}
	public ItemVO(String name, String desc, String price, String image){
		this.desc = desc;
		this.name = name;
		this.price = price;
		this.img = image;
		this.idCategory = "1";
		this.date_creation= "00-00-00";
	}
	//create a parse to pack the info from the current Item
	public String encodeItem(){
		return "id= " + id + "&name= " + name + "&description= " + desc + "&date_creation= " + date_creation +
				"&id_category= " + idCategory + "&id_owner= " + idOwner + "&img= " + img + 
				"&price= " + price + "&idLastBid= " + idLastBid +"&duration_bid= " + duration_bid;
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
	
	public void setPrice(String price){
		this.price = price;
	}

}
