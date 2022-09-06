package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Shoes;
import com.example.demo.repo.ShoeRepo;


@Service
public class ShoeDAO {
	@Autowired
	ShoeRepo shoeRepo;
	
	// insert
	public Shoes insert(Shoes shoe) {
		return shoeRepo.save(shoe);
	}
	
	// get the shoes
	public List<Shoes> getUsers(){
		return shoeRepo.findAll();
	}
	
	
	// Delete a shoe by id
	public String deleteById(int id) {
		shoeRepo.deleteById(id);
		return "Deleted the product with the id of " + id;
	}
	
	//Update a shoe's attributes
	public Shoes update(int id ,Shoes shoe) {
		Shoes s = shoeRepo.findById(id).orElse(null);
		s.setName(shoe.getName());
		s.setCategory(shoe.getCategory());
		s.setPrice(shoe.getPrice());
		return shoeRepo.save(s);
	}
	
	// Find a user by category
	public List<Shoes> findbyname(String category) {
		return shoeRepo.findByname(category);
	}
}
