package com.profiledesign.speed;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.speed.model.Aeria;
import com.speed.model.Product;
import com.speed.model.T1Carbon;
import com.speed.model.T1Plus;
import com.speed.model.T2Carbon;
import com.speed.model.T2Plus;
import com.speed.model.T3Carbon;
import com.speed.model.T3Plus;
import com.speed.model.T4Carbon;
import com.speed.model.T4Plus;

public class Generate {
	
	private final String PRODUCT_PATH = "http://www.profile-design.com/profile-design/products/aerobars/";
	private final String CARBON_AEROBARS_PATH = "carbon-aerobars/";
	private final String ALUMINUM_AEROBARS_PATH = "aluminum-aerobars/";
	private final String IMAGES_PATH = "http://www.profile-design.com/files/product-images/profile-design/aerobars/";
	
	Context context;
	LinearLayout productContainer;
	int stack;
	int reach;
	
	AppContext appContext;
	
	ArrayList<Product> products;
	
	
	
	public Generate(Context context, LinearLayout productContainer, int stack, int reach){
		
		this.context = context;
		this.productContainer = productContainer;
		this.stack = stack;
		this.reach = reach;
		
		appContext = (AppContext) context.getApplicationContext();
		
		products = appContext.getProducts();
		
		generate();
		
	}
	
	private void aeria(){
		generateProduct("Aeria", PRODUCT_PATH + CARBON_AEROBARS_PATH,
				IMAGES_PATH + "pd_aeria_front.jpg",
				"The most advanced integrate aerobar system within the Profile Design line. A patent-pending bracket system simultaneously clamps the extensions while attaching the brackets to the wing. The elegant design of the Aeria makes for ease of adjustment, and a smaller profile in the wind.  The range of stack goes from 55mm to 135mm to the armrest.",
				"Gloss UD Carbon", "Forged 6061-T6 AL, High-Modulus Carbon Fiber Wing", "F-25", "UD Carbon Fiber", "663 grams");
	}
	
