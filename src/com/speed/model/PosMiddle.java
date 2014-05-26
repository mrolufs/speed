package com.speed.model;

public class PosMiddle extends Product{
	
	private String description = "Middle Position";
	
	public PosMiddle(){
		
	}

	public PosMiddle(Product product){
		super(product);
		this.setDescription(product.getDescription() + description);
	}

}
