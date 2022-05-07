package com.devsuperior.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.course.entities_models.User;
import com.devsuperior.course.repositories.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	//Busca todos Usuarios, repassando a chamada para o repository.findAll
	public List<User> findAll(){
		return repository.findAll();
	}
	
	//Busca o Usuario pelo id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();//get() vai retornar o tipo de obj que esta no Optional, nesse caso User
	}
	
}
