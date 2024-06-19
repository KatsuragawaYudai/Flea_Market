package bean;

public class Trade {
	private int tradeId;
	private int producerId;
	private String producer; // formatted output only
	private int customerId;
	private String customer; // formatted output only
	private int itemId;
	private String item; // formatted output only
	private int tradeStatus;
	private int payment;
	private int earning;
	private String startTime;
	private String updateTime;
	
	public Trade() {
		this.tradeId = -1;
		this.producerId = -1;
		this.customerId = -1;
		this.itemId = -1;
		this.tradeStatus = -1;
		this.payment = -1;
		this.earning = -1;
		this.startTime = null;
		this.updateTime = null;
	}

	public int getTradeId() {
		return tradeId;
	}

	public int getProducerId() {
		return producerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getItemId() {
		return itemId;
	}

	public int getTradeStatus() {
		return tradeStatus;
	}

	public int getPayment() {
		return payment;
	}

	public int getEarning() {
		return earning;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public void setProducerId(int producerId) {
		this.producerId = producerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setTradeStatus(int tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	public void setEarning(int earning) {
		this.earning = earning;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getProducer() {
		return producer;
	}

	public String getCustomer() {
		return customer;
	}

	public String getItem() {
		return item;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setItem(String item) {
		this.item = item;
	}

}
