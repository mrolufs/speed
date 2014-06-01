package com.speed.model;

public class Flipped extends Product{
	
	private String description = "Brackets Flipped";

	public Flipped(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
