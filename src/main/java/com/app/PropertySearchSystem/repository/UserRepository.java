package com.app.PropertySearchSystem.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.PropertySearchSystem.entity.User;

import org.springframework.data.domain.Example;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	 Boolean existsByUsername(String username) ;

	Boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);
	
}
