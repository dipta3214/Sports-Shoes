package com.example.demo.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Purchase;

public interface PurchaseRepo extends JpaRepository<Purchase, Integer>{
	@Query("select p from Purchase p where p.category=?1")
	public List<Purchase> findByCategory(String category);
	
	@Query("select p from Purchase p order by p.purchaseDate desc")
	public List<Purchase> findBydateDesc();
	
	@Query("select p from Purchase p where p.email=?1")
	public List<Purchase> findPurchaseByEmail(String email);
}
