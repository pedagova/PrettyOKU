package dataAccessObjectDesingPattern;

public class Item {
	private String name;

	private String description;

	private String image;

	private float price;

	private String id;

	private String idOwner;

	private String lastBidder;

	public Item(String name, String description, String image, float price, String id, String idOwner,
			String lastBidder) {
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.id = id;
		this.idOwner = idOwner;
		this.lastBidder = lastBidder;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param idOwner
	 *            the idOwner to set
	 */
	public void setIdOwner(String idOwner) {
		this.idOwner = idOwner;
	}

	/**
	 * @return the lastBidder
	 */
	public String getLastBidder() {
		return lastBidder;
	}

	/**
	 * @param lastBidder
	 *            the lastBidder to set
	 */
	public void setLastBidder(String lastBidder) {
		this.lastBidder = lastBidder;
	}
}
