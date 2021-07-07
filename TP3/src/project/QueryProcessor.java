package project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.*;

public class QueryProcessor implements InterfaceQueryProcessor {
	
	private InterfaceDao db_dao_Interface;

	public QueryProcessor(InterfaceDao db_dao_Interface) {
		this.db_dao_Interface = db_dao_Interface;
	}
	
	public boolean FindByTitle(String title) {
		if (this.db_dao_Interface.getStockItem(title)!=null) {
			return (this.db_dao_Interface.getRentedItem(title)==null);
		} else return false;
	}
	
	public List<Film> NdByActor(String acteur) {
		ArrayList<Film> films = new ArrayList<Film>();
		List<StockItem> stockItems = this.db_dao_Interface.getStockItems();
		for (StockItem item : stockItems) {
			if ((item instanceof Film) && (((Film) item).getActeur().equals(acteur))) {
				films.add((Film) item);
			}
		}
		return films;
	}
	
	public double Solde(String name) {
		Client client = this.db_dao_Interface.getClient(name);
		if (client != null)
			return client.getAccountBalance();
		return -1;
	}
	
	public ArrayList<RentedItem> RentedFilms(String name) {
		/*
		* Client client = new Client(150, "Sami", 1); Film itemm = new Film(150,
		* "title", 1, "acteur"); try { Date dd = new
		* SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"); this.rentedItems.add(new
		* RentedItem(client, itemm, dd));} catch(Exception e) {}
		*/
		ArrayList<RentedItem> liste = new ArrayList<RentedItem>();
		for (RentedItem element : this.db_dao_Interface.getRentedItems()) {
			if ((element.getItem() instanceof Film) && (element.getCustomer().getName().equals(name)))
				liste.add(element);
		}
		return liste;
	}
	
	public ArrayList<RentedItem> OverdueItems() {
		/*Client client = new Client(150, "Sami", 1);
		Film itemm = new Film(150, "title", 1, "acteur");
		try {
			Date dd = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998");
			this.rentedItems.add(new RentedItem(client, itemm, dd));
		} catch (Exception e) {
		}*/
		Date currentDate = new Date();
		ArrayList<RentedItem> liste = new ArrayList<RentedItem>();
		for (RentedItem element : this.db_dao_Interface.getRentedItems()) {
			if (element.getDueDate().before(currentDate)) {
				liste.add(element);
			}
		}
		return liste;
	}
}
