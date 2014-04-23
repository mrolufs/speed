package com.speed.model;

import java.io.Serializable;

public class Product implements Serializable {
	
	private Product product;
	private String description = "";
	
	public Product(){
		
	}
	
	public Product(Product product){
		this.product = product;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description += " " + description;
	}

}
