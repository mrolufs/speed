package com.speed.model;

public class T4Carbon extends Product{
	
	//private String description = "T1Carbon";
	
	public T4Carbon(){
		//description = description + " T1Carbon";
		this.setDescription("T4Carbon");
	}

	public T4Carbon(Product product){
		
		super(product);
		this.setDescription(product.getDescription() + " T4Carbon");
		
	}

}
