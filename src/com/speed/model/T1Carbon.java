package com.speed.model;

public class T1Carbon extends Product{
	
	//private String description = "T1Carbon";
	
	public T1Carbon(){
		//description = description + " T1Carbon";
		this.setDescription("T1Carbon");
	}

	public T1Carbon(Product product){
		
		super(product);
		this.setDescription(product.getDescription() + " T1Carbon");
		
	}

}
