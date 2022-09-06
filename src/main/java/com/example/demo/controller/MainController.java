package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Shoes;
import com.example.demo.entity.User;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.repo.UserRepository;

@Controller
public class MainController {
	
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/user")
	public String user(Model model) {
		model.addAttribute("category", categoryRepo.findAll());
		return "user";
	}
	
	@GetMapping("/admin")
	public String demoadmin(Model model) {
		model.addAttribute("category", categoryRepo.findAll());
		return "admin";
	}
	
	@GetMapping("/admin/users")
	public String getUsers(Model model){
//		log.info("before the shoes");
//		List<Shoes> shoes = new ArrayList<Shoes>(shoeDAO.getUsers());
//		System.out.println(shoeRepo.findAll());
//		log.info("after the shoes");
		model.addAttribute("users", userRepo.findAll());
		return "users";
	}
	
//	@RequestMapping(path = {"/","/search"})
//	public String getUsersByFirstName( String firstName ,Model model, User user){
//		User u = userRepo.findByFirstName(firstName);
//		model.addAttribute("users", u);
//		model.addAttribute("firstName", firstName);
////		if(u.isPresent()) {
////			model.addAttribute("shoe", s.get());
////		}
//		return "admin";
//	}
	
	
	@RequestMapping("/getUser")
	public ModelAndView getCategory(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		
		String res = request.getParameter("user");
		List<User> u = userRepo.findByFirstName(res);
		mv.addObject("user", u);
		mv.setViewName("usersByFirstName");
		return mv;
	}
	
	// ----------------------------- updating a user ------------------------------------------
		@GetMapping("/admin/editPass/{id}")
		public String userUpdateForm(@PathVariable("id") long id, Model model) {
		    User user = userRepo.findById(id)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid shoe Id:" + id));
		    
		    model.addAttribute("user", user);
		    return "userUpdateForm";
		}
		
		@PostMapping("/admin/updatePass/{id}")
		public String updateShoe(@PathVariable("id") long id, User user, Model model) {
		    
		    userRepo.save(user);
		    
		    return "redirect:/admin/users";
		}
}
