package com.profiledesign.speed;

import java.util.ArrayList;

import com.speed.model.Product;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	AppContext appContext;
	
	int bikeStack = 0;
	int bikeReach = 0;
	int fitStack = 0;
	int fitReach = 0;
	int stemAngle = 0;
	float spacers = 0;
	int headset = 0;
	int stemLength = 0;//80 to 130 with intervals of 10
	
	int dStack;//fit stack - bike stack;
	int dReach;//fit reach - bike reach;
	
	double stemStack = 0;//sin(stem angle + 17) * (stem length + 18.72)
	double stemReach = 0;//Math.cos(STEM_ANGLE + STEM_ANGLE_ADDITIVE) * (STEM_LENGTH);
	
//	final int STEM_ANGLE = 6;
//	final int SPACERS = 0;
	final int STEM_ANGLE_ADDITIVE = 17;
	final double STEM_LENGTH_ADDITIVE = 18.72;
	final int SPACERS_ADDITIVE = 20;
	final Integer HEADSET_CAP_ARRAY[] = {0, 5, 10, 15, 20};
	final Float SPACERS_ARRAY[] = {0f, 2.5f, 5f, 7.5f, 10f, 12.5f, 15f, 17.5f, 20f, 22.5f, 25f, 27.5f, 30f, 32.5f, 35f, 37.5f, 40f};
	final Integer STEM_LENGTH_ARRAY[] = {60, 70, 80, 90, 100, 110, 120, 130};
	final Integer STEM_ANGLE_ARRAY[] = { -25, -17, -12, -10, -7, -6, 0, 6, 7, 10, 12, 17, 25};
	
	double aerobarStack = 0;//dStack - (stemStack + (cos(17) * (spacers + 20)))
	double aerobarReach = 0;//dReach - (stemReach - (sin(17) * (spacers + 20)))
	
	private Spinner spinnerStemLength;
	
	private Spinner spinnerStemAngle;
	
	private Spinner spinnerSpacers;
	
	private Spinner spinnerHeadsetCap;
	
	Dialog npBikeStackDialog;
	Dialog npBikeReachDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
		
		
		appContext = ((AppContext) getApplicationContext());
		
		((EditText) findViewById(R.id.bike_frame_stack_edit)).setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(((EditText)v).getText().length() == 3){
					((EditText) findViewById(R.id.bike_frame_reach_edit)).requestFocus();
				}
				return false;
			}
		});
		
		((EditText) findViewById(R.id.bike_frame_reach_edit)).setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(((EditText)v).getText().length() == 3){
					((EditText) findViewById(R.id.fit_stack_edit)).requestFocus();
				}
				return false;
			}
		});
		
		((EditText) findViewById(R.id.fit_stack_edit)).setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(((EditText)v).getText().length() == 3){
					((EditText) findViewById(R.id.fit_reach_edit)).requestFocus();
				}
				return false;
			}
		});
		
		((EditText) findViewById(R.id.fit_reach_edit)).setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(((EditText)v).getText().length() == 3){
					InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
					//imm.toggleSoftInput (InputMethodManager.SHOW_FORCED, InputMethodManager.RESULT_HIDDEN);
				}
				return false;
			}
		});		
		
		
		
		spinnerStemLength = (Spinner) findViewById(R.id.stem_length_spinner);
		spinnerStemLength.setPrompt("Stem Length");
		ArrayAdapter<Integer> arrayLengthAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, STEM_LENGTH_ARRAY);
		arrayLengthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerStemLength.setAdapter(arrayLengthAdapter);
		
		spinnerStemAngle = (Spinner) findViewById(R.id.stem_angle_spinner);
		spinnerStemAngle.setPrompt("Stem Angle");
		ArrayAdapter<Integer> arrayAngleAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, STEM_ANGLE_ARRAY);
		arrayAngleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerStemAngle.setAdapter(arrayAngleAdapter);
		spinnerStemAngle.setSelection(6);
		
		spinnerSpacers = (Spinner) findViewById(R.id.spacers_spinner);
		spinnerSpacers.setPrompt("Spacers in mm");
		ArrayAdapter<Float> arraySpacersAdapter = new ArrayAdapter<Float>(this, android.R.layout.simple_spinner_item, SPACERS_ARRAY);
		arraySpacersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerSpacers.setAdapter(arraySpacersAdapter);
		
		spinnerHeadsetCap = (Spinner) findViewById(R.id.headset_spinner);
		spinnerHeadsetCap.setPrompt("Headset Cap in mm");
		ArrayAdapter<Integer> arrayHeadsetAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, HEADSET_CAP_ARRAY);
		arrayHeadsetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerHeadsetCap.setAdapter(arrayHeadsetAdapter);
