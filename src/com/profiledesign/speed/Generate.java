package com.profiledesign.speed;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.speed.model.F35;
import com.speed.model.Product;
import com.speed.model.T1Carbon;

public class Generate {
	
	Context context;
	LinearLayout productContainer;
	int stack;
	int reach;
	
	public Generate(Context context, LinearLayout productContainer, int stack, int reach){
		
		this.context = context;
		this.productContainer = productContainer;
		this.stack = stack;
		this.reach = reach;
		
		evaluate();
		
	}
	
	
	
	private void evaluate(){	
		
		String product = "";

//	  	> If reach equals between -75 and -40 and stack between 55 and 95 then Carbon T1/2/3/4

		if((reach >= -75 && reach <= -40) && (stack >= 55 && stack <= 95)){
			product = "Carbon T1/2/3/4";
			
			if(reach >= -45 && reach <= -40) {
				generateProduct("Aeria", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars",
						"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aeria_front.jpg",
						"The most advanced integrate aerobar system within the Profile Design line. A patent-pending bracket system simultaneously clamps the extensions while attaching the brackets to the wing. The elegant design of the Aeria makes for ease of adjustment, and a smaller profile in the wind.  The range of stack goes from 55mm to 135mm to the armrest.",
						"Gloss UD Carbon", "Forged 6061-T6 AL, High-Modulus Carbon Fiber Wing", "F-25", "UD Carbon Fiber", "663 grams");
			}
			
			
			generateProduct("T1 Plus Viper", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars/t1-plus-viper.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t1_viper_black_angle_RHCVT11.jpg",
					"The original ergonomic extension bend provides multiple hand positions while aero. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit. ",
					"Gloss UD Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "590 grams");

			
			generateProduct("T2 Plus Carbon", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars/t2-plus-carbon.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t2_carbon_black_angle_RHCT21.jpg","The T2+ allows for the most aggressive, low profile position within the T+ Carbon Series. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Gloss UD Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "584 grams");
	
			generateProduct("T3 Plus Carbon", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars/t3-plus-carbon.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t3_carbon_black_angle_RHCT31.jpg","The low profile, ergonomic bend of the T3+ keeps wrists in a neutral, more natural position while aero. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Gloss UD Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "620 grams");
		
			generateProduct("T4 Plus Carbon", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars/t4-plus-carbon.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t4_carbon_black_angle_RHCT41.jpg","An ergonomic ski-bend that places the rider in a low profile racing position. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Gloss Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "600 grams");
			
			
		}
		
		
//		> if Reach of -40 through -45 and stack of 55 through 95
//		> if Reach of -55 through -65 and stack of 55 through 95
//		> if Reach of -5 through -55 and stack of 55 through 95
		
		else if(((reach >= -45 && reach <= -40) || (reach >= -65 && reach <= -55) || (reach >= -15 && reach <= -5)) && (stack >= 55 && stack <= 95)){
			
			generateProduct("Aeria", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aeria_front.jpg",
					"The most advanced integrate aerobar system within the Profile Design line. A patent-pending bracket system simultaneously clamps the extensions while attaching the brackets to the wing. The elegant design of the Aeria makes for ease of adjustment, and a smaller profile in the wind.  The range of stack goes from 55mm to 135mm to the armrest.",
					"Gloss UD Carbon", "Forged 6061-T6 AL, High-Modulus Carbon Fiber Wing", "F-25", "UD Carbon Fiber", "663 grams");
			
			generateProduct("T1 Plus Viper", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars/t1-plus-viper.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t1_viper_black_angle_RHCVT11.jpg",
					"The original ergonomic extension bend provides multiple hand positions while aero. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit. ",
					"Gloss UD Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "590 grams");

			
			generateProduct("T2 Plus Carbon", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars/t2-plus-carbon.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t2_carbon_black_angle_RHCT21.jpg","The T2+ allows for the most aggressive, low profile position within the T+ Carbon Series. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Gloss UD Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "584 grams");
	
			generateProduct("T3 Plus Carbon", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars/t3-plus-carbon.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t3_carbon_black_angle_RHCT31.jpg","The low profile, ergonomic bend of the T3+ keeps wrists in a neutral, more natural position while aero. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Gloss UD Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "620 grams");
		
			generateProduct("T4 Plus Carbon", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars/t4-plus-carbon.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t4_carbon_black_angle_RHCT41.jpg","An ergonomic ski-bend that places the rider in a low profile racing position. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Gloss Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "600 grams");
			
		
		}
	
//		> If reach equals between 10 and -20 and stack between 55 and 95 then Carbon T1/2/3/4 with brackets flipped

		else if((reach >= -20 && reach <= 10) && (stack >= 55 && stack <= 95)){
			product = "Carbon T1/2/3/4 with brackets flipped";
			
			generateProduct("T1 Plus Viper", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars/t1-plus-viper.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t1_viper_black_angle_RHCVT11.jpg",
					"The original ergonomic extension bend provides multiple hand positions while aero. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit. ",
					"Gloss UD Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "590 grams");

			
			generateProduct("T2 Plus Carbon", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars/t2-plus-carbon.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t2_carbon_black_angle_RHCT21.jpg","The T2+ allows for the most aggressive, low profile position within the T+ Carbon Series. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Gloss UD Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "584 grams");
	
			generateProduct("T3 Plus Carbon", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars/t3-plus-carbon.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t3_carbon_black_angle_RHCT31.jpg","The low profile, ergonomic bend of the T3+ keeps wrists in a neutral, more natural position while aero. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Gloss UD Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "620 grams");
		
			generateProduct("T4 Plus Carbon", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars/t4-plus-carbon.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t4_carbon_black_angle_RHCT41.jpg","An ergonomic ski-bend that places the rider in a low profile racing position. With 8 points of adjustment, the J4 Bracket on our T+ Carbon models fine-tunes to the millimeter to optimize the aero position.  The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Gloss Carbon or White", "Forged 6061-T6 AL brackets", "F-35 adjustable armrest", "Forged 6061-T6 AL brackets", "600 grams");
			
			
			
		}
		
		
//		> If reach equals between -35 and -45 and stack between 50 and 135 then Aeria

		else if((reach >= -45 && reach <= -35) && (stack >= 50 && stack <= 135)){
			product = "Aeria";
			
			generateProduct("Aeria", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aeria_front.jpg",
					"The most advanced integrate aerobar system within the Profile Design line. A patent-pending bracket system simultaneously clamps the extensions while attaching the brackets to the wing. The elegant design of the Aeria makes for ease of adjustment, and a smaller profile in the wind.  The range of stack goes from 55mm to 135mm to the armrest.",
					"Gloss UD Carbon", "Forged 6061-T6 AL, High-Modulus Carbon Fiber Wing", "F-25", "UD Carbon Fiber", "663 grams");
		}
		
		
//		> If reach equals between -55 and -65 and stack between 50 and 135 then Aeria

		else if((reach >= -65 && reach <= -55) && (stack >= 50 && stack <= 135)){
			product = "Aeria";
			
			generateProduct("Aeria", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aeria_front.jpg",
					"The most advanced integrate aerobar system within the Profile Design line. A patent-pending bracket system simultaneously clamps the extensions while attaching the brackets to the wing. The elegant design of the Aeria makes for ease of adjustment, and a smaller profile in the wind.  The range of stack goes from 55mm to 135mm to the armrest.",
					"Gloss UD Carbon", "Forged 6061-T6 AL, High-Modulus Carbon Fiber Wing", "F-25", "UD Carbon Fiber", "663 grams");
		}
		
		
//		> If reach equals between -5 and -15 and stack between 50 and 135 then Aeria with brackets flipped

		else if((reach >= -15 && reach <= -5) && (stack >= 50 && stack <= 135)){
			product = "Aeria with brackets flipped";
			
			generateProduct("Aeria", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aeria_front.jpg",
					"The most advanced integrate aerobar system within the Profile Design line. A patent-pending bracket system simultaneously clamps the extensions while attaching the brackets to the wing. The elegant design of the Aeria makes for ease of adjustment, and a smaller profile in the wind.  The range of stack goes from 55mm to 135mm to the armrest.",
					"Gloss UD Carbon", "Forged 6061-T6 AL, High-Modulus Carbon Fiber Wing", "F-25", "UD Carbon Fiber", "663 grams");
		}
		
//		> If reach equals between -25 and -35 and stack between 50 and 135 then Aeria with brackets flipped

		else if((reach >= -35 && reach <= -25) && (stack >= 50 && stack <= 135)){
			product = "Aeria with brackets flipped";
			
			generateProduct("Aeria", "http://www.profile-design.com/profile-design/products/aerobars/carbon-aerobars",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aeria_front.jpg",
					"The most advanced integrate aerobar system within the Profile Design line. A patent-pending bracket system simultaneously clamps the extensions while attaching the brackets to the wing. The elegant design of the Aeria makes for ease of adjustment, and a smaller profile in the wind.  The range of stack goes from 55mm to 135mm to the armrest.",
					"Gloss UD Carbon", "Forged 6061-T6 AL, High-Modulus Carbon Fiber Wing", "F-25", "UD Carbon Fiber", "663 grams");
		
		}
		
		
//		> If reach equals between -40 and -90 and stack between 30 and 60 then ZBS

		else if((reach >= -90 && reach <= -40) && (stack >= 30 && stack <= 60)){
			product = "ZBS";
			

					generateProduct("ZBS DL", "http://www.profile-design.com/profile-design/products/aerobars/aluminum-aerobars/zbs-dl.html",
							"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_zbs_dl_angle_1.jpg",
							"This system is specifically designed to put the rider in a low profile aero position while keeping within the draft legal racing regulations.  The range of stack goes from 37mm to 52mm to the armrest using our Aerobar Bracket Riser Kit. NOTE: This angled bracket system causes the reach to increase slightly when increasing the stack.",
							"Gloss Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "470 grams");

					
					generateProduct("ZBS S-Bend", "http://www.profile-design.com/profile-design/products/aerobars/aluminum-aerobars/zbs-s-bend.html",
							"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_zbs_s_bend_angle_1.jpg",
							"This is a fast extension that pairs with any bike to make an aggressive position for time trials or multi-sport performance. The range of stack goes from 37mm to 52mm to the armrest using our Aerobar Bracket Riser Kit. NOTE: This angled bracket system causes the reach to increase slightly when increasing the stack.",
							"Gloss Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "426 grams");
			
					generateProduct("ZBS Stryke Bend", "http://www.profile-design.com/profile-design/products/aerobars/aluminum-aerobars/zbs-stryke-bend.html",
							"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_zbs_stryke_bend_angle_1.jpg","This extension is a classic and unique design in the Profile Design collection. The bend moves slightly outward allowing your arms to follow a straight line from armrest to grip. The range of stack goes from 37mm to 52mm to the armrest using our Aerobar Bracket Riser Kit. NOTE: This angled bracket system causes the reach to increase slightly when increasing the stack.",
							"Gloss Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "438 grams");
				
					generateProduct("ZBS Ski-Bend", "http://www.profile-design.com/profile-design/products/aerobars/aluminum-aerobars/zbs-ski-bend.html",
							"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_zbs_ski_bend_angle_1.jpg","The Ski bend extension is an ergonomic bend to keep your wrists in a neutral position while riding in the aero position. The range of stack goes from 37mm to 52mm to the armrest using our Aerobar Bracket Riser Kit. NOTE: This angled bracket system causes the reach to increase slightly when increasing the stack.",
							"Gloss Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "432 grams");
					
					generateProduct("ZBS TT", "http://www.profile-design.com/profile-design/products/aerobars/aluminum-aerobars/zbs-tt.html",
							"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_zbs_tt_angle_1.jpg","Combined with the low profile ZB system, the TT extension makes this aerobar the most aggressive system offered by Profile Design. The range of stack goes from 37mm to 52mm to the armrest using our Aerobar Bracket Riser Kit. NOTE: This angled bracket system causes the reach to increase slightly when increasing the stack.",
							"Gloss Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "435 grams");
				
		}
		
		
//		> If reach equals between 15 and -100 and stack between 55 and 95 then Aluminum T1/2/3/4

		else if((reach >= -100 && reach <= 15) && (stack >= 55 && stack <= 95)){
			product = "Aluminum T1/2/3/4";
			
			
			generateProduct("T1 Plus", "http://www.profile-design.com/profile-design/products/aerobars/aluminum-aerobars/t1-plus.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t1_alloy_angle.jpg","The original extension bend provides multiple hand positions while aero. The accompanying J2 Bracket, isolated from the basebar bracket, allows for a wide range of armrest adjustment possibilities. The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Anodized Matte Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "545 grams");

			
			generateProduct("T2 Plus", "http://www.profile-design.com/profile-design/products/aerobars/aluminum-aerobars/t2-plus.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t2_alloy_angle.jpg","The T2+ allows for the most aggressive, low profile position within the T+ Aluminum Series. The accompanying J2 Bracket, isolated from the basebar bracket, allows for a wide range of armrest adjustment possibilities. The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Anodized Matte Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "500 grams");
	
			generateProduct("T3 Plus", "http://www.profile-design.com/profile-design/products/aerobars/aluminum-aerobars/t3-plus.html",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/pd_aerobar_t3plus_angle_1.jpg","The low profile, ergonomic bend of the T3+ keeps wrists in a neutral, more natural position while aero. The accompanying J2 Bracket, isolated from the basebar bracket, allows for a wide range of armrest adjustment possibilities. The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Anodized Matte Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "530 grams");
		
			generateProduct("T4 Plus", "http://www.profile-design.com/profile-design/products/aerobars/aluminum-aerobars",
					"http://www.profile-design.com/files/product-images/profile-design/aerobars/t4_alloy_front.jpg","A ski-bend that places the rider in a low profile racing position. The accompanying J2 Bracket, isolated from the basebar bracket, allows for a wide range of armrest adjustment possibilities. The range of stack goes from 60mm to 95mm to the armrest using our Aerobar Bracket Riser Kit.",
					"Anodized Matte Black", "Forged 6061-T6 AL", "F-19 injection molded", "Forged 6061-T6 AL", "469 grams");
			
		}
		
		
//		> If reach is greater than -40 (-39,-38,-37,-36�) and stack less than 49 then contact customer service

		else if((reach >= -40) && (stack <= 49)){
			
			((TextView)((Activity)context).findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
		}
		
		
//		> If reach is less than -65 (-66,-65,-64�) and stack is greater than 96 then contact customer service

		else if((reach >= -65) && (stack >= 96)){
			((TextView)((Activity)context).findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
		}
		
		
//		> If reach is less than -95 (-96,-97,-98�) then contact customer service

		else if((reach <= -95)){
			((TextView)((Activity)context).findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
		}
		
		
//		> If reach is greater than -5 (-4,-3,-3�) and stack is greater than 95 then contact customer service

		else if((reach >= -5) && (stack >= 95)){
			((TextView)((Activity)context).findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
		}
		
		else{
			((TextView)((Activity)context).findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
		}
		
		//product = "Carbon T1/2/3/4 with brackets flipped";
		
		((TextView)((Activity)context).findViewById(R.id.product_result)).setText(product);
	 
	}
	
	
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
