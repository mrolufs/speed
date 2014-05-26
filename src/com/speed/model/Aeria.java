package com.speed.model;

public class Aeria extends Product{
	
	private String description = "Aeria";
	
	public Aeria(){
		
	}

	public Aeria(Product product){
		super(product);
		this.setDescription(product.getDescription() + description);
	}

}
