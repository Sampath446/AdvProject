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
import com.inventorymanagementsystem.model.Item;
import com.inventorymanagementsystem.repository.ItemRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ItemController {


	@Autowired
	private ItemRepository itemRepository;
	
	// get all Item
	@GetMapping("/items")
	public List<Item> getAllItem(){
		return itemRepository.findAll();
	}		
	
	// create Item rest api
	@PostMapping("/items")
	public Item createItem(@RequestBody Item Item) {
		return itemRepository.save(Item);
	}
	
	// get Item by id rest api
	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id) {
		Item Item = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));
		return ResponseEntity.ok(Item);
	}
	
	// update Item rest api
	
	@PutMapping("/items/{id}")
	public ResponseEntity<Item> ItemItem(@PathVariable Long id, @RequestBody Item ItemDetails){
		Item Item = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));
		
		Item.setItemName(ItemDetails.getItemName());
		Item.setQuantity(ItemDetails.getQuantity());
		Item.setItemNumber(ItemDetails.getItemNumber());
		Item.setDescription(ItemDetails.getDescription());
		Item.setProductId(ItemDetails.getProductId());
		Item.setTotalPrice(ItemDetails.getTotalPrice());
		
		Item updatedItem = itemRepository.save(Item);
		return ResponseEntity.ok(updatedItem);
	}
}

	
	
