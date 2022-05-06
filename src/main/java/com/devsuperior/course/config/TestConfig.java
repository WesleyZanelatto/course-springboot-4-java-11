package com.devsuperior.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devsuperior.course.entities_models.User;
import com.devsuperior.course.repositories.UserRepository;

/*Essa é uma classe de configuração para conseguir popular/instancias o banco de dados de test*/

@Configuration //Indica que essa classe é de configuração
@Profile("test") // Linha 1 do application.properties
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Para salvar os métodos em um Array
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
	
}
