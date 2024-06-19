package bean;

public class Item {
	private int itemId;
	private String name;
	private int producerId;
	private int itemStatus;
	private int price;
	private String remark;
	
	public Item() {
		this.itemId = -1;
		this.name = null;
		this.producerId = -1;
		this.itemStatus = -1;
		this.price = -1;
		this.remark = null;
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

	public int getPrice() {
		return price;
	}

	public String getRemark() {
		return remark;
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

	public void setPrice(int price) {
		this.price = price;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
