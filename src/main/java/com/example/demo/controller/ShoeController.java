package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ShoeDAO;
import com.example.demo.entity.Shoes;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.repo.ShoeRepo;

@Controller
public class ShoeController {
	@Autowired
	ShoeRepo shoeRepo;
	
	@Autowired
	ShoeDAO shoeDAO;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	// ----------------------------- adding a shoe --------------------------------------------
	
	@GetMapping("/admin/createShoeGet")
    public String addShoeForm(Shoes shoes, Model model) {
		model.addAttribute("category", categoryRepo.findAll());
        return "addShoe";
    }
	
	@PostMapping("/createShoe")
	public String addShoe(Shoes shoes, Model model) {
		
		
		shoeRepo.save(shoes);
		return "redirect:/admin/getAllShoes";
	}
	
	
	// ----------------------------- Getting all shoes ---------------------------------------
	
	@GetMapping("/admin/getAllShoes")
	public String get(Model model){
		


		model.addAttribute("shoes", shoeRepo.findAll());
		return "shoes";
	}
	
	// ----------------------------- updating a shoe ------------------------------------------
	@GetMapping("/admin/edit/{id}")
	public String shoeUpdateForm(@PathVariable("id") int id, Model model) {
	    Shoes shoe = shoeRepo.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid shoe Id:" + id));
	    model.addAttribute("category", categoryRepo.findAll());
	    model.addAttribute("shoe", shoe);
	    return "shoeUpdateForm";
	}
	
	@PostMapping("/admin/update/{id}")
	public String updateShoe(@PathVariable("id") int id, Shoes shoes, Model model) {
	    
	        
	    shoeRepo.save(shoes);
	    return "redirect:/admin/getAllShoes";
	}
	
	
	// ----------------------------- Deleting a shoe ------------------------------------------
	
	
	@GetMapping("/admin/delete/{id}")
	public String deleteShoe(@PathVariable("id") int id, Model model) {
		Shoes shoe = shoeRepo.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid shoe Id:" + id));
		shoeRepo.delete(shoe);
	    return "redirect:/admin/getAllShoes";
	}
	
	// ----------------------------- Get a shoe by category -----------------------------------
	
	@GetMapping("/admin/getByCategory/{category}")
	public String findbycategory(@PathVariable String category, Model model) {
		model.addAttribute("shoes", shoeRepo.findByCategory(category));
		return "shoeCategory";
	}
	
	
	// ----------------------------- Getting all shoes for user---------------------------------------
	
		@GetMapping("/user/getAllShoes")
		public String getShoesForUser(Model model){
			


			model.addAttribute("shoes", shoeRepo.findAll());
			return "shoesUser";
		}
		
		
		// ----------------------------- Get a shoe by category -----------------------------------
		
		@GetMapping("/user/getByCategory/{category}")
		public String findbycategoryUser(@PathVariable String category, Model model) {
			model.addAttribute("shoes", shoeRepo.findByCategory(category));
			return "shoeCategoryUser";
		}
	
}
