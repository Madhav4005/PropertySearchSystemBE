package com.app.PropertySearchSystem.entity;
import java.util.Date;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//import lombok.Data;
 

@Entity
//@Data
@Getter
@Setter
@RequiredArgsConstructor
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int propertyId;
	@NotBlank
	//@Column(unique=true)
private String propertyAddress;
	@NotBlank
	@Column(unique=true)
	@Size(max = 20)
	private String plotNo;
	private String propertyType;
	private String legalDescription;
	private double rate;

	//onetoMany
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "property_owner", 
				joinColumns = @JoinColumn(name = "property_id"), 
				inverseJoinColumns = @JoinColumn(name = "owner_id"))
	//@JsonIgnore
	private Set<Owner> owner = new HashSet<>();
	
	
	
	
	
	private double area;
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(	name = "property_tax", 
//				joinColumns = @JoinColumn(name = "property_id"), 
//				inverseJoinColumns = @JoinColumn(name = "tax_id"))
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "tax", referencedColumnName = "id")
	
	@OneToOne
	//@JsonIgnore
	private Tax tax;
	
	public Tax getTax() {
		return tax;
	}



	public void setTax(Tax tax) {
		this.tax = tax;
	}



	public int getPropertyId() {
		return propertyId;
	}



	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}



	public String getPropertyAddress() {
		return propertyAddress;
	}



	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}



	public String getPropertyType() {
		return propertyType;
	}



	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}



	public String getLegalDescription() {
		return legalDescription;
	}



	public void setLegalDescription(String legalDescription) {
		this.legalDescription = legalDescription;
	}



	public double getRate() {
		return rate;
	}



	public void setRate(double rate) {
		this.rate = rate;
	}



	public double getArea() {
		return area;
	}



	public void setArea(double area) {
		this.area = area;
	}



	public Set<Owner> getOwner() {
		return owner;
	}



	public void setOwner(Set<Owner> owner) {
		this.owner = owner;
	}



	public String getPlotNo() {
		return plotNo;
	}



	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}



	

	
	
//	@OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "taxPayStatus", referencedColumnName = "id")
//	@Column(columnDefinition = "VARCHAR(60) CHECK (taxPayStatus IN ('PAID', 'NOT PAID', 'INCOMPLETE')")
//  private String taxPayStatus;
	
//	@Column(columnDefinition = "VARCHAR(60) CHECK (status IN ('ACTIVE', 'PENDING', 'INACTIVE')))
//	private String status;
}
