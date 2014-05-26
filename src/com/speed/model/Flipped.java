package com.speed.model;

public class Flipped extends Product{
	
	private String description = "Flipped";
	
	public Flipped(){
		
	}

	public Flipped(Product product){
		super(product);
		this.setDescription(product.getDescription() + description);
	}

}
