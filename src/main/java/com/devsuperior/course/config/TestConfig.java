package com.devsuperior.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devsuperior.course.entities_models.Order;
import com.devsuperior.course.entities_models.User;
import com.devsuperior.course.repositories.OrderRepository;
import com.devsuperior.course.repositories.UserRepository;

/*Essa é uma classe de configuração para conseguir popular/instancias o banco de dados de test*/

@Configuration //Indica que essa classe é de configuração
@Profile("test") // Linha 1 do application.properties
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	
	@Override
	public void run(String... args) throws Exception {

		//Construtor da classe User
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Construtor da classe Order
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		//Para salvar os métodos construtores em um Arrays
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
}
