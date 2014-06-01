package com.speed.model;

public class T1Carbon extends Product{
	
	private String description = "T1 Carbon";

	public T1Carbon(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
