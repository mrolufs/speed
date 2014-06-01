package com.speed.model;

public class ZBS extends Product{
	
	private String description = "ZBS";

	public ZBS(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
