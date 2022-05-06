package com.devsuperior.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.course.entities_models.User;

//@Repository // Nesse caso essa anotação é opcional, pois essa interface esta extendendo do JpaRepository
public interface UserRepository extends JpaRepository<User, Long>{

	
	
}
