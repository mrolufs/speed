package com.speed.model;

public class T2Plus extends Product{
	
	private String description = "T2+ Aluminum";

	public T2Plus(Product product){
		
		super(product);
	}
	
	public String getDescription(){
		return this.description;
	}

}
