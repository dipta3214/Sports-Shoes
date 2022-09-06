package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Shoes;
import com.example.demo.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
	
	@Query("select u from User u where u.email=?1")
	public List<User> findByEmails(String email);
	
	@Query("select u from User u where u.firstName=?1")
	public List<User> findByFirstName(String firstName);
}

