package com.learn.org.springdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.org.springdatajpa.model.User;
import com.learn.org.springdatajpa.service.UserService;

@RestController
@RequestMapping("/users/data")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public List<User> addUserData(@RequestBody List<User> entity) {
		return userService.saveUser(entity);
	}

	@GetMapping
	public List<User> getUserdata(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/proffession/{profession}")
	public List<User> getAllProfessionData(@PathVariable String profession){
		return userService.getProfessionDetails(profession);
	}
	
	@GetMapping("/ageData/{age}")
	public List<User> getAgeDetails(@PathVariable Integer age){
		return userService.getAgeDetails(age);
	}
	
	@GetMapping("/countAge/{age}")
	public String countByAge(@PathVariable Integer age) {
		long count =  userService.countByage(age);
		
		return "Total number of employees: "+age;
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return "The user is deleted by id: "+ id;
	}
	
	@GetMapping("/getByProfessionAndAge/{profession}/{age}")
	public List<User> getData(@PathVariable String profession, @PathVariable Integer age){
		return userService.getData(profession, age);
	}
	
	@GetMapping("professionIgnore/{profession}")
	public  List<User> getProfessionData(@PathVariable String profession) {
		return userService.getProfessionData(profession);
	}
	
	@GetMapping("/sortData")
	public List<User> getSortData(){
		return userService.sortUserData();
	}
	
	@GetMapping("/paginationData")
	public Page<User> getPaginationData(@RequestParam int limit, @RequestParam int offset){
		return userService.getPaginatedUserData(limit, offset);
	}
	
	@GetMapping("/customeQuery")
	public List<User> getAllData(){
		return userService.getUserCustomeData();
	}
	
	
}
