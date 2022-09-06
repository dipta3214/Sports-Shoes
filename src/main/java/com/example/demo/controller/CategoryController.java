package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Category;
import com.example.demo.entity.Shoes;
import com.example.demo.repo.CategoryRepo;

@Controller
public class CategoryController {

	@Autowired
	CategoryRepo categoryRepo;
	
	// ----------------------------- adding a Category --------------------------------------------
	
		@GetMapping("/admin/createCategoryForm")
	    public String addCategoryForm(Category category) {
	        return "addCategory";
	    }
		
		@PostMapping("/createCategory")
		public String addCategory(Category category, Model model) {
			
			
			categoryRepo.save(category);
			return "redirect:/admin/getAllCategories";
		}
		
		// ----------------------------- Getting all Categories ---------------------------------------
		
		@GetMapping("/admin/getAllCategories")
		public String get(Model model){
			
			model.addAttribute("category", categoryRepo.findAll());
			return "categories";
		}
		
		
		
		
		// ----------------------------- updating a shoe ------------------------------------------
		@GetMapping("/category/edit/{id}")
		public String categoryUpdateForm(@PathVariable("id") int id, Model model) {
		    Category category = categoryRepo.findById(id)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
		    
		    model.addAttribute("category", category);
		    return "categoryUpdateForm";
		}
		
		@PostMapping("/category/update/{id}")
		public String updateCategory(@PathVariable("id") int id, Category category, Model model) {
		    
		        
		    categoryRepo.save(category);
		    return "redirect:/admin/getAllCategories";
		}
		
		// ----------------------------- Deleting a shoe ------------------------------------------
		
		
		@GetMapping("/category/delete/{id}")
		public String deleteCategory(@PathVariable("id") int id, Model model) {
			Category category = categoryRepo.findById(id)
				      .orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
			categoryRepo.delete(category);
		    return "redirect:/admin/getAllCategories";
		}
}
