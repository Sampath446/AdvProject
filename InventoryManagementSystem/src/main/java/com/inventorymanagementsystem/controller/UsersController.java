package com.inventorymanagementsystem.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanagementsystem.exception.ResourceNotFoundException;
import com.inventorymanagementsystem.model.Users;
import com.inventorymanagementsystem.repository.UsersRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;
	
	// get all Users
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}		
	
	// create users rest api
	@PostMapping("/users")
	public Users createusers(@RequestBody Users users) {
		return usersRepository.save(users);
	}
	
	// get users by id rest api
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getusersById(@PathVariable Long id) {
		Users users = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("users not exist with id :" + id));
		return ResponseEntity.ok(users);
	}
	
	// update users rest api
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Users> usersusers(@PathVariable Long id, @RequestBody Users usersDetails){
		Users users = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("users not exist with id :" + id));
		
		users.setName(usersDetails.getName());
		users.setUser_name(usersDetails.getUser_name());
		users.setPassword(usersDetails.getPassword());
		
	
		Users updatedusers = usersRepository.save(users);
		return ResponseEntity.ok(updatedusers);
	}
	
	// delete users rest api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteusers(@PathVariable Long id){
		Users users = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("users not exist with id :" + id));
		
		usersRepository.delete(users);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}

	

