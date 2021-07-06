package session;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import model.Client;
//import model.RentedItem;
//import model.StockItem;
import model.Renteditem;
import model.Stockitem;

@Remote
public interface DaoDatabaseRemote {
	
	public Client getClient(String name);
	
	public List<Renteditem> getRentedItems();
	
	public Renteditem getRentedItem(String title);
	
	public Stockitem getStockItem(String articleTitle);
	
	public List<Stockitem> getStockItems();
	
	public void setClientSolde(Client client, double solde);
	
	public void addRentedItem(int customerID, int itemID, Date dueDate);
	
	public void removeRentedItem(Renteditem item);
	
	public void addClient(double accountBalance, String name);
	
	public void addGame(double rentalPrice, String title, String plateforme);
	
	public void addFilm(double rentalPrice, String title, String acteur);

	Client getClientID(int id);

	Stockitem getItemID(int id);


}