//		renderBikeStackPicker();
//		renderBikeReachPicker();
		
		/*
		 
		 
		 
		 ZBS Series

Bike Stack: 600

Bike Reach: 407

Armrest Stack: 700

Armrest Reach: 420

Stem Angle: 6

Stem Length: 100

Spacers: 0

Headset Cap: 0

 

T+ Aluminum Series

Bike Stack: 590

Bike Reach: 405

Armrest Stack: 720

Armrest Reach: 410

Stem Angle: -10

Stem Length: 100

Spacers: 5

Headset Cap: 10

 

T+ Carbon Series

Bike Stack: 545

Bike Reach: 380

Armrest Stack: 690

Armrest Reach: 395

Stem Angle: 17

Stem Length: 90

Spacers: 10

Headset Cap: 5

 

T+ Carbon Series and Aeria

Bike Frame Stack: 545

Bike Frame Reach: 405

Armrest Stack: 665

Armrest Reach: 455

Stem Angle: -17

Stem Length: 100

Spacers: 10

Headset Cap: 5
		 
		 */
	
	}
	
	public void showBikeStackPicker(View target){
		
		npBikeStackDialog.show();
	
	}
	
	public void showBikeReachPicker(View target){
		
		npBikeReachDialog.show();
	
	}
	
	public void renderBikeStackPicker(){
		
		npBikeStackDialog = new Dialog(this);
		
		npBikeStackDialog.setTitle("Bike Frame Stack");
		
		
		
		String[] nums = new String[251];
		 
		for(int i=0; i<nums.length; i++)
		   nums[i] = Integer.toString(i + 450);
		
		final NumberPicker np = new NumberPicker(this);//(NumberPicker) findViewById(R.id.np_bike_stack);
		np.setMaxValue(700);
		np.setMinValue(450);
		np.setWrapSelectorWheel(false);
		np.setDisplayedValues(nums);
		np.setAlpha(0.9f);
		
		npBikeStackDialog.setContentView(np);
		
		npBikeStackDialog.setOnDismissListener(new OnDismissListener(){

			@Override
			public void onDismiss(DialogInterface dialog) {
				((EditText) findViewById(R.id.bike_frame_stack_edit)).setText(String.valueOf(np.getValue()));
				
			}});
		


	}
	
	public void renderBikeReachPicker(){
		
		
		npBikeReachDialog = new Dialog(this);
		
		npBikeReachDialog.setTitle("Bike Frame Reach");
		
		
		
		String[] nums = new String[201];
		 
		for(int i=0; i<nums.length; i++)
		   nums[i] = Integer.toString(i + 300);
		
		final NumberPicker np = new NumberPicker(this);//(NumberPicker) findViewById(R.id.np_bike_stack);
		np.setMaxValue(500);
		np.setMinValue(300);
		np.setWrapSelectorWheel(false);
		np.setDisplayedValues(nums);
		np.setAlpha(0.9f);
		
		npBikeReachDialog.setContentView(np);
		
		npBikeReachDialog.setOnDismissListener(new OnDismissListener(){

			@Override
			public void onDismiss(DialogInterface dialog) {
				((EditText) findViewById(R.id.bike_frame_reach_edit)).setText(String.valueOf(np.getValue()));
				
			}});

	}
	
