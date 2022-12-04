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
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
@RequiredArgsConstructor
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int ownerId;
	
	
	@Column(unique=true)
	@Size(max = 50)
	@Email
	private String ownerEmail;
	
	
private String ownerFirstName;

private int contactNo;

	public String getOwnerEmail() {
	return ownerEmail;
}

public void setOwnerEmail(String ownerEmail) {
	this.ownerEmail = ownerEmail;
}

public int getContactNo() {
	return contactNo;
}

public void setContactNo(int contactNo) {
	this.contactNo = contactNo;
}

	private String ownerLastName;
	
	private String ownerAddress;
	private int age;
	
@ManyToMany(mappedBy="owner",fetch = FetchType.LAZY)
@JsonIgnore
private Set<Property> property;

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

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Property> getProperty() {
		return property;
	}

	public void setProperty(Set<Property> property) {
		this.property = property;
	}

}
