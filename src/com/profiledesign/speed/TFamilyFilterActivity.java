package com.profiledesign.speed;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.speed.model.Product;
import com.speed.model.T1Carbon;

public class TFamilyFilterActivity extends Activity{
	
	
	static final int RIDING_TYPE_TIME_TRIAL = 0;
	static final int RIDING_TYPE_TRIATHLON = 1;
	static final int TRIATHLON_SHORT_MID_COURSE = 3;
	static final int TRIATHLON_MID_LONG_COURSE = 4;
	
	AppContext appContext;
	
	int reach;
	int stack;
	
	
	int ridingType;
	int triathlonCourse;
	
	boolean isMultiPositional;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_tfamilyfilter);
		
		appContext = (AppContext) getApplicationContext();
		

		Log.i("TFAMILY", "RIDING_TYPE_TRIATHLON, TRIATHLON_SHORT_MID_COURSE " + "NO!!");
		//Case #1
		
		ridingType = RIDING_TYPE_TRIATHLON;
		
		triathlonCourse = TRIATHLON_SHORT_MID_COURSE;
		
		isMultiPositional = false;
		
		tFamilyFilter();
		
		Log.i("TFAMILY", "RIDING_TYPE_TIME_TRIAL " + "YES!!");
		//Case #2
		
		ridingType = RIDING_TYPE_TIME_TRIAL;

		isMultiPositional = true;
		
		tFamilyFilter();
		
		Log.i("TFAMILY", "RIDING_TYPE_TRIATHLON, TRIATHLON_SHORT_MID_COURSE " + "YES!!");
		//Case #3
		
		ridingType = RIDING_TYPE_TRIATHLON;
		
		triathlonCourse = TRIATHLON_SHORT_MID_COURSE;

		isMultiPositional = true;
		
		tFamilyFilter();
		
		
		Log.i("TFAMILY", "RIDING_TYPE_TRIATHLON, TRIATHLON_MID_LONG_COURSE " + "YES!!");
		//Case #4
		
		ridingType = RIDING_TYPE_TRIATHLON;
		
		triathlonCourse = TRIATHLON_MID_LONG_COURSE;

		isMultiPositional = true;
		
		tFamilyFilter();
	}
	
	private ArrayList<String> filteredTs;
	
	
	//logic flow
	private void tFamilyFilter(){
		
		filteredTs = new ArrayList<String>();
		
		//if Type of Riding...
		if(ridingType == RIDING_TYPE_TIME_TRIAL){
			if(isMultiPositional){
				Log.i("TFAMILY", "TimeTrial, MultiPosition = Yes, ---> T2");
				filteredTs.add("T2");
			}else{
				Log.i("TFAMILY", "TimeTrial, MultiPosition = No, ---> T4");
				filteredTs.add("T4");
			}
		}else if(ridingType == RIDING_TYPE_TRIATHLON){
			if(triathlonCourse == TRIATHLON_SHORT_MID_COURSE){
				if(isMultiPositional){
					Log.i("TFAMILY", "Triathlon, Short-Mid Course, MultiPosition = Yes, ---> T1/T2/T3");
					filteredTs.add("T1");
					filteredTs.add("T2");
					filteredTs.add("T3");
				}else{
					Log.i("TFAMILY", "Triathlon, Short-Mid Course, MultiPosition = No, ---> T4");
					filteredTs.add("T4");
				}
			}else if(triathlonCourse == TRIATHLON_MID_LONG_COURSE){
				if(isMultiPositional){
					Log.i("TFAMILY", "Triathlon, Mid-Long Course, MultiPosition = Yes, ---> T1/T3");
					filteredTs.add("T1");
					filteredTs.add("T3");
				}else{
					Log.i("TFAMILY", "Triathlon, Mid-Long Course, MultiPosition = No, ---> T4");
					filteredTs.add("T4");
				}
			}
		}
		
	}
	
	
	public void submitClickHandler(View target){
		
		
		
		
		for(Product product : appContext.getProducts()){
			String productName = "";
			
			productName += product.getDescription();
			
			Log.i("PRODUCTS", " product recursive: " + product.getDescriptionRecursive());
			
//			for(Product prod : product.getProducts()){
//				
//				//Log.i("PRODUCTS", prod.getClass().getCanonicalName());
//				//Log.i("PRODUCTS", prod.getClass().getName());
//				//Log.i("PRODUCTS", prod.getClass().getSimpleName());
//				//Log.i("PRODUCTS", prod.getClass().toString());
//				//Log.i("PRODUCTS", prod.getClass().getEnclosingClass().getName());
//
//				if(prod.getClass().getSimpleName().equals("T1Carbon")){
//					Log.i("PRODUCTS", " yeah: T1Carbon !" );
//				}
//				productName += prod.getDescription();
//			}
			

			Log.i("PRODUCTS", " product: " + productName);
			
		}
		
		
		

//		Evaluate.evaluate(stack, reach);
//		
//
//		Intent intent = new Intent(this, ResultsActivity.class);
//		
//		intent.putExtra("aerobarStack", stack);
//		intent.putExtra("aerobarReach", reach);
//		
//		startActivity(intent);

	}
	
}