//	Bike Frame Stack: every number between 450 � 700
//
//    Bike Frame Reach: every number between 300 � 500
//
//    Armrest Stack: every number between 400 � 900
//
//    Armrest Reach: every number between 200 - 600

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
	
	public void submitClickHandler(View target){
		Results results = calculate();
		
		
		
		if(results != null){
			
			ArrayList<Product> products = appContext.getProducts();
			products.clear();
			
			appContext.setStack(results.getAerobarStack());
			appContext.setReach(results.getAerobarReach());
			
			Evaluate evaluator = new Evaluate(this);
			
			evaluator.evaluate(results.getAerobarStack(), results.getAerobarReach());
			
			if(Evaluate.getTFamily().size() > 2){
				Intent intent = new Intent(this, TFamilyFilterActivity.class);

				startActivity(intent);
			}else{
				Intent intent = new Intent(this, ResultsActivity.class);

				startActivity(intent);
			}
		

		}
	}
	
	private Results calculate(){
		

		
		//get form values
		
		try{
//			bikeStack = Integer.parseInt(((EditText) findViewById(R.id.bike_frame_stack_edit)).getText().toString());
//			bikeReach = Integer.parseInt(((EditText) findViewById(R.id.bike_frame_reach_edit)).getText().toString());
//			fitStack = Integer.parseInt(((EditText) findViewById(R.id.fit_stack_edit)).getText().toString());
//			fitReach = Integer.parseInt(((EditText) findViewById(R.id.fit_reach_edit)).getText().toString());
//			stemAngle = (Integer) spinnerStemAngle.getSelectedItem();//Integer.parseInt(((EditText) findViewById(R.id.stem_angle_edit)).getText().toString());
//			spacers = (Float) spinnerSpacers.getSelectedItem();//Integer.parseInt(((EditText) findViewById(R.id.spacers_edit)).getText().toString());
//			stemLength = (Integer) spinnerStemLength.getSelectedItem();
//			headset = (Integer) spinnerHeadsetCap.getSelectedItem();
			
			/*  ZBS Series */
			
			
//			bikeStack = 600;//Integer.parseInt(((EditText) findViewById(R.id.bike_frame_stack_edit)).getText().toString());
//			bikeReach = 407;//Integer.parseInt(((EditText) findViewById(R.id.bike_frame_reach_edit)).getText().toString());
//			fitStack = 700;//Integer.parseInt(((EditText) findViewById(R.id.fit_stack_edit)).getText().toString());
//			fitReach = 420;//Integer.parseInt(((EditText) findViewById(R.id.fit_reach_edit)).getText().toString());
//			stemAngle = 6;//(Integer) spinnerStemAngle.getSelectedItem();//Integer.parseInt(((EditText) findViewById(R.id.stem_angle_edit)).getText().toString());
//			spacers = 0;//Integer.parseInt(((EditText) findViewById(R.id.spacers_edit)).getText().toString());
//			stemLength = 100;//(Integer) spinnerStemLength.getSelectedItem();
//			headset = 0;
			
			/* T+ Aluminum Series */

			
//			bikeStack = 590;//Integer.parseInt(((EditText) findViewById(R.id.bike_frame_stack_edit)).getText().toString());
//			bikeReach = 405;//Integer.parseInt(((EditText) findViewById(R.id.bike_frame_reach_edit)).getText().toString());
//			fitStack = 720;//Integer.parseInt(((EditText) findViewById(R.id.fit_stack_edit)).getText().toString());
//			fitReach = 410;//Integer.parseInt(((EditText) findViewById(R.id.fit_reach_edit)).getText().toString());
//			stemAngle = -10;//(Integer) spinnerStemAngle.getSelectedItem();//Integer.parseInt(((EditText) findViewById(R.id.stem_angle_edit)).getText().toString());
//			spacers = 5;//Integer.parseInt(((EditText) findViewById(R.id.spacers_edit)).getText().toString());
//			stemLength = 100;//(Integer) spinnerStemLength.getSelectedItem();
//			headset = 10;
			
			/* T+ Carbon Series */

			bikeStack = 545;//Integer.parseInt(((EditText) findViewById(R.id.bike_frame_stack_edit)).getText().toString());
			bikeReach = 380;//Integer.parseInt(((EditText) findViewById(R.id.bike_frame_reach_edit)).getText().toString());
			fitStack = 690;//Integer.parseInt(((EditText) findViewById(R.id.fit_stack_edit)).getText().toString());
			fitReach = 395;//Integer.parseInt(((EditText) findViewById(R.id.fit_reach_edit)).getText().toString());
			stemAngle = 17;//(Integer) spinnerStemAngle.getSelectedItem();//Integer.parseInt(((EditText) findViewById(R.id.stem_angle_edit)).getText().toString());
			spacers = 10;//Integer.parseInt(((EditText) findViewById(R.id.spacers_edit)).getText().toString());
			stemLength = 90;//(Integer) spinnerStemLength.getSelectedItem();
			headset = 5;
			
			/* T+ Carbon Series and Aeria */

			
//			bikeStack = 545;//Integer.parseInt(((EditText) findViewById(R.id.bike_frame_stack_edit)).getText().toString());
//			bikeReach = 395;//Integer.parseInt(((EditText) findViewById(R.id.bike_frame_reach_edit)).getText().toString());
//			fitStack = 665;//Integer.parseInt(((EditText) findViewById(R.id.fit_stack_edit)).getText().toString());
//			fitReach = 455;//Integer.parseInt(((EditText) findViewById(R.id.fit_reach_edit)).getText().toString());
//			stemAngle = -17;//(Integer) spinnerStemAngle.getSelectedItem();//Integer.parseInt(((EditText) findViewById(R.id.stem_angle_edit)).getText().toString());
//			spacers = 10;//Integer.parseInt(((EditText) findViewById(R.id.spacers_edit)).getText().toString());
//			stemLength = 100;//(Integer) spinnerStemLength.getSelectedItem();
//			headset = 5;
			
//			bikeStack = 600;//Integer.parseInt(((EditText) findViewById(R.id.bike_frame_stack_edit)).getText().toString());
//			bikeReach = 407;//Integer.parseInt(((EditText) findViewById(R.id.bike_frame_reach_edit)).getText().toString());
//			fitStack = 700;//Integer.parseInt(((EditText) findViewById(R.id.fit_stack_edit)).getText().toString());
//			fitReach = 420;//Integer.parseInt(((EditText) findViewById(R.id.fit_reach_edit)).getText().toString());
//			stemAngle = 6;//(Integer) spinnerStemAngle.getSelectedItem();//Integer.parseInt(((EditText) findViewById(R.id.stem_angle_edit)).getText().toString());
//			spacers = 0;//Integer.parseInt(((EditText) findViewById(R.id.spacers_edit)).getText().toString());
//			stemLength = 100;//(Integer) spinnerStemLength.getSelectedItem();
			
			
			
		}catch(NumberFormatException e){
			return null;
		}
		
		
		//plug values into algorithmic formula
		
		dStack = fitStack - bikeStack;
		
		Log.i("SPEED", "dStack: " + dStack);
		
		double deg = Math.PI / 180;
		
		
		
		Log.i("SPEED", "stemLeftSin: " + (Math.sin(23 * deg)));
		
		double stemLeft = (Math.sin((stemAngle + STEM_ANGLE_ADDITIVE) * deg)) * stemLength;
		double stemRight = ((Math.cos((STEM_ANGLE_ADDITIVE) * deg)) * (SPACERS_ADDITIVE + spacers + headset));
		
		Log.i("SPEED", "stemLeft: " + stemLeft + " stemRight: " + stemRight);
		
		stemStack = stemLeft + stemRight;
		
		Log.i("SPEED", "stemStack: " + stemStack);
		
		aerobarStack = dStack - stemStack;// + (Math.cos(STEM_ANGLE_ADDITIVE) * (SPACERS + SPACERS_ADDITIVE)));
		
		dReach = fitReach - bikeReach;
		
		Log.i("SPEED", "dReach: " + dReach);

		double stemLeftReach = ((Math.cos((stemAngle + STEM_ANGLE_ADDITIVE) * deg)) * stemLength);
		double stemRightReach = ((Math.sin((STEM_ANGLE_ADDITIVE) * deg)) * (SPACERS_ADDITIVE + spacers + headset));
		
		Log.i("SPEED", "stemLeftReach: " + stemLeftReach + " stemRightReach: " + stemRightReach);
		
		stemReach = stemLeftReach - stemRightReach;
		
		Log.i("SPEED", "stemReach: " + stemReach);
		
		aerobarReach = dReach - stemReach;// - (Math.sin(STEM_ANGLE_ADDITIVE) * (SPACERS + SPACERS_ADDITIVE)));
		
		Log.i("SPEED", "aerobarStack: " + aerobarStack);
		Log.i("SPEED", "aerobarReach: " + aerobarReach);
		
		//calculate via formula
		
		//return figure
		
		Results results = new Results();
		results.setAerobarStack((int)Math.round(aerobarStack));
		results.setAerobarReach((int)Math.round(aerobarReach));
		
		return results;
		
	}
	
	class Results {
		
		private int aerobarStack;
		private int aerobarReach;
		
		public void setAerobarReach(int aerobarReach){
			this.aerobarReach = aerobarReach;
		}
		
		public int getAerobarReach(){
			return this.aerobarReach;
		}
		
		public void setAerobarStack(int aerobarStack){
			this.aerobarStack = aerobarStack;
		}
		
		public int getAerobarStack(){
			return this.aerobarStack;
		}
		
	}

}
