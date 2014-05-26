package com.speed.model;

public class PosRear extends Product{
	
	private String description = "Rear Position";
	
	public PosRear(){
		
	}

	public PosRear(Product product){
		super(product);
		this.setDescription(product.getDescription() + description);
	}

}
