package com.speed.model;

public class F35 extends Product{
	
	private String description = "F35 Armrest";

	public F35(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}
}
