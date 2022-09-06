package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	@CreationTimestamp
    private LocalDate purchaseDate;
	
	private String name;
	private String email;
	private int price;
	private String category;
	private String shipping;
	
	
//	@ManyToOne(cascade = CascadeType.MERGE)
//	private User user;
	
//	@ManyToOne(cascade = CascadeType.MERGE)
//	private Shoes shoe;
}
