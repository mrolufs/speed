package com.speed.model;

public class T3Carbon extends Product{
	
	private String description = "T3+ Carbon";

	public T3Carbon(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
