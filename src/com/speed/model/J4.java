package com.speed.model;

public class J4 extends Product{
	
	private String description = "J4";
	
	public J4(){
		
	}

	public J4(Product product){
		super(product);
		this.setDescription(product.getDescription() + description);
	}

}
