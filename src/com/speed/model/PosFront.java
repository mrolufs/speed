package com.speed.model;

public class PosFront extends Product{
	
	private String description = "Front Position";
	
	public PosFront(){
		
	}

	public PosFront(Product product){
		super(product);
		this.setDescription(product.getDescription() + description);
	}

}
