package model;

public class RentedItemM {
	
	private Client client ;
	private Stockitem item;
	
	public Client getCustomer() {
		return client;
	}
	
	public void setCustomer(Client client) {
		this.client = client;
	}

	public Stockitem getItem() {
		return item;
	}
	
	public void setItem(Stockitem item) {
		this.item = item;
	}

}
