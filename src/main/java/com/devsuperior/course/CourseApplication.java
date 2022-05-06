package com.devsuperior.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

}
/* 
 
Configuração do application.properties
 #Configura o nome do perfil como test
spring.profiles.active=test
#Vai explicar mais para frente
spring.jpa.open-in-view=true
  
 Configuração do application-test.properties
 #String da conexão com o banco de dados: testdb, vai ser um BD em memória, do Tipo h2
spring.datasource.url=jdbc:h2:mem:testdb
#Nome do usuario
spring.datasource.username=sa
#Senha do usuario
spring.datasource.password=
#Habilita o console do h2
spring.h2.console.enabled=true
#O caminho para acessar o administrador do h2 no navegador
spring.h2.console.path=/h2-console
#É para mostrar no log da aplicação o comando sql que foi executado pelo JPA
spring.jpa.show-sql=true
#Aqui formata o sql para ficar mais legivel
spring.jpa.properties.hibernate.format_sql=true
*/