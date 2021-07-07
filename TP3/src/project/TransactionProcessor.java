package project;

import java.text.SimpleDateFormat;
import java.util.Date;
import model.*;

public class TransactionProcessor implements InterfaceTransactionProcessor {
	
	private InterfaceDao db_dao_Interface;

	public TransactionProcessor(InterfaceDao db_dao_Interface) {
		this.db_dao_Interface = db_dao_Interface;
	}

	public boolean AddPenality(String name, double penality) {
		Client client = this.db_dao_Interface.getClient(name);
		if (client != null) {
			if (client.getAccountBalance() >= penality) {
				this.db_dao_Interface.setClientSolde(client, client.getAccountBalance() - penality);
				return true;
			}
		}
		return false;
	}

	public boolean CheckOut(String articleTitle, String clientName, String dueDate) {
		StockItem item = this.db_dao_Interface.getStockItem(articleTitle);
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

	public boolean CheckIn(String articleTitle, String clientName) {
		for (RentedItem element : this.db_dao_Interface.getRentedItems()) {
			if ((element.getCustomer().getName().equals(clientName)) && (element.getItem().getTitle().equals(articleTitle))) {
				this.db_dao_Interface.removeRentedItem(element);
				return true;
			}
		}
		return false;
	}

	public boolean AddCustomer(String name, double accountBalance) {
		if (this.db_dao_Interface.getClient(name) == null) {
			this.db_dao_Interface.addClient(accountBalance, name);
			return true;
		}
		return false;
	}

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
}
