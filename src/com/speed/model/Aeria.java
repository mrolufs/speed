package com.speed.model;

public class Aeria extends Product{
	
	private String description = "Aeria";

	public Aeria(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}
}
