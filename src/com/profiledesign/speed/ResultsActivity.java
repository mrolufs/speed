package com.profiledesign.speed;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.speed.model.F35;
import com.speed.model.Product;
import com.speed.model.T1Carbon;

public class ResultsActivity extends Activity {
	
	AppContext appContext;

	int reach;
	int stack;
	
	LinearLayout productContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_results);
		
		appContext = (AppContext) getApplicationContext();
		
		productContainer = (LinearLayout) findViewById(R.id.container);
		
		Bundle b = getIntent().getExtras();
		
		stack = appContext.getStack();//b.getInt("aerobarStack");
		reach = appContext.getReach();//b.getInt("aerobarReach");
		
		((TextView)findViewById(R.id.aerobar_stack_result)).setText(String.valueOf(stack));
		((TextView)findViewById(R.id.aerobar_reach_result)).setText(String.valueOf(reach));
		
		
		new Generate(this, productContainer, stack, reach);
		
	}

	
	


}
