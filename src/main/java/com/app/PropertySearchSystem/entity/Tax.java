package com.app.PropertySearchSystem.entity;
import java.util.Date;
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

import org.hibernate.annotations.Check;

import lombok.Data;

@Entity
@Data
@Check(constraints = "escrow_detail IN ('ESCROW', 'NON-ESCROW')")
public class Tax {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int taxId;
private float taxRate;
private double taxAmount;
private String taxStatus;


//@Column(columnDefinition = "VARCHAR(60) CHECK (escrowDetail IN ('ESCROW', 'NONESCROW'))")
private String escrowDetail;



public int getTaxId() {
	return taxId;
}

public void setTaxId(int taxId) {
	this.taxId = taxId;
}

public float getTaxRate() {
	return taxRate;
}

public void setTaxRate(float taxRate) {
	this.taxRate = taxRate;
}

public double getTaxAmount() {
	return taxAmount;
}

public void setTaxAmount(double taxAmount) {
	this.taxAmount = taxAmount;
}

public String getTaxStatus() {
	return taxStatus;
}

public void setTaxStatus(String taxStatus) {
	this.taxStatus = taxStatus;
}

public String getEscrowDetail() {
	return escrowDetail;
}

public void setEscrowDetail(String escrowDetail) {
	this.escrowDetail = escrowDetail;
}




}
