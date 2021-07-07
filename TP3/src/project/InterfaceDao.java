package project;

import java.util.*;
import model.*;

public interface InterfaceDao {
	
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
