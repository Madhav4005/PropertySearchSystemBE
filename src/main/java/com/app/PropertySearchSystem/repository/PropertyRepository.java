package com.app.PropertySearchSystem.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.PropertySearchSystem.entity.AddProperty;
import com.app.PropertySearchSystem.entity.Property;
import com.app.PropertySearchSystem.entity.User;

public interface PropertyRepository extends JpaRepository<Property, Integer>{

	List<Property> findByPropertyAddressAndPropertyType(String propertyAddress, String propertyType);
	

	Boolean existsByPlotNo(String plotNo);
	
	@Query("SELECT  p from Property p  where p.propertyAddress=:a or p.propertyType=:t" )
	List<Property> CustomQuery(@Param("a") String propertyAddress, @Param("t") String propertyType);
	
	@Query("SELECT  p  from Property p JOIN p.owner o where ((:a IS NULL)OR(:a IS NOT NULL AND p.propertyAddress like %:a%)) AND ((:t IS NULL)OR(:t IS NOT NULL AND p.propertyType like %:t%))"
			+ " AND ((:f IS NULL)OR(:f IS NOT NULL AND o.ownerFirstName like %:f%)) AND ((:l IS NULL)OR(:l IS NOT NULL AND o.ownerLastName like %:l%))" )
	List<Property> findPropertyByAddressAndOwnerDetails(@Param("a") String propertyAddress, @Param("t") String propertyType,@Param("f")String ownerFirstName,@Param("l") String ownerLastName);


	List<Property> findPropertyByOwner(int i);


	List<Property> findPropertyByOwnerOwnerId(int ownerId);


Property findByPropertyId(int id);
	
//	@Query("SELECT p from Property p  where ((:propAddress IS NULL) OR (:propAddress IS NOT NULL AND p.propertyAddress = :propAddress))\r\n"
//			+ "	or ((:propType IS NULL) OR (:propType IS NOT NULL AND p.propertyType = :propType)) and p.propertyId in (\r\n"
//			+ "	select k.propertyId from propertyOwner k where k.ownerId in \r\n"
//			+ "	(SELECT ownerId FROM Owner own \r\n"
//			+ "	where ((:firstName IS NULL) OR (:firstName IS NOT NULL AND own.ownerFirstName = :firstName))\r\n"
//			+ "	 or ((:lastName IS NULL) OR (:lastName IS NOT NULL AND own.ownerLastName = :lastName))))\r\n"
//			+ "	 \r\n")
//	List<Property> CustomQuery3(@Param("propAddress") String propertyAddress, @Param("propType") String propertyType,@Param("firstName")String ownerFirstName,@Param("lastName") String ownerLastName);
//	
	
//	SELECT distinct * from property p ,owner o where p.property_address like '%Amravati%' 
//	or p.property_type like '%PLOT%' and p.property_id in (
//	select property_id from property_owner where owner_id in 
//	(SELECT owner_id FROM propertysearchdb.owner own 
//	where own.owner_first_name like '%ameya%'
//	 or own.owner_last_name like '%bhogaonkar%'))
	
	
	
	
	
	
	
}
