package com.devsuperior.course.resources_controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.course.entities_models.User;

//6º passo: Criar a Classe UserResource e suas anotações
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	//ResponseEntity, utilizado para retornar respostas de requisições web, nesse caso o Tipo de resposta vai ser o User "Model"
	@GetMapping // Vai retornar a requisição do tipo GET
	public ResponseEntity<User> findAll(){
		User u = new User(1L,"Maria","maria@gmail.com","11965210815","12345");
		return ResponseEntity.ok().body(u);
	}
	
}
