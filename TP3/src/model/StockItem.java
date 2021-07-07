package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the StockItems database table.
 * 
 */
@Entity
@Table(name="StockItems")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")  
@NamedQuery(name="StockItem.findAll", query="SELECT s FROM StockItem s")
public class StockItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ItemID")
	private int itemID;


	@Column(name="type")
	private int itemType;


	private double rentalPrice;

	private String title;

	public StockItem() {
	}

	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	/*public String getActeur() {
		return this.acteur;
	}

	public void setActeur(String acteur) {
		this.acteur = acteur;
	}*/

	public int getItemType() {
		return this.itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	/*public String getPlateforme() {
		return this.plateforme;
	}*/

	/*public void setPlateforme(String plateforme) {
		this.plateforme = plateforme;
	}*/

	public double getRentalPrice() {
		return this.rentalPrice;
	}

	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}