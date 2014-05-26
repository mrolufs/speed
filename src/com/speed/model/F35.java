package com.speed.model;

public class F35 extends Product{
	
	private String description = "F35";
	
	public F35(){
		this.setDescription("F35");
	}

	public F35(Product product){
		super(product);
		this.setDescription(product.getDescription() + description);
	}
}
