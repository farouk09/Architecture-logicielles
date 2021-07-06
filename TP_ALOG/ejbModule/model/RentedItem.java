package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the renteditems database table.
 * 
 */
@Entity
@Table(name="renteditems")
@NamedQuery(name="Renteditem.findAll", query="SELECT r FROM Renteditem r")
public class Renteditem extends RentedItemM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int rentID;

	@Column(name="customerID")
	private int customerID;

	@Temporal(TemporalType.DATE)
	private Date dueDate;

	@Column(name="ItemID")
	private int itemID;

	public Renteditem() {
	}

	public int getRentID() {
		return this.rentID;
	}

	public void setRentID(int rentID) {
		this.rentID = rentID;
	}

	public int getCustomerID() {
		return this.customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

}