package com.speed.model;

public class T3Plus extends Product{
	

	private String description = "T3+ Aluminum";

	public T3Plus(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
