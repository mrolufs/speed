package com.speed.model;

public class F25 extends Product{
	
	private String description = "F25";
	
	public F25(){
		
	}

	public F25(Product product){
		super(product);
		this.setDescription(product.getDescription() + description);
	}

}
