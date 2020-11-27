package com.learn.org.springdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.learn.org.springdatajpa.model.User;
import com.learn.org.springdatajpa.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> saveUser(List<User> entities) {
		return userRepository.saveAll(entities);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public List<User> getProfessionDetails(String profession) {
		return userRepository.findByProfession(profession);
	}

	public List<User> getAgeDetails(Integer age) {

		return userRepository.findByAge(age);

	}

	public long countByage(Integer age) {
		return userRepository.countByAge(age);
	}
	
	public void deleteUser(Integer id) {
		 userRepository.deleteById(id);
	}
	
	public List<User> getData(String profession, Integer age){
		return userRepository.findByProfessionAndAge(profession, age);
	}
	
	public List<User> getProfessionData(String profession){
		return userRepository.findByProfessionIgnoreCase(profession);
	}
	
	public List<User> sortUserData(){
		Sort sort = Sort.by(
					Sort.Order.asc("age"),
					Sort.Order.asc("name")
				);
		return userRepository.findAll(sort);
	}
	
	@SuppressWarnings("unchecked")
	public Page<User> getPaginatedUserData(int limit, int offset){
		//Pageable.unpaged().
		return  userRepository.findAll(PageRequest.of(limit, offset));
	}
	
	//Custome query.
	
	public List<User> getUserCustomeData(){
		return userRepository.getUserData();
	}

}
