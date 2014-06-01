package com.profiledesign.speed;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.speed.model.Product;

public class TFamilyFilterActivity extends Activity{
	
	
//	static final int RIDING_TYPE_TIME_TRIAL = 0;
//	static final int RIDING_TYPE_TRIATHLON = 1;
//	static final int TRIATHLON_SHORT_MID_COURSE = 3;
//	static final int TRIATHLON_MID_LONG_COURSE = 4;
	
//	public enum Filter {
//		RIDING_TYPE_TIME_TRIAL,
//		RIDING_TYPE_TRIATHLON,
//		TRIATHLON_SHORT_MID_COURSE,
//		TRIATHLON_MID_LONG_COURSE,
//		MULTIPOSITIONAL_YES,
//		MULTIPOSITIONAL_NO
//		
//	};
		
	private static int RIDING_TYPE_TIME_TRIAL = 0;
	private static int RIDING_TYPE_TRIATHLON = 1;
	private static int TRIATHLON_SHORT_MID_COURSE = 0;
	private static int TRIATHLON_MID_LONG_COURSE = 1;
	private static int MULTIPOSITIONAL_YES = 0;
	private static int MULTIPOSITIONAL_NO = 1;
	
	AppContext appContext;
	
	int reach;
	int stack;
	
	
	int ridingType;
	int triathlonCourse;
	
	int multiPositional;
	
	
	
	private Spinner spinnerTypeOfRiding;
	private Spinner spinnerTypeOfHandPosition;
	private Spinner spinnerTriathlonCourse;
	
	private LinearLayout multiPositionalContainer;
	private LinearLayout triathlonCourseContainer;
	
	private Button buttonSubmit;
	
	final String TYPE_OF_RIDING_ARRAY[] = {"Time Trial", "Triathlon"};
	final String TYPE_OF_HAND_POSITION_ARRAY[] = {"Yes", "No"};
	final String TYPE_OF_TRIATHLON_COURSE_ARRAY[] = {"Short/Mid Course", "Long Course"};
	
	boolean readyTypeOfRiding;
	boolean readyTypeOfTriathlonCourse;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_tfamilyfilter);
		
		spinnerTypeOfRiding = (Spinner) findViewById(R.id.type_of_riding_spinner);
		spinnerTypeOfRiding.setPrompt("Type of riding?");
		ArrayAdapter<String> typeOfRidingAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, TYPE_OF_RIDING_ARRAY);
		typeOfRidingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerTypeOfRiding.setSelected(false);
		spinnerTypeOfRiding.setAdapter(typeOfRidingAdapter);
		
		
		
		spinnerTypeOfRiding.setOnItemSelectedListener(typeOfRidingSelectedListener);
		
		
		multiPositionalContainer = (LinearLayout) findViewById(R.id.type_of_hand_position);
		
		spinnerTypeOfHandPosition = (Spinner) findViewById(R.id.type_of_hand_position_spinner);
		spinnerTypeOfHandPosition.setPrompt("Change positions frequently?");
		ArrayAdapter<String> typeOfHandPositionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, TYPE_OF_HAND_POSITION_ARRAY);
		typeOfHandPositionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerTypeOfHandPosition.setSelected(false);
		spinnerTypeOfHandPosition.setAdapter(typeOfHandPositionAdapter);
		
		spinnerTypeOfHandPosition.setOnItemSelectedListener(typeOfHandPositionSelectedListener);
		
		
		
		triathlonCourseContainer = (LinearLayout) findViewById(R.id.type_of_triathlon_course);
		
		spinnerTriathlonCourse = (Spinner) findViewById(R.id.type_of_triathlon_course_spinner);
		spinnerTriathlonCourse.setPrompt("Type of triathlon course?");
		ArrayAdapter<String> typeOfTriathlonCourseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, TYPE_OF_TRIATHLON_COURSE_ARRAY);
		typeOfTriathlonCourseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerTriathlonCourse.setAdapter(typeOfTriathlonCourseAdapter);
		
		spinnerTriathlonCourse.setOnItemSelectedListener(typeOfTriathlonCoursedSelectedListener);
		
		buttonSubmit = (Button) findViewById(R.id.submit_button);
		
		
		appContext = (AppContext) getApplicationContext();

		Log.i("TFAMILY", "RIDING_TYPE_TRIATHLON, TRIATHLON_SHORT_MID_COURSE " + "NO!!");
		//Case #1
		
