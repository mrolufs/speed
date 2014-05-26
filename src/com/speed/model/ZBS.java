package com.speed.model;

public class ZBS extends Product{
	
	private String description = "ZBS";
	
	public ZBS(){
		
	}

	public ZBS(Product product){
		super(product);
		this.setDescription(product.getDescription() + description);
	}

}
