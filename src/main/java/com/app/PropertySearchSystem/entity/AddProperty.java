package com.app.PropertySearchSystem.entity;
import com.app.PropertySearchSystem.entity.Property;
import com.app.PropertySearchSystem.entity.Tax;

public class AddProperty {
	private Tax tax;
	private Property property;
	private String ownerFirstName;
	private String ownerLastName;
	private String ownerEmail;
	private int ownerId;
	
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}
	public String getOwnerLastName() {
		return ownerLastName;
	}
	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public Tax getTax() {
		return tax;
	}
	public void setTax(Tax tax) {
		this.tax = tax;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public AddProperty(Tax tax, Property property) {
		super();
		this.tax = tax;
		this.property = property;
	}
	
	

}
