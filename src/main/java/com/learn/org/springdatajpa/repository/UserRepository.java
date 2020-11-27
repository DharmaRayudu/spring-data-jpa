package com.learn.org.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.org.springdatajpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByProfession(String profession);
	
	public List<User> findByAge(Integer age);
	
	public long countByAge(Integer age);
	
	public void deleteById(Integer id);
	
	//Multi conditions
	public List<User> findByProfessionAndAge(String profession, Integer age);
	 
	//Ignore case
	public List<User> findByProfessionIgnoreCase(String profession);

	@Query("select u from User u")
	public List<User> getUserData();
	
}
