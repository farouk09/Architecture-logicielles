package session;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import model.Client;
import model.Film;
import model.Renteditem;
import model.Stockitem;


/**
 * Session Bean implementation class TransactionProcessor
 */
@Stateless
@LocalBean
public class TransactionProcessor implements TransactionProcessorRemote {

    /**
     * Default constructor. 
     */
    public TransactionProcessor() {
        // TODO Auto-generated constructor stub
    	
    }
    
	@EJB
	session.DaoDatabaseRemote db_dao_Interface;

    
    @Override
	public boolean AddPenality(String name, double penality) {////////////////////////////////
		Client client = this.db_dao_Interface.getClient(name);
		if (client != null) {
			if (client.getAccountBalance() >= penality) {
				this.db_dao_Interface.setClientSolde(client, client.getAccountBalance() - penality);
				return true;
			}
		}
		return false;
	}

    @Override
	public boolean CheckOut(String articleTitle, String clientName, String dueDate) {
		Stockitem item = this.db_dao_Interface.getStockItem(articleTitle);
		Client client = this.db_dao_Interface.getClient(clientName);
		if (item != null && client != null && item.getRentalPrice() <= client.getAccountBalance()) {
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dueDate);

				this.db_dao_Interface.setClientSolde(client, client.getAccountBalance() - item.getRentalPrice());
				this.db_dao_Interface.addRentedItem(client.getCustomerID(), item.getItemID(), date);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

    @Override
	public boolean CheckIn(String articleTitle, String clientName) {
		for (Renteditem element : this.db_dao_Interface.getRentedItems()) {
			if ((this.db_dao_Interface.getClientID(element.getCustomerID()).getName().equals(clientName)) && (this.db_dao_Interface.getItemID(element.getItemID()).getTitle().equals(articleTitle))) {
				this.db_dao_Interface.removeRentedItem(element);
				return true;
			}
		}
		return false;
	}

    @Override
	public boolean AddCustomer(String name, double accountBalance) {
		if (this.db_dao_Interface.getClient(name) == null) {
			this.db_dao_Interface.addClient(accountBalance, name);
			return true;
		}
		return false;
	}

    @Override
	public boolean AddStockItem(double rentalPrice, String title, boolean isGame, String plateforme, String acteur) {
		if (this.db_dao_Interface.getStockItem(title) == null) {
			if (isGame) {
				this.db_dao_Interface.addGame(rentalPrice, title, plateforme);
			} else {
				this.db_dao_Interface.addFilm(rentalPrice, title, acteur);
			}
			return true;
		} 
	else return false;
	}
    
    
    
    
    
    
    
    
    @Override
	public boolean FindByTitle(String title) {
		if (this.db_dao_Interface.getStockItem(title)!=null) {
			return (this.db_dao_Interface.getRentedItem(title)==null);
		} else return false;
	}
	
    @Override
	public List<String> NdByActor(String acteur) {
		ArrayList<String> films = new ArrayList<String>();
		List<Stockitem> stockItems = this.db_dao_Interface.getStockItems();
		for (Stockitem item : stockItems) {
			if (item.getType()==2 && (((Film) item).getActeur().equals(acteur))) {
				
				films.add(((Film) item).getTitle());
			}
		}
		
		
		
		return films;
	}
	
    @Override
	public double Solde(String name) {
		Client client = this.db_dao_Interface.getClient(name);
		if (client != null)
			return client.getAccountBalance();
		return -1;
	}


	
   @Override
	public ArrayList<Renteditem> RentedFilms(String name) {
	
		ArrayList<Renteditem> liste = new ArrayList<Renteditem>();
		for (Renteditem element : this.db_dao_Interface.getRentedItems()) {
			
			if (( this.db_dao_Interface.getItemID(element.getItemID()) instanceof Film) && (this.db_dao_Interface.getClientID(element.getCustomerID()).getName().equals(name)))
				liste.add(element);
		}
		return liste;
	}
	
    @Override
	public ArrayList<Renteditem> OverdueItems() {
	
		Date currentDate = new Date();
		ArrayList<Renteditem> liste = new ArrayList<Renteditem>();
		for (Renteditem element : this.db_dao_Interface.getRentedItems()) {
			if (element.getDueDate().before(currentDate)) {
				liste.add(element);
			}
		}
		return liste;
	}

}