//		ridingType = RIDING_TYPE_TRIATHLON;
//		
//		triathlonCourse = TRIATHLON_SHORT_MID_COURSE;
//		
//		multiPositional = MULTIPOSITIONAL_NO;
		
//		tFamilyFilter();
		
//		Log.i("TFAMILY", "RIDING_TYPE_TIME_TRIAL " + "YES!!");
//		//Case #2
//		
//		ridingType = RIDING_TYPE_TIME_TRIAL;
//
//		isMultiPositional = true;
//		
//		tFamilyFilter();
		
//		Log.i("TFAMILY", "RIDING_TYPE_TRIATHLON, TRIATHLON_SHORT_MID_COURSE " + "YES!!");
//		//Case #3
//		
//		ridingType = RIDING_TYPE_TRIATHLON;
//		
//		triathlonCourse = TRIATHLON_SHORT_MID_COURSE;
//
//		isMultiPositional = true;
//		
//		tFamilyFilter();
		
		
//		Log.i("TFAMILY", "RIDING_TYPE_TRIATHLON, TRIATHLON_MID_LONG_COURSE " + "YES!!");
//		//Case #4
//		
//		ridingType = RIDING_TYPE_TRIATHLON;
//		
//		triathlonCourse = TRIATHLON_MID_LONG_COURSE;
//
//		isMultiPositional = true;
//		
//		tempProducts = (ArrayList<Product>) appContext.getProducts().clone();
//		
//		tFamilyFilter();
		
