package com.speed.model;

public class F19 extends Product{
	
	private String description = "F19 Armrest";

	public F19(Product product){
		super(product);		
	}
	
	public String getDescription(){
		return this.description;
	}

}
