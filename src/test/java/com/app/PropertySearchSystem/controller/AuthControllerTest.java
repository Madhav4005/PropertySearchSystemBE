package com.app.PropertySearchSystem.controller;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.PropertySearchSystem.entity.ERole;
import com.app.PropertySearchSystem.entity.Roles;
import com.app.PropertySearchSystem.entity.User;
import com.app.PropertySearchSystem.payload.request.LoginRequest;
import com.app.PropertySearchSystem.payload.request.SignupRequest;
import com.app.PropertySearchSystem.payload.response.MessageResponse;
import com.app.PropertySearchSystem.repository.RoleRepository;
import com.app.PropertySearchSystem.repository.UserRepository;
import com.app.PropertySearchSystem.security.jwt.JwtUtils;

import org.junit.Test;

public class AuthControllerTest {
//	@Mock
//	AuthenticationManager authenticationManager;
//
//	@Mock
//	UserRepository userRepository;
//
//	@Mock
//	RoleRepository roleRepository;
//
//	@Mock
//	PasswordEncoder encoder;
//
//	@Mock
//	JwtUtils jwtUtils;
//	
//	@InjectMocks
//	AuthController authController;
//	
//	@Test
//	public void authenticateUserTest() {
//		LoginRequest loginRequest= new LoginRequest();
//		loginRequest.setUsername("ankita");
//		loginRequest.setPassword("123456");
//		Authentication authToken = new UsernamePasswordAuthenticationToken (loginRequest.getUsername(), loginRequest.getPassword());
//		SecurityContextHolder.getContext().setAuthentication(authToken);
//	}
//	
//	@Test
//	public void testRegisterUsertWithExistingUser() {
//		SignupRequest signUpRequest = new SignupRequest();
//		Set<Roles> rolelist= new HashSet();
//		Roles role= new Roles();
//		role.setName(ERole.ROLE_ADMIN);
//		signUpRequest.setUsername("ankita");
//		signUpRequest.setPassword("123456");
//		signUpRequest.setEmail("ankita@gmail.com");
//		rolelist.add(role);
//		when(userRepository.existsByUsername(signUpRequest.getUsername())).thenReturn(true);
//		ResponseEntity responseEntity= ResponseEntity
//				.badRequest()
//				.body(new MessageResponse("Error:  Username is already taken!"));
//		ResponseEntity responseEntity1= authController.registerUser(signUpRequest);
//		assertNotNull(responseEntity1);
//	}
//	
//	@Test
//	public void testRegisterUsertWithExistinEmail() {
//		SignupRequest signUpRequest = new SignupRequest();
//		Set<Roles> rolelist= new HashSet();
//		Roles role= new Roles();
//		role.setName(ERole.ROLE_ADMIN);
//		signUpRequest.setUsername("ankita");
//		signUpRequest.setPassword("123456");
//		signUpRequest.setEmail("ankita@gmail.com");
//		rolelist.add(role);
//		when(userRepository.existsByEmail(signUpRequest.getEmail())).thenReturn(true);
//		ResponseEntity responseEntity= ResponseEntity
//				.badRequest()
//				.body(new MessageResponse("Error: Email is already in use!"));
//		ResponseEntity responseEntity1= authController.registerUser(signUpRequest);
//		assertNotNull(responseEntity1);
//	}
//	
//	@Test
//	public void testRegisterUserWithDefaultUser() {
//		SignupRequest signUpRequest = new SignupRequest();
//		Set<Roles> rolelist= new HashSet();
////		Role role= new Role();
////		role.setName(ERole.ROLE_AUTHOR);
//		signUpRequest.setUsername("ankita");
//		signUpRequest.setPassword("123456");
//		signUpRequest.setEmail("ankita@gmail.com");
////		rolelist.add(role);
////		when(userRepository.existsByEmail(signUpRequest.getEmail())).thenReturn(true);
////		ResponseEntity responseEntity= ResponseEntity
////				.badRequest()
////				.body(new MessageResponse("Error: Email is already in use!"));
////		ResponseEntity responseEntity1= authController.registerUser(signUpRequest);
////		assertNotNull(responseEntity1);
//		
//		// Create new user's account
//				User user = new User(signUpRequest.getUsername(), 
//									 signUpRequest.getEmail(),
//									 encoder.encode(signUpRequest.getPassword()));
//
//				Set<String> strRoles = signUpRequest.getRole();
//				Set<Roles> roles = new HashSet<>();
//				when(signUpRequest.getRole()).thenReturn(null);
//				
//				Roles readerRole = new Roles();
//				readerRole.setName(ERole.ROLE_ADMIN);
//				Optional<Roles> optioanl=Optional.of(readerRole);
//				when(roleRepository.findByName(ERole.ROLE_USER)).thenReturn(optioanl);
//				ResponseEntity responseEntity=ResponseEntity.ok(new MessageResponse("Reader"+"  registered is  successfully!"));
//				ResponseEntity responseEntity1=authController.registerUser(signUpRequest);
//                assertNotNull(responseEntity1);
//	}
//	
//	@Test
//	public void testRegisterUserWithDefaultUserReader() {
//		SignupRequest signUpRequest = new SignupRequest();
//		Set<Roles> rolelist= new HashSet();
//		Roles role= new Roles();
//		role.setName(ERole.ROLE_USER);
//		signUpRequest.setUsername("ankita");
//		signUpRequest.setPassword("123456");
//		signUpRequest.setEmail("ankita@gmail.com");	
//		rolelist.add(role);
//	
//		// Create new user's account
//				User user = new User(signUpRequest.getUsername(), 
//									 signUpRequest.getEmail(),
//									 encoder.encode(signUpRequest.getPassword()));
//
//				Set<String> strRoles = signUpRequest.getRole();
//				Set<Roles> roles = new HashSet<>();
//				when(signUpRequest.getRole()).thenReturn(strRoles);
//				
//				Roles readerRole = new Roles();
//				readerRole.setName(ERole.ROLE_USER);
//				Optional<Roles> optioanl=Optional.of(readerRole);
//				when(roleRepository.findByName(ERole.ROLE_USER)).thenReturn(optioanl);
//				ResponseEntity responseEntity=ResponseEntity.ok(new MessageResponse("Reader"+"  registered is  successfully!"));
//				ResponseEntity responseEntity1=authController.registerUser(signUpRequest);
//                assertNotNull(responseEntity1);
//	}
	}

