package com.speed.model;

public class T2Carbon extends Product{
	
	//private String description = "T1Carbon";
	
	public T2Carbon(){
		//description = description + " T1Carbon";
		this.setDescription("T2Carbon");
	}

	public T2Carbon(Product product){
		
		super(product);
		this.setDescription(product.getDescription() + " T2Carbon");
		
	}

}
