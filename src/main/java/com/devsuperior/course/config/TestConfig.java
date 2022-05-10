package com.devsuperior.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devsuperior.course.entities.enums.OrderStatus;
import com.devsuperior.course.entities_models.Category;
import com.devsuperior.course.entities_models.Order;
import com.devsuperior.course.entities_models.Product;
import com.devsuperior.course.entities_models.User;
import com.devsuperior.course.repositories.CategoryRepository;
import com.devsuperior.course.repositories.OrderRepository;
import com.devsuperior.course.repositories.ProductRepository;
import com.devsuperior.course.repositories.UserRepository;

/*Essa é uma classe de configuração para conseguir popular/instancias o banco de dados de test*/

@Configuration // Indica que essa classe é de configuração
@Profile("test") // Linha 1 do application.properties
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		// Construtor da classe Category
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		// Construtor da classe product
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		// Para salvar os métodos construtores em um Arrays
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		//Fazendo associações entre os objetos
		p1.getCategories().add(cat2);//Adicionando o produto p1 na categoria cat2 
		p2.getCategories().add(cat1);//Adicionando o produto p2 na categoria cat1 
		p2.getCategories().add(cat3);//Adicionando o produto p2 na categoria cat3 
		p3.getCategories().add(cat3);//Adicionando o produto p3 na categoria cat3 
		p4.getCategories().add(cat3);//Adicionando o produto p4 na categoria cat3 
		p5.getCategories().add(cat2);//Adicionando o produto p5 na categoria cat2 
		
		//Salvando os produtos com as associações entre os objetos linhas 58 à 64
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		// Construtor da classe User
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		// Construtor da classe Order
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		// Para salvar os métodos construtores em um Arrays
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		

	}

}
