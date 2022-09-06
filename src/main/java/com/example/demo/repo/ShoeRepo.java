package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Shoes;

public interface ShoeRepo extends JpaRepository<Shoes, Integer>{
	@Query("select s from Shoes s where s.category=?1")
	public List<Shoes> findByCategory(String category);
}
