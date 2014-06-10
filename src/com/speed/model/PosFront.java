package com.speed.model;

public class PosFront extends Product{
	
	private String description = "Front";

	public PosFront(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
