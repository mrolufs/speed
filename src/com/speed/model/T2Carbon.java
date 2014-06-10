package com.speed.model;

public class T2Carbon extends Product{
	
	private String description = "T2+ Carbon";

	public T2Carbon(Product product){
		super(product);
	}

	public String getDescription(){
		return this.description;
	}

}
