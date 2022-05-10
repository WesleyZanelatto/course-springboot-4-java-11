package com.devsuperior.course.entities_models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.devsuperior.course.entities_models.pk.OrderItemPk;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPk id;
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
	}
	
	//Esse método especial construtor não vai entrar o id, mas entrara (Order order) e (Product product)
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);//setOrder da linha 29 da classe OrderItemPk
		id.setProduct(product);//setOrder da linha 35 da classe OrderItemPk
		this.quantity = quantity;
		this.price = price;
	}
	
	//Nos métodos Getters e Setters também não vai entrar o id, mas entrara Order e Product
	
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

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
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
