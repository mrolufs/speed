package com.speed.model;

public class J2 extends Product{
	
	private String description = "J2";
	
	public J2(){
		
	}

	public J2(Product product){
		super(product);
		this.setDescription(product.getDescription() + description);
	}

}
