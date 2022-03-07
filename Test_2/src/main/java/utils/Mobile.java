package utils;

public class Mobile {
	private int id;
	private String name;
	private float price;
	private boolean status;
	private String warranty; 
	private String accessory; 
	private String image;
	
	public Mobile() {
		super();
	}

	public Mobile(int id, String name, float price,  boolean status, String warranty, String accessory, String image) {
		super();
		this.id = id;
		this.name = name;
 		this.price = price;
 		this.status = status;
		this.warranty = warranty;
		this.accessory = accessory;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public String getAccessory() {
		return accessory;
	}

	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
