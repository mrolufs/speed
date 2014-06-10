package com.speed.model;

public class T4Carbon extends Product{
	
	private String description = "T4+ Carbon";

	public T4Carbon(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
