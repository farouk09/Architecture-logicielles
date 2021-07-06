package session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import model.Renteditem;

@Remote
public interface TransactionProcessorRemote {

	public boolean AddPenality(String name, double penality);

	public boolean CheckOut(String articleTitle, String clientName, String dueDate);

	public boolean CheckIn(String articleTitle, String clientName);

	public boolean AddCustomer(String name, double accountBalance);

	public boolean AddStockItem(double rentalPrice, String title, boolean isGame, String plateforme, String acteur);
	
	
	public boolean FindByTitle(String title);
	
	public List<String> NdByActor(String acteur);
	
	public double Solde(String name);
	
	public ArrayList<Renteditem> RentedFilms(String name);
	
	public ArrayList<Renteditem> OverdueItems();
}
