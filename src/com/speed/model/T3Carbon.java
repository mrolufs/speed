package com.speed.model;

public class T3Carbon extends Product{
	
	//private String description = "T1Carbon";
	
	public T3Carbon(){
		//description = description + " T1Carbon";
		this.setDescription("T3Carbon");
	}

	public T3Carbon(Product product){
		
		super(product);
		
		this.setDescription(product.getDescription() + " T3Carbon");
		
	}

}
