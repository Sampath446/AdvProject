package com.inventorymanagementsystem.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

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
import com.inventorymanagementsystem.model.Customer;
import com.inventorymanagementsystem.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	// get all customers
	@GetMapping("/customers")
	public List<Customer> getAllcustomers(){
		return customerRepository.findAll();
	}		
	
	// create customer rest api
	@PostMapping("/customers")
	public Customer createcustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	// get customer by id rest api
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getcustomerById(@PathVariable Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("customer not exist with id :" + id));
		return ResponseEntity.ok(customer);
	}
	
	// update customer rest api
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updatecustomer(@PathVariable Long id, @RequestBody Customer customerDetails){
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("customer not exist with id :" + id));
		
		customer.setFullName(customerDetails.getFullName());
		customer.setPhoneNumber(customerDetails.getPhoneNumber());
		customer.setPhone2(customerDetails.getPhone2());
		customer.setEmail(customerDetails.getEmail());
		customer.setAddress(customerDetails.getAddress());
		customer.setAddress2(customerDetails.getAddress2());
		customer.setStatus(customerDetails.getStatus());
		customer.setCity(customerDetails.getCity());
		customer.setDistrict(customerDetails.getDistrict());
	  
	    
		
		Customer updatedcustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedcustomer);
	}
	
	
	
	// delete customer rest api
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Map<String, Boolean>> deletecustomer(@PathVariable Long id){
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("customer not exist with id :" + id));
		
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}

