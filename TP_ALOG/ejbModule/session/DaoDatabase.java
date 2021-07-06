package session;

import java.util.ArrayList;
import model.*;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import model.Client;
import model.Jeux;

import model.Renteditem;

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
	
	}
	
	   @PersistenceContext(unitName="TP_ALOG")
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
	
	@Override
	public Client getClientID(int id) {
		try {
			Client client = (Client) em.createQuery("select c from Client c where c.customerID = :id").setParameter("id", id).getSingleResult();
			return client;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Stockitem getItemID(int id) {
		try {
			Stockitem item = (Stockitem) em.createQuery("select s from Stockitem s where s.itemID = :id").setParameter("id", id).getSingleResult();	
			
			return item;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Renteditem> getRentedItems() {
		Client client;
		Stockitem stockItem;
		List<Renteditem> rentedItems = new ArrayList<Renteditem>();
		try {
			rentedItems = em.createQuery("select r from Renteditem r").getResultList();
			for (Renteditem item: rentedItems) {
				client = getClientID(item.getCustomerID());
				stockItem = getItemID(item.getItemID());
				item.setCustomer(client);
				item.setItem(stockItem);
			}
			return rentedItems;
		} catch (Exception e) {
			return rentedItems;
		}
	}

	@Override
	public Renteditem getRentedItem(String title) {
		Stockitem item = (Stockitem) em.createQuery("select s from Stockitem s where s.title like :title").setParameter("title", "%"+title+"%").getSingleResult();
		try {
			Renteditem rentedItem = (Renteditem) em.createQuery("select r from Renteditem r where r.itemID = :id").setParameter("id", item.getItemID()).getSingleResult();
			Client client = (Client) em.createQuery("select c from Client c where c.customerID = :idClient").setParameter("idClient", rentedItem.getCustomerID()).getSingleResult();
			rentedItem.setCustomer(client);
			rentedItem.setItem(item);
			return rentedItem;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Stockitem getStockItem(String articleTitle) {
		try {
			Stockitem item = (Stockitem) em.createQuery("select s from Stockitem s where s.title like :articleTitle").setParameter("articleTitle", "%"+articleTitle+"%").getSingleResult();
			return item;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stockitem> getStockItems() { 
		List<Stockitem> stockItems = new ArrayList<Stockitem>();
		try {
			stockItems = em.createQuery("select s from Stockitem s").getResultList();
			return stockItems;
		} catch (Exception e) {
			return stockItems;
		}
	}

	@Override
	public void addRentedItem(int customerID, int itemID, Date dueDate) {
		Renteditem rentedItem = new Renteditem();
		rentedItem.setCustomerID(customerID);
		rentedItem.setItemID(itemID);
		rentedItem.setDueDate(dueDate);
		em.persist(rentedItem);
		em.flush();
	    em.clear();
	}
	
	@Override
	public void setClientSolde(Client client, double solde) {
		Client c = em.find(Client.class, client.getCustomerID());
		c.setAccountBalance(solde);
		em.persist(c);
		em.flush();
	    em.clear();
	}

	@Override
	public void removeRentedItem(Renteditem item) {
		Renteditem i = em.find(Renteditem.class, item.getRentID());
		em.remove(i);
		em.flush();
	    em.clear();
	}

	@Override
	public void addClient(double accountBalance, String name) {
		Client client = new Client();
		client.setAccountBalance(accountBalance);
		client.setName(name);
		
		em.persist(client);
		em.flush();
		em.clear();

	}

	@Override
	public void addGame(double rentalPrice, String title, String plateforme) {
		Jeux jeu = new Jeux();
		jeu.setPlateforme(plateforme);
		jeu.setTitle(title);
		jeu.setRentalPrice(rentalPrice);
		em.persist(jeu);
		em.flush();
	    em.clear();
	}

	@Override
	public void addFilm(double rentalPrice, String title, String acteur) {
		Film film = new Film();
		film.setActeur(acteur);
		film.setTitle(title);
		film.setRentalPrice(rentalPrice);
		em.persist(film);
		em.flush();
	    em.clear();
	}

	


	

}
