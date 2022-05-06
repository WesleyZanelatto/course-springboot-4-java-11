package com.devsuperior.course.resources_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.course.entities_models.User;
import com.devsuperior.course.services.UserService;

//6º passo: Criar a Classe UserResource e suas anotações
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	//ResponseEntity, utilizado para retornar respostas de requisições web, nesse caso o Tipo de resposta vai ser o User "Model"
	@GetMapping // Vai retornar a requisição do tipo GET para retornar todos usuarios
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//EndPoint para buscar o usuario por id, e retornar apenas o usuario correspondente ao id
	@GetMapping(value = "/{id}")
	//@PathVariable é utilizado para esse método entender que o Long id do método é o mesmo do value = "/{id" do @ GetMapping
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
