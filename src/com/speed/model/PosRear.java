package com.speed.model;

public class PosRear extends Product{
	
	private String description = "Rear";

	public PosRear(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
