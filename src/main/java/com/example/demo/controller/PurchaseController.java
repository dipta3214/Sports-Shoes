package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Purchase;
import com.example.demo.entity.Shoes;
import com.example.demo.repo.PurchaseRepo;
import com.example.demo.repo.ShoeRepo;

@Controller
public class PurchaseController {
	
	@Autowired
	PurchaseRepo purchaseRepo;
	
	@Autowired
	ShoeRepo shoeRepo;
	
	

	
	// ----------------------------- adding a purchase --------------------------------------------
	
		@GetMapping("/admin/createPurchaseGet/{id}")
	    public String addPurchaseForm(@PathVariable("id") int id ,Purchase purchase, Shoes shoe, Model model) {
			Optional<Shoes> s = shoeRepo.findById(id);
			if(s.isPresent()) {
				model.addAttribute("shoe", s.get());
			}
	        return "addPurchase";
	    }
		
		@PostMapping("/createPurchase")
		public String addShoe(Purchase purchase, Model model) {
			
			
			purchaseRepo.save(purchase);
			return "redirect:/admin/getAllPurchases";
		}
		
		// ----------------------------- Getting all purchases ---------------------------------------
		
		@GetMapping("/admin/getAllPurchases")
		public String get(Model model){
			
			model.addAttribute("purchases", purchaseRepo.findAll());
			return "purchases";
		}
		
		// ----------------------------- Get a purchase by category -----------------------------------
		
		@GetMapping("/admin/getPurchaseByCategory/{category}")
		public String findbycategory(@PathVariable String category, Model model) {
			model.addAttribute("purchases", purchaseRepo.findByCategory(category));
			return "purchaseCategory";
		}
		
		// ----------------------------- Get the latest purchases -----------------------------------
		
		@GetMapping("/admin/getLatestPurchases")
		public String findbyDate(Model model) {
			model.addAttribute("purchases", purchaseRepo.findBydateDesc());
			return "latestPurchases";
		}

		
		// ----------------------------- Deleting a purchase ------------------------------------------
		
		
		@GetMapping("/admin/purchase/{id}")
		public String deletePurchase(@PathVariable("id") int id, Model model) {
			Purchase purchase = purchaseRepo.findById(id)
				      .orElseThrow(() -> new IllegalArgumentException("Invalid purchase Id:" + id));
			purchaseRepo.delete(purchase);
		    return "redirect:/admin/getAllPurchases";
		}
		
		// ----------------------------- adding a purchase for user--------------------------------------------
		
			
		@GetMapping("/user/purchase/{id}")
	    public String shoePurchaseUser(@PathVariable("id") int id ,Purchase purchase, Shoes shoe, Model model) {
			Optional<Shoes> s = shoeRepo.findById(id);
			if(s.isPresent()) {
				model.addAttribute("shoe", s.get());
			}
	        return "addPurchaseUser";
	    }
		
		@PostMapping("/addPurchase")
		public String shoeUser(Purchase purchase, Model model) {
			
			
			purchaseRepo.save(purchase);
			return "redirect:/user/getAllShoes";
		}
		
		
		//------------------------------- purchases for user -----------------------------------------------
		@GetMapping("/user/getPurchaseByCategory/{email}")
		public String findbyEmail(@PathVariable String email, Model model) {
			model.addAttribute("purchases", purchaseRepo.findPurchaseByEmail(email));
			return "userPurchases";
		}
}