	private void t1Carbon(){
		generateProduct("T1 Plus Carbon", PRODUCT_PATH + CARBON_AEROBARS_PATH + "t1-plus-viper.html",
				IMAGES_PATH + "pd_aerobar_t1_viper_black_angle_RHCVT11.jpg",
				"The original ergonomic extension bend provides multiple hand positions while aero. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit. ",
				"Gloss UD Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "590 grams");
	}
	
	private void t2Carbon(){
		generateProduct("T2 Plus Carbon", PRODUCT_PATH + CARBON_AEROBARS_PATH + "t2-plus-carbon.html",
				IMAGES_PATH + "pd_aerobar_t2_carbon_black_angle_RHCT21.jpg","The T2+ allows for the most aggressive, low profile position within the T+ Carbon Series. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
				"Gloss UD Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "584 grams");
	}
	
	private void t3Carbon(){
		generateProduct("T3 Plus Carbon", PRODUCT_PATH + CARBON_AEROBARS_PATH + "t3-plus-carbon.html",
				IMAGES_PATH + "pd_aerobar_t3_carbon_black_angle_RHCT31.jpg","The low profile, ergonomic bend of the T3+ keeps wrists in a neutral, more natural position while aero. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
				"Gloss UD Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "620 grams");
	}
	
	private void t4Carbon(){
		generateProduct("T4 Plus Carbon", PRODUCT_PATH + CARBON_AEROBARS_PATH + "t4-plus-carbon.html",
				IMAGES_PATH + "pd_aerobar_t4_carbon_black_angle_RHCT41.jpg","An ergonomic ski-bend that places the rider in a low profile racing position. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
				"Gloss Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "600 grams");
		
	}
	
	private void t1Plus(){
		generateProduct("T1 Plus", PRODUCT_PATH + ALUMINUM_AEROBARS_PATH + "t1-plus.html",
				IMAGES_PATH + "pd_aerobar_t1_alloy_angle.jpg","The original extension bend provides multiple hand positions while aero. The accompanying J2 Bracket, isolated from the basebar bracket, allows for a wide range of armrest adjustment possibilities. The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
				"Anodized Matte Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "545 grams");		
	}

	private void t2Plus(){
		generateProduct("T2 Plus", PRODUCT_PATH + ALUMINUM_AEROBARS_PATH + "t2-plus.html",
				IMAGES_PATH + "pd_aerobar_t2_alloy_angle.jpg","The T2+ allows for the most aggressive, low profile position within the T+ Aluminum Series. The accompanying J2 Bracket, isolated from the basebar bracket, allows for a wide range of armrest adjustment possibilities. The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
				"Anodized Matte Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "500 grams");
	}
	
	private void t3Plus(){
		generateProduct("T3 Plus", PRODUCT_PATH + ALUMINUM_AEROBARS_PATH + "t3-plus.html",
				IMAGES_PATH + "pd_aerobar_t3plus_angle_1.jpg","The low profile, ergonomic bend of the T3+ keeps wrists in a neutral, more natural position while aero. The accompanying J2 Bracket, isolated from the basebar bracket, allows for a wide range of armrest adjustment possibilities. The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
				"Anodized Matte Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "530 grams");
	}

	private void t4Plus(){
		generateProduct("T4 Plus", PRODUCT_PATH + ALUMINUM_AEROBARS_PATH,
				IMAGES_PATH + "t4_alloy_front.jpg","A ski-bend that places the rider in a low profile racing position. The accompanying J2 Bracket, isolated from the basebar bracket, allows for a wide range of armrest adjustment possibilities. The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
				"Anodized Matte Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "469 grams");
	}
	
	private void zbsDL(){	
		generateProduct("ZBS DL", PRODUCT_PATH + ALUMINUM_AEROBARS_PATH + "zbs-dl.html",
				IMAGES_PATH + "pd_aerobar_zbs_dl_angle_1.jpg",
				"This system is specifically designed to put the rider in a low profile aero position while keeping within the draft legal racing regulations.  The range of stack goes from 37mm to 52mm to the armrest using our Aerobar Bracket Riser Kit. NOTE: This angled bracket system causes the reach to increase slightly when increasing the stack.",
				"Gloss Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "470 grams");
	}
	
	private void zbsSBend(){
		generateProduct("ZBS S-Bend", PRODUCT_PATH + ALUMINUM_AEROBARS_PATH + "zbs-s-bend.html",
				IMAGES_PATH + "pd_aerobar_zbs_s_bend_angle_1.jpg",
				"This is a fast extension that pairs with any bike to make an aggressive position for time trials or multi-sport performance. The range of stack goes from 37mm to 52mm to the armrest using our Aerobar Bracket Riser Kit. NOTE: This angled bracket system causes the reach to increase slightly when increasing the stack.",
				"Gloss Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "426 grams");
	}
	
	private void zbsStrykeBend(){
		generateProduct("ZBS Stryke Bend", PRODUCT_PATH + ALUMINUM_AEROBARS_PATH + "zbs-stryke-bend.html",
				IMAGES_PATH + "pd_aerobar_zbs_stryke_bend_angle_1.jpg","This extension is a classic and unique design in the Profile Design collection. The bend moves slightly outward allowing your arms to follow a straight line from armrest to grip. The range of stack goes from 37mm to 52mm to the armrest using our Aerobar Bracket Riser Kit. NOTE: This angled bracket system causes the reach to increase slightly when increasing the stack.",
				"Gloss Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "438 grams");
	}
	
	private void zbsSkiBend(){
		generateProduct("ZBS Ski-Bend", PRODUCT_PATH + ALUMINUM_AEROBARS_PATH + "zbs-ski-bend.html",
				IMAGES_PATH + "pd_aerobar_zbs_ski_bend_angle_1.jpg","The Ski bend extension is an ergonomic bend to keep your wrists in a neutral position while riding in the aero position. The range of stack goes from 37mm to 52mm to the armrest using our Aerobar Bracket Riser Kit. NOTE: This angled bracket system causes the reach to increase slightly when increasing the stack.",
				"Gloss Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "432 grams");	
	}
	
	private void zbsTT(){
		generateProduct("ZBS TT", PRODUCT_PATH + ALUMINUM_AEROBARS_PATH + "zbs-tt.html",
				IMAGES_PATH + "pd_aerobar_zbs_tt_angle_1.jpg","Combined with the low profile ZB system, the TT extension makes this aerobar the most aggressive system offered by Profile Design. The range of stack goes from 37mm to 52mm to the armrest using our Aerobar Bracket Riser Kit. NOTE: This angled bracket system causes the reach to increase slightly when increasing the stack.",
				"Gloss Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "435 grams");
	}

	
	boolean isT1Plus;
	boolean isT2Plus;
	boolean isT3Plus;
	boolean isT4Plus;
	boolean isT1Carbon;
	boolean isT2Carbon;
	boolean isT3Carbon;
	boolean isT4Carbon;
	boolean isAeria;
	boolean showAeriaConfigs;
	
	private void generate(){
		
		for(Product product : products){
			

			

			recurseProduct(product);

		}
		
	}
	
	private void recurseProduct(Product product){
	
		Log.i("PRODUCTTYPE", product.getClass().getSimpleName());
		
		if(product instanceof T1Plus && !isT1Plus){
			addLine();
			isT1Plus = true;
			t1Plus();
		}
		else if(product instanceof T2Plus && !isT2Plus){
			addLine();
			isT2Plus = true;
			t2Plus();
		}
		else if(product instanceof T3Plus && !isT3Plus){
			addLine();
			isT3Plus = true;
			t3Plus();
		}
		else if(product instanceof T4Plus && !isT4Plus){
			addLine();
			isT4Plus = true;
			t4Plus();
		}
		else if(product instanceof T1Carbon && !isT1Carbon){
			addLine();
			isT1Carbon = true;
			t1Carbon();
		}
		else if(product instanceof T2Carbon && !isT2Carbon){
			addLine();
			isT2Carbon = true;
			t2Carbon();
		}
		else if(product instanceof T3Carbon && !isT3Carbon){
			addLine();
			isT3Carbon = true;
			t3Carbon();
		}
		else if(product instanceof T4Carbon && !isT4Carbon){
			addLine();
			isT4Carbon = true;
			t4Carbon();
		}else if(product instanceof Aeria && !isAeria){
			addLine();
			isAeria = true;
			//isT1Plus = true;
			isT2Plus = true;
			//isT3Plus = true;
			isT4Plus = true;
			isT1Carbon = true;
			isT2Carbon = true;
			isT3Carbon = true;
			isT4Carbon = true;
			aeria();
		}
		else{
			if(!(product.getClass().getSimpleName().equals("Product"))){
				
				
				if(isAeria){
					
					//isT1Plus = true;
					isT2Plus = true;
					//isT3Plus = true;
					isT4Plus = true;
					isT1Carbon = true;
					isT2Carbon = true;
					isT3Carbon = true;
					isT4Carbon = true;
					
					if(isT1Plus && isT3Plus){
						
						//don't generate
						
					}else{
						generateOptions(product);	
					}
					

				}else{
				
					generateOptions(product);	
				}
			}

		}
		
		if(product.getProduct() != null ){

			recurseProduct(product.getProduct());
		
		}
		


	}
	
	private void addLine(){
		
		LinearLayout bottomLine =  new LinearLayout(context);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 1);
		params.topMargin = 6;
		bottomLine.setPadding(0, 6, 0, 0);
		bottomLine.setLayoutParams(params);
		bottomLine.setBackgroundColor(Color.LTGRAY);

		productContainer.addView(bottomLine);
	}
	
	
	private void generateOptions(Product product){
		TextView textView = new TextView(context);
		textView.setTextColor(Color.WHITE);
		textView.setText(product.getDescription());
		productContainer.addView(textView);
	}
	

	
//	private void evaluate(){	
//		
//		String product = "";
//
////	  	> If reach equals between -75 and -40 and stack between 55 and 95 then Carbon T1/2/3/4
//
//		if((reach >= -75 && reach <= -40) && (stack >= 55 && stack <= 95)){
//			product = "Carbon T1/2/3/4";
//			
//			if(reach >= -45 && reach <= -40) {
//				aeria();
//			}
//			
//			
//			t1PlusCarbon();
//			
//			t2PlusCarbon();
//			
//			t3PlusCarbon();
//			
//			t4PlusCarbon();
//		}
//		
//		
////		> if Reach of -40 through -45 and stack of 55 through 95
////		> if Reach of -55 through -65 and stack of 55 through 95
////		> if Reach of -5 through -55 and stack of 55 through 95
//		
//		else if(((reach >= -45 && reach <= -40) || (reach >= -65 && reach <= -55) || (reach >= -15 && reach <= -5)) && (stack >= 55 && stack <= 95)){
//			
//			aeria();
//			
//			t1PlusCarbon();
//			
//			t2PlusCarbon();
//			
//			t3PlusCarbon();
//			
//			t4PlusCarbon();
//		
//		}
//	
////		> If reach equals between 10 and -20 and stack between 55 and 95 then Carbon T1/2/3/4 with brackets flipped
//
//		else if((reach >= -20 && reach <= 10) && (stack >= 55 && stack <= 95)){
//			product = "Carbon T1/2/3/4 with brackets flipped";
//
//			
//			t1PlusCarbon();
//			
//			t2PlusCarbon();
//			
//			t3PlusCarbon();
//			
//			t4PlusCarbon();
//			
//		}
//		
//		
////		> If reach equals between -35 and -45 and stack between 50 and 135 then Aeria
//
//		else if((reach >= -45 && reach <= -35) && (stack >= 50 && stack <= 135)){
//			product = "Aeria";
//			
//			aeria();
//		}
//		
//		
////		> If reach equals between -55 and -65 and stack between 50 and 135 then Aeria
//
//		else if((reach >= -65 && reach <= -55) && (stack >= 50 && stack <= 135)){
//			product = "Aeria";
//			
//			aeria();
//		}
//		
//		
////		> If reach equals between -5 and -15 and stack between 50 and 135 then Aeria with brackets flipped
//
//		else if((reach >= -15 && reach <= -5) && (stack >= 50 && stack <= 135)){
//			product = "Aeria with brackets flipped";
//			
//			aeria();
//		}
//		
////		> If reach equals between -25 and -35 and stack between 50 and 135 then Aeria with brackets flipped
//
//		else if((reach >= -35 && reach <= -25) && (stack >= 50 && stack <= 135)){
//			product = "Aeria with brackets flipped";
//			
//			aeria();
//		
//		}
//		
//		
////		> If reach equals between -40 and -90 and stack between 30 and 60 then ZBS
//
//		else if((reach >= -90 && reach <= -40) && (stack >= 30 && stack <= 60)){
//			product = "ZBS";
//			
//			zbsDL();
//			
//			zbsSBend();
//			
//			zbsStrykeBend();
//			
//			zbsSkiBend();
//			
//			zbsTT();
//			
//		}
//		
//		
////		> If reach equals between 15 and -100 and stack between 55 and 95 then Aluminum T1/2/3/4
//
//		else if((reach >= -100 && reach <= 15) && (stack >= 55 && stack <= 95)){
//			product = "Aluminum T1/2/3/4";
//
//			t1Plus();
//			t2Plus();
//			t3Plus();
//			t4Plus();
//		}
//		
//		
////		> If reach is greater than -40 (-39,-38,-37,-36�) and stack less than 49 then contact customer service
//
//		else if((reach >= -40) && (stack <= 49)){
//			
//			((TextView)((Activity)context).findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
//			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
//		}
//		
//		
////		> If reach is less than -65 (-66,-65,-64�) and stack is greater than 96 then contact customer service
//
//		else if((reach >= -65) && (stack >= 96)){
//			((TextView)((Activity)context).findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
//			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
//		}
//		
//		
////		> If reach is less than -95 (-96,-97,-98�) then contact customer service
//
//		else if((reach <= -95)){
//			((TextView)((Activity)context).findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
//			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
//		}
//		
//		
////		> If reach is greater than -5 (-4,-3,-3�) and stack is greater than 95 then contact customer service
//
//		else if((reach >= -5) && (stack >= 95)){
//			((TextView)((Activity)context).findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
//			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
//		}
//		
//		else{
//			((TextView)((Activity)context).findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
//			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
//		}
//		
//		//product = "Carbon T1/2/3/4 with brackets flipped";
//		
//		((TextView)((Activity)context).findViewById(R.id.product_result)).setText(product);
//	 
//	}
	
	
	private void generateProduct(String productTitle, final String productPath, String imgPath, String description, String colors, String material, String armrests, String armrestsMaterial, String weight){
		
		LayoutInflater inflater = LayoutInflater.from(((Activity)context));
		
		RelativeLayout listItem = (RelativeLayout) inflater.inflate(R.layout.result_item, null);
		
		listItem.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(productPath));
				((Activity)context).startActivity(i);
			}
		});
		
		WebView webView = (WebView) listItem.findViewById(R.id.webView);

		webView.setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY);
		webView.setFocusable(true);
		webView.setHorizontalScrollBarEnabled(false);
		webView.setVerticalScrollBarEnabled(false);
		webView.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.listitemselector));

		String html = "<a href=\"" + productPath + "\">" + "<img src=\"" + imgPath + "\" width=\"100\" height=\"100\"/></a>";
		
		
		webView.loadData(html, "text/html", "utf8");
		
		webView.setWebViewClient(new WebViewClient(){
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(productPath));
				((Activity)context).startActivity(i);
				return true;//super.shouldOverrideUrlLoading(view, url);
			}
			
			
		});

		
		TextView title = (TextView) listItem.findViewById(R.id.title);


		title.setText(productTitle);
		
		TextView colorsTextView = (TextView) listItem.findViewById(R.id.colors);
		colorsTextView.setText(colors);
		
		TextView materialTextView = (TextView) listItem.findViewById(R.id.material);
		materialTextView.setText(material);
		
		TextView armrestsTextView = (TextView) listItem.findViewById(R.id.armrests);
		armrestsTextView.setText(armrests);
		
		TextView armrestsMaterialTextView = (TextView) listItem.findViewById(R.id.armrests_material);
		armrestsMaterialTextView.setText(armrestsMaterial);
		
		TextView weightTextView = (TextView) listItem.findViewById(R.id.weight);
		weightTextView.setText(weight);

		
		
		TextView textDescription = (TextView) listItem.findViewById(R.id.text_description);

		textDescription.setText(description);

		productContainer.addView(listItem);
		
		
	}

}
