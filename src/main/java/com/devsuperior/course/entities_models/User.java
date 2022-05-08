package com.devsuperior.course.entities_models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*5º passo: Serializable utilizado quando queremos que objetos sejam transformados em cadeias de bytes. Ex: para que o objeto trafegue na rede,
 *  possa ser gravado em arquivo.
 */

@Entity //Essa anotação foi habilitada pelo JPA
@Table(name = "tb_user")
public class User implements Serializable{ 
	private static final long serialVersionUID = 1L;

//1º passo: Criar os atributos da Entidade/Tabela
@Id // Indicando para essa entidade que esse campo é a chave primaria
@GeneratedValue(strategy = GenerationType.IDENTITY)//gera valor automático para o id
private Long id;

private String name;

private String email;

private String phone;

private String password;

//As collections precisam sempre serem instanciadas e criar apenas o Getters e "nunca" Setters
@JsonIgnore // Para evitar que fique buscando a mesma coisa repetidamente por causa da mão dupla de @OneToMany e @ManyToOne
@OneToMany(mappedBy = "client") // Para criar o relacionamento de um para muito, ou seja, de Users(1) para Order(*)
private List<Order> orders = new ArrayList<>(); //Criando associações entre as tabelas User(1) com a Tabela Order(*), nesse caso 1 Usuario tem varios pedidos

//2º passo: Criar os Métodos especiais Construtores
public User() {
	
}

public User(Long id, String name, String email, String phone, String password)
{
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.password = password;
}

//3º passo: Criar os Métodos Getters e Setters
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public List<Order> getOrders() {
	return orders;
}

//4º passo: Criar o HashCode e Equals. Utilizado para comparar dois objetos, nesse caso vamos utilizar apenas id

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}











}
