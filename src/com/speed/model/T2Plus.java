package com.speed.model;

public class T2Plus extends Product{
	
	private String description = "T2 Plus";

	public T2Plus(Product product){
		
		super(product);
	}
	
	public String getDescription(){
		return this.description;
	}

}
