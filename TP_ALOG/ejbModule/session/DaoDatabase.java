package session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;
import model.Film;
import model.Jeux;
import model.RentedItem;
import model.StockItem;

/**
 * Session Bean implementation class DaoDatabase
 */
@Stateless
@LocalBean
public class DaoDatabase implements DaoDatabaseRemote {

    /**
     * Default constructor. 
     */
    public DaoDatabase() {
		this.emf = Persistence.createEntityManagerFactory("TP_ALOG");
	    this.em = emf.createEntityManager();
    }
    
	EntityManagerFactory emf;
	EntityManager em;


	@Override
	public Client getClient(String name) {
		try {
			Client client = (Client) em.createQuery("select c from Client c where c.name like :name").setParameter("name", "%"+name+"%").getSingleResult();
			return client;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RentedItem> getRentedItems() {
		Client client;
		StockItem stockItem;
		List<RentedItem> rentedItems = new ArrayList<RentedItem>();
		try {
			rentedItems = em.createQuery("select r from RentedItem r").getResultList();
			for (RentedItem item: rentedItems) {
				client = (Client) em.createQuery("select c from Client c where c.customerID = :idClient").setParameter("idClient", item.getCustomerID()).getSingleResult();
				stockItem = (StockItem) em.createQuery("select s from StockItem s where s.itemID = :idItem").setParameter("idItem", item.getItemID()).getSingleResult();
				item.setCustomer(client);
				item.setItem(stockItem);
			}
			return rentedItems;
		} catch (Exception e) {
			return rentedItems;
		}
	}

	@Override
	public RentedItem getRentedItem(String title) {
		StockItem item = (StockItem) em.createQuery("select s from StockItem s where s.title like :title").setParameter("title", "%"+title+"%").getSingleResult();
		try {
			RentedItem rentedItem = (RentedItem) em.createQuery("select r from RentedItem r where r.itemID = :id").setParameter("id", item.getItemID()).getSingleResult();
			Client client = (Client) em.createQuery("select c from Client c where c.customerID = :idClient").setParameter("idClient", rentedItem.getCustomerID()).getSingleResult();
			rentedItem.setCustomer(client);
			rentedItem.setItem(item);
			return rentedItem;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public StockItem getStockItem(String articleTitle) {
		try {
			StockItem item = (StockItem) em.createQuery("select s from StockItem s where s.title like :articleTitle").setParameter("articleTitle", "%"+articleTitle+"%").getSingleResult();
			return item;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockItem> getStockItems() { //Vérifier cas liste vide
		List<StockItem> stockItems = new ArrayList<StockItem>();
		try {
			stockItems = em.createQuery("select s from StockItem s").getResultList();
			return stockItems;
		} catch (Exception e) {
			return stockItems;
		}
	}

	@Override
	public void addRentedItem(int customerID, int itemID, Date dueDate) {
		em.getTransaction().begin();
		RentedItem rentedItem = new RentedItem();
		rentedItem.setCustomerID(customerID);
		rentedItem.setItemID(itemID);
		rentedItem.setDueDate(dueDate);
		em.persist(rentedItem);
		em.flush();
	    em.clear();
		em.getTransaction().commit();
	}
	
	@Override
	public void setClientSolde(Client client, double solde) {
		em.getTransaction().begin();
		Client c = em.find(Client.class, client.getCustomerID());
		c.setAccountBalance(solde);
		em.persist(c);
		em.flush();
	    em.clear();
		em.getTransaction().commit();
	}

	@Override
	public void removeRentedItem(RentedItem item) {
		em.getTransaction().begin();
		RentedItem i = em.find(RentedItem.class, item.getRentID());
		em.remove(i);
		em.flush();
	    em.clear();
		em.getTransaction().commit();
	}

	@Override
	public void addClient(double accountBalance, String name) {
		em.getTransaction().begin();
		Client client = new Client();
		client.setAccountBalance(accountBalance);
		client.setName(name);
		em.persist(client);
		em.flush();
	    em.clear();
		em.getTransaction().commit();
	}

	@Override
	public void addGame(double rentalPrice, String title, String plateforme) {
		em.getTransaction().begin();
		Jeux jeu = new Jeux();
		jeu.setPlateforme(plateforme);
		jeu.setTitle(title);
		jeu.setRentalPrice(rentalPrice);
		em.persist(jeu);
		em.flush();
	    em.clear();
		em.getTransaction().commit();
	}

	@Override
	public void addFilm(double rentalPrice, String title, String acteur) {
		em.getTransaction().begin();
		Film film = new Film();
		film.setActeur(acteur);
		film.setTitle(title);
		film.setRentalPrice(rentalPrice);
		em.persist(film);
		em.flush();
	    em.clear();
		em.getTransaction().commit();
	}


	

}
