package com.speed.model;

public class PosFront extends Product{
	
	private String description = "Front Position";

	public PosFront(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
