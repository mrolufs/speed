package com.speed.model;

public class J2 extends Product{
	
	private String description = "J2 Bracket";

	public J2(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
