package bean;

public class Item {
	private int itemId;
	private String name;
	private int producerId;
	private String producer;
	private int itemStatus;
	private String region;
	private int price;
	private String remark;
	private String image;

	public Item() {
		this.itemId = -1;
		this.name = null;
		this.producerId = -1;
		this.itemStatus = -1;
		this.region = null;
		this.price = -1;
		this.remark = null;
		this.image = null;
	}

	public int getItemId() {
		return itemId;
	}

	public String getName() {
		return name;
	}

	public int getProducerId() {
		return producerId;
	}

	public int getItemStatus() {
		return itemStatus;
	}
	
	public String getRegion() {
		return region;
	}

	public int getPrice() {
		return price;
	}

	public String getRemark() {
		return remark;
	}

	public String getProducer() {
		return producer;
	}
	
	public String getImage() {
		return image;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProducerId(int producerId) {
		this.producerId = producerId;
	}

	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

}
