package com.speed.model;

public class T4Plus extends Product{
	
	private String description = "T4 Plus";

	public T4Plus(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
