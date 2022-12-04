package com.app.PropertySearchSystem.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.PropertySearchSystem.entity.Owner;
import com.app.PropertySearchSystem.entity.Property;
import com.app.PropertySearchSystem.entity.User;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

	Boolean existsByOwnerEmail(String ownerEmail);

	Owner findByOwnerEmail(String ownerEmail);

	List<Owner> findOwnerByPropertyPropertyId(int propId);

	

}

