package com.app.PropertySearchSystem.service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.PropertySearchSystem.entity.AddProperty;
import com.app.PropertySearchSystem.entity.Owner;
import com.app.PropertySearchSystem.entity.Property;
import com.app.PropertySearchSystem.entity.Tax;
import com.app.PropertySearchSystem.payload.response.MessageResponse;
import com.app.PropertySearchSystem.repository.OwnerRepository;
import com.app.PropertySearchSystem.repository.PropertyRepository;
import com.app.PropertySearchSystem.repository.TaxRepository;
@Service
public class PropertyService {
	@Autowired
	PropertyRepository propertyRepo;

	@Autowired
	OwnerRepository ownerRepo;
	@Autowired
	TaxRepository taxRepo;
	public List<Owner> getOwnerbyPropertyId(int propId) {
		// TODO Auto-generated method stub
		//return propertyRepo.CustomQuery(propertyAddress,propertyType);
		return ownerRepo.findOwnerByPropertyPropertyId(propId);
		//int ownerId =29;
		//return propertyRepo.findPropertyByOwnerOwnerId(ownerId);
		
	}
	public List<Property> searchProperty(String ownerFirstName, String ownerLastName, String propertyAddress,
			String propertyType) {
		// TODO Auto-generated method stub
		//return propertyRepo.CustomQuery(propertyAddress,propertyType);
		List<Property> propList= propertyRepo.findPropertyByAddressAndOwnerDetails(propertyAddress,propertyType,ownerFirstName,ownerLastName);
		//int ownerId =29;
	return propList;
	}


	private Boolean isPropertyAlreadyExists(@Valid Property property) {
		// TODO Auto-generated method stub
		return propertyRepo.existsByPlotNo(property.getPlotNo());
	}

	private Boolean isOwnerALreadyExists(String ownerEmail) {
		
		return ownerRepo.existsByOwnerEmail(ownerEmail);
		
		
		// TODO Auto-generated method stub
		
	}

	public ResponseEntity<?> addProperty(@Valid AddProperty addproperty) {
		 String ownerFirstName= addproperty.getOwnerFirstName();
		 String ownerLastName=addproperty.getOwnerLastName();
		String ownerEmail=addproperty.getOwnerEmail();
				 
		// TODO Auto-generated method stub
		Property property=addproperty.getProperty();
		Tax tax=addproperty.getTax();
		
		Owner newOwner;
		Tax tax2;
		Set<Owner> ownerSet=new HashSet<>();
		Boolean isPropertyExists = isPropertyAlreadyExists(property);
		if(isPropertyExists==true)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Property with the given plot no already exists"));
			
		Boolean isowner = isOwnerALreadyExists(ownerEmail);
		if(isowner==false)
		{ Owner owner=new Owner();
			owner.setOwnerFirstName(ownerFirstName);
			owner.setOwnerLastName(ownerLastName);
			owner.setOwnerEmail(ownerEmail);
		 newOwner=ownerRepo.save(owner);
		}
		else {
			 newOwner=ownerRepo.findByOwnerEmail(ownerEmail);
		}
		try {
		ownerSet.add(newOwner);
		
		property.setOwner(ownerSet );
		Tax tax1 = taxRepo.save(tax);
		property.setTax(tax1);
		
		 
		propertyRepo.save(property);
		return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse(HttpStatus.CREATED,"Inserted Successfully","CREATED"));
		}
		catch(Exception e) {
			//ResponseEntity re;
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Please try after some time.."));
		}
	}
	public ResponseEntity<?> updateBook(@Valid AddProperty addproperty) {
		 String ownerFirstName= addproperty.getOwnerFirstName();
		 String ownerLastName=addproperty.getOwnerLastName();
		String ownerEmail=addproperty.getOwnerEmail();
				 
		// TODO Auto-generated method stub
		Property property=addproperty.getProperty();
		Tax tax=addproperty.getTax();
		
		Owner newOwner;
		Tax tax2;
		Set<Owner> ownerSet=new HashSet<>();
		
		 Owner owner=new Owner();
			owner.setOwnerFirstName(ownerFirstName);
			owner.setOwnerLastName(ownerLastName);
			owner.setOwnerEmail(ownerEmail);
			owner.setOwnerId(addproperty.getOwnerId());
		 newOwner=ownerRepo.save(owner);
		
		try {
		ownerSet.add(newOwner);
		
		property.setOwner(ownerSet );
		Tax tax1 = taxRepo.save(tax);
		property.setTax(tax1);
		
		 
		propertyRepo.save(property);
		return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse(HttpStatus.CREATED,"Inserted Successfully","CREATED"));
		}
		catch(Exception e) {
			//ResponseEntity re;
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Please try after some time.."));
		}
		
	}
	public Property getPropertyById(String propertyId) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(propertyId);
	Property propList= propertyRepo.findByPropertyId(id);
		//int ownerId =29;
	return propList;
	}
	public ResponseEntity<?> deletePropertyById(String propertyId) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(propertyId);
		try{
			propertyRepo.deleteById(id);;
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(HttpStatus.OK,"DELETED Successfully","DELETED"));
		}
		catch(Exception e) {
			//ResponseEntity re;
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Please try after some time.."));
		}
		
	}

}
