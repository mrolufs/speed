package com.speed.model;

public class PosMiddle extends Product{
	
	private String description = "Middle";

	public PosMiddle(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