//		reconcileTs();
	}
	
	private ArrayList<String> filteredTs;
	private ArrayList<String> filteredOutTs;
	
	ArrayList<Product> tempProducts;
	
	
	//logic flow
	private void tFamilyFilter(){
		
		filteredTs = new ArrayList<String>();
		filteredOutTs = new ArrayList<String>();
		
		//if Type of Riding...
		if(ridingType == RIDING_TYPE_TIME_TRIAL){
			if(multiPositional == MULTIPOSITIONAL_YES){
				Log.i("TFAMILY", "TimeTrial, MultiPosition = Yes, ---> T2");
				filteredOutTs.add("T1");
				filteredOutTs.add("T3");
				filteredOutTs.add("T4");
				
			}else{
				Log.i("TFAMILY", "TimeTrial, MultiPosition = No, ---> T4");
				filteredTs.add("T4");
				
				filteredOutTs.add("T1");
				filteredOutTs.add("T2");
				filteredOutTs.add("T3");
			}
		}else if(ridingType == RIDING_TYPE_TRIATHLON){
			if(triathlonCourse == TRIATHLON_SHORT_MID_COURSE){
				if(multiPositional == MULTIPOSITIONAL_YES){
					Log.i("TFAMILY", "Triathlon, Short-Mid Course, MultiPosition = Yes, ---> T1/T2/T3");
					filteredTs.add("T1");
					filteredTs.add("T2");
					filteredTs.add("T3");

					filteredOutTs.add("T4");
				}else{
					Log.i("TFAMILY", "Triathlon, Short-Mid Course, MultiPosition = No, ---> T4");
					filteredTs.add("T4");
					
					filteredOutTs.add("T1");
					filteredOutTs.add("T2");
					filteredOutTs.add("T3");

				}
			}else if(triathlonCourse == TRIATHLON_MID_LONG_COURSE){
				if(multiPositional == MULTIPOSITIONAL_YES){
					Log.i("TFAMILY", "Triathlon, Mid-Long Course, MultiPosition = Yes, ---> T1/T3");
					filteredTs.add("T1");
					filteredTs.add("T3");
					
					filteredOutTs.add("T2");
					filteredOutTs.add("T4");
				}else{
					Log.i("TFAMILY", "Triathlon, Mid-Long Course, MultiPosition = No, ---> T4");
					filteredTs.add("T4");
					
					filteredOutTs.add("T1");
					filteredOutTs.add("T2");
					filteredOutTs.add("T3");
				}
			}
		}
		
	}
	
	
	private void reconcileTs(){
		
		Log.i("TFAMILY", "size before: " + appContext.getProducts().size());
		
		Iterator<Product> i = appContext.getProducts().iterator();

		Product product;
		while(i.hasNext()) {
		    product = i.next();
		    
		    for(String t : filteredOutTs){
			    if(product.getDescription().contains(t)){
			          i.remove();
			          break;
			    }
		    }

		}
		
		Log.i("TFAMILY", "size after: " + appContext.getProducts().size());
		
		
	}
	
	public void submitClickHandler(View target){
		
		
		ridingType = (Integer) spinnerTypeOfRiding.getSelectedItemPosition();
		multiPositional = (Integer) spinnerTypeOfHandPosition.getSelectedItemPosition();
		if(triathlonCourseContainer.getVisibility() == View.VISIBLE){
			triathlonCourse = (Integer) spinnerTriathlonCourse.getSelectedItemPosition();
		}
		
		tFamilyFilter();
		reconcileTs();
		
		Intent intent = new Intent(this, ResultsActivity.class);

		startActivity(intent);
		
		Log.i("RIDINGTYPE", "type: " + ridingType);
		
//		for(Product product : appContext.getProducts()){
//			//String productName = "";
//			
//			//productName += product.getDescription();
//			
//			//Log.i("PRODUCTS", " product recursive: " + product.getDescriptionRecursive());
//			
////			for(Product prod : product.getProducts()){
////				
////				//Log.i("PRODUCTS", prod.getClass().getCanonicalName());
////				//Log.i("PRODUCTS", prod.getClass().getName());
////				//Log.i("PRODUCTS", prod.getClass().getSimpleName());
////				//Log.i("PRODUCTS", prod.getClass().toString());
////				//Log.i("PRODUCTS", prod.getClass().getEnclosingClass().getName());
////
////				if(prod.getClass().getSimpleName().equals("T1Carbon")){
////					Log.i("PRODUCTS", " yeah: T1Carbon !" );
////				}
////				productName += prod.getDescription();
////			}
//			
//
//			Log.i("PRODUCTS", " product: " +  product.getDescription());
//			
//		}
		
		
		

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
	
	private OnItemSelectedListener typeOfRidingSelectedListener = new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int selectedItem,
				long arg3) {
			
				
			
				if(readyTypeOfRiding){
				
					if(selectedItem == RIDING_TYPE_TRIATHLON){
						triathlonCourseContainer.setVisibility(View.VISIBLE);
					}else if (selectedItem == RIDING_TYPE_TIME_TRIAL){
						triathlonCourseContainer.setVisibility(View.GONE);
						multiPositionalContainer.setVisibility(View.VISIBLE);
					}
				}
			
				readyTypeOfRiding = true;
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	
	private OnItemSelectedListener typeOfTriathlonCoursedSelectedListener = new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int selectedItem,
				long arg3) {
			
				if(readyTypeOfTriathlonCourse){
			
					multiPositionalContainer.setVisibility(View.VISIBLE);
				}
				
				readyTypeOfTriathlonCourse = true;
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	private OnItemSelectedListener typeOfHandPositionSelectedListener = new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int selectedItem,
				long arg3) {
			
				buttonSubmit.setVisibility(View.VISIBLE);
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	
	
}
