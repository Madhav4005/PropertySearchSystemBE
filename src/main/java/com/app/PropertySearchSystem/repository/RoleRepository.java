package com.app.PropertySearchSystem.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.PropertySearchSystem.entity.ERole;
import com.app.PropertySearchSystem.entity.Roles;





@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
	Optional<Roles> findByName(ERole name);
}

