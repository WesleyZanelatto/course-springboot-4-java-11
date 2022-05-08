package com.devsuperior.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), 
	PAID(2),			 
	SHIPPED(3),		 
	DELIVERED(4),		 
	CANCELED(5);		 
	
	private int code;
	
	//Método Especial Construtor, mas esse tem que ser do tipo private
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//Criar um Método público para que o code fique acessivel
	public int getCode() {
		return code;
	}
	
	//Criar um Método Static para retornar sem instanciar e converter um valor numérico para o Tipo enumerado
	//Exemplo: caso passamos o numero 1 ele vai retornar WAITING_PAYMENT...
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
	
}
