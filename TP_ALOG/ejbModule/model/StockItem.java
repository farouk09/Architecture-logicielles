package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stockitems database table.
 * 
 */
@Entity
@Table(name="stockitems")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")  
@NamedQuery(name="StockItem.findAll", query="SELECT s FROM StockItem s")
public class StockItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int itemID;

	private String acteur;

	private String plateforme;

	private double rentalPrice;

	private String title;

	private int type;

	public StockItem() {
	}

	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getActeur() {
		return this.acteur;
	}

	public void setActeur(String acteur) {
		this.acteur = acteur;
	}

	public String getPlateforme() {
		return this.plateforme;
	}

	public void setPlateforme(String plateforme) {
		this.plateforme = plateforme;
	}

	public double getRentalPrice() {
		return this.rentalPrice;
	}

	public void setRentalPrice(double rentalPrice2) {
		this.rentalPrice = rentalPrice2;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}