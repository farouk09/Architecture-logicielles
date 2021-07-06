package session;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import model.Client;
import model.RentedItem;
import model.StockItem;

@Remote
public interface DaoDatabaseRemote {
	
	public Client getClient(String name);
	
	public List<RentedItem> getRentedItems();
	
	public RentedItem getRentedItem(String title);
	
	public StockItem getStockItem(String articleTitle);
	
	public List<StockItem> getStockItems();
	
	public void setClientSolde(Client client, double solde);
	
	public void addRentedItem(int customerID, int itemID, Date dueDate);
	
	public void removeRentedItem(RentedItem item);
	
	public void addClient(double accountBalance, String name);
	
	public void addGame(double rentalPrice, String title, String plateforme);
	
	public void addFilm(double rentalPrice, String title, String acteur);


}
