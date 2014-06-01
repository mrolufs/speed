package com.speed.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
	
	private Product product;
//	private String description = "";
//	//private ArrayList<Product> products;
//	
	public Product(){
		
	}
	
	public Product(Product product){
		this.product = product;
	}
	
	public Product getProduct(){
		return product;
	}

	
	public String getDescription(){
		return null;
		//return this.description;
	}
	
//	public void setDescription(String description){
//		this.description += " " + description;
//	}
//	
//	public String getDescriptionRecursive(){
//		return recursiveDescription(getProduct());
//	}
//	
//	private String recursiveDescription(Product product){
//
//		//description += product.getDescription();
//		
//		String desc = "";
//		
//		if(product.getProduct() != null){
//			desc += product.getDescription();
//			recursiveDescription(product.getProduct());
//			
//			
//		}
//		
//		return desc;
//	}

}
