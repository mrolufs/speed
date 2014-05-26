package com.profiledesign.speed;

import java.util.ArrayList;

import android.app.Application;

import com.speed.model.Product;

public class AppContext extends Application {
	
	private ArrayList<Product> products;
	private int stack;
	private int reach;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		products = new ArrayList<Product>();
	}
	
	public ArrayList<Product> getProducts(){
		return this.products;
	}
	
	public int getStack(){
		return this.stack;
	}
	
	public void setStack(int stack){
		this.stack = stack;
	}
	
	public int getReach(){
		return this.reach;
	}
	
	public void setReach(int reach){
		this.reach = reach;
	}

}
