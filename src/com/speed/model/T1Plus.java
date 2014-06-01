package com.speed.model;

public class T1Plus extends Product{
	
	private String description = "T1 Plus";

	public T1Plus(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
