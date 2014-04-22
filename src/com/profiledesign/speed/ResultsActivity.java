package com.profiledesign.speed;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ResultsActivity extends Activity {
	
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
		
		productContainer = (LinearLayout) findViewById(R.id.container);
		
		Bundle b = getIntent().getExtras();
		
		stack = Integer.parseInt(b.getString("aerobarStack"));
		reach = Integer.parseInt(b.getString("aerobarReach"));
		
		((TextView)findViewById(R.id.aerobar_stack_result)).setText(String.valueOf(stack));
		((TextView)findViewById(R.id.aerobar_reach_result)).setText(String.valueOf(reach));
		
		evaluate();
	}

	
	/**
	A	F19 T1 (J2 BRACKET)															REACH	"-185 To 0"		"15 To 85"		STACK	"55 To 95"		
	B	F19 T2 (J2 BRACKET)															REACH	"-165 To 0"		"15 To 70"		STACK	"55 To 95"		
	C	F19 T3 (J2 BRACKET)															REACH	"-165 To 0"		"15 To 75"		STACK	"55 To 95"		
	D	F19 T4 (J2 BRACKET)															REACH	"-165 To 0"		"15 To 70"		STACK	"55 To 95"		
	E	F35 T1 (J2 BRACKET)															REACH	"-170 To 0"		"15 To 85"		STACK	"55 To 95"		
	F	F35 T2 (J2 BRACKET)															REACH	"-165 To 0"		"15 To 65"		STACK	"55 To 95"		
	G	F35 T3 (J2 BRACKET)															REACH	"-155 To 0"		"15 To 70"		STACK	"55 To 95"		
	H	F35 T4 (J2 BRACKET)															REACH	"-150 To 0"		"15 To 70"		STACK	"55 To 95"		
	J	F19 REAR PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)										"-95 To -85"					STACK	"55 To 95"		
	K	F35 REAR PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)										"-85 To -75"					STACK	"55 To 95"		
	L	F19 MiDDLE REAR PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)								"-80 To -70"					STACK	"55 To 95"		
	M	F35 MiDDLE PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)									"-65 To -55"					STACK	"55 To 95"		
	N	F19 MiDDLE FRoNT PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)								"-65 To -55"					STACK	"55 To 95"		
	P	F35 FRoNT PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)									"-45 To -35"					STACK	"55 To 95"		
	Q	F19 FRoNT PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)									"-50 To -40"					STACK	"55 To 95"		
	R	F35 MiDDLE PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)					"-30 To -20"					STACK	"55 To 95"		
	S	F19 MiDDLE FRoNT PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)				"-30 To -20"					STACK	"55 To 95"		
	T	F35 FRoNT PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)					"-10 to 0"						STACK	"55 To 95"		
	U	F19 FRoNT PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)					"-15 to -5"						STACK	"55 To 95"		
	V	AERiA T2/T4 F35 iN REAR PoSiTioN													"-75 to -65"					STACK	"50 to 135"		
	X	AERiA T2/T4 F35 iN MiDDLE PoSiTioN													"-55 to -45"					STACK	"50 to 135"		
	Y	AERiA T2/T4 F35 iN FRoNT PoSiTioN													"-35 to -25"					STACK	"50 to 135"		
	Z	AERiA T2/T4 BRACKET FLiPPED F35 iN REAR PoSiTioN									"-40"							STACK	"50 to 135"		
	1	AERiA T2/T4 BRACKET FLiPPED F35 iN MiDDLE PoSiTioN									"-20 to -10"					STACK	"50 to 135"		
	2	AERiA T2/T4 BRACKET FLiPPED F35 iN FRoNT PoSiTioN									"0 to 10"						STACK	"50 to 95"		
	3	AERiA F25 iN REAR PoSiTioN															"-65 to -55"					STACK	"55 to 135"		
	4	AERiA F25 iN FRoNT PoSiTioN															"-45 to -35"					STACK	"55 to 135"		
	5	AERiA F2 iN REAR PoSiTioN															"-25 to -15"					STACK	"55 to 135"		
	6	AERiA F25 iN FRoNT PoSiTioN															"-5 to 5"						STACK	"55 to 135"		
	7	ZBS F19 REAR PoSiTioN																"-100 to -90"	"-95 to -85"	STACK	"35 to 40"		"45 to 50"
	8	ZBS F19 REAR MiDDLE PoSiTioN														"-85 to 75"		"-80 to -70"	STACK	"35 to 40"		"45 to 50"
	9	ZBS F19 FRoNT MiDDLE PoSiTioN														"-70 to 60"		"-65 to -55"	STACK	"35 to 40"		"45 to 50"
	0	ZBS F19 FRoNT PoSiTioN																"-55 to -45"	"-50 to -40"	STACK	"35 to 40"		"45 to 50"
	**/
	
	private void evaluate(){
		
		
		if(((reach >= -185 && reach <= 0) || (reach >= 15 && reach <= 85)) && (stack >= 55 && stack <= 95)){
			//A	F19 T1 (J2 BRACKET)
		}
		
		if(((reach >= -165 && reach <= 0) || (reach >= 15 && reach <= 70)) && (stack >= 55 && stack <= 95)){
			//B	F19 T2 (J2 BRACKET)	
		}
		
		if(((reach >= -165 && reach <= 0) || (reach >= 15 && reach <= 75)) && (stack >= 55 && stack <= 95)){
			//C	F19 T3 (J2 BRACKET)
		}
		
		if(((reach >= -165 && reach <= 0) || (reach >= 15 && reach <= 70)) && (stack >= 55 && stack <= 95)){
			//D	F19 T4 (J2 BRACKET)	
		}
		
		if(((reach >= -170 && reach <= 0) || (reach >= 15 && reach <= 85)) && (stack >= 55 && stack <= 95)){
			//E	F35 T1 (J2 BRACKET)		
		}
		
		if(((reach >= -165 && reach <= 0) || (reach >= 15 && reach <= 65)) && (stack >= 55 && stack <= 95)){
			//F	F35 T2 (J2 BRACKET)		
		}
		
		if(((reach >= -155 && reach <= 0) || (reach >= 15 && reach <= 70)) && (stack >= 55 && stack <= 95)){
			//G F35 T3 (J2 BRACKET)			
		}
		
		if(((reach >= -150 && reach <= 0) || (reach >= 15 && reach <= 70)) && (stack >= 55 && stack <= 95)){
			//H	F35 T4 (J2 BRACKET)		
		}
		
		if((reach >= -95 && reach <= -85) && (stack >= 55 && stack <= 95)){
			//J	F19 REAR PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)		
		}
		
		if((reach >= -85 && reach <= -75) && (stack >= 55 && stack <= 95)){
			//K	F35 REAR PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)		
		}
		
		if((reach >= -80 && reach <= -70) && (stack >= 55 && stack <= 95)){
			//L	F19 MiDDLE REAR PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)		
		}
		
		if((reach >= -65 && reach <= -55) && (stack >= 55 && stack <= 95)){
			//M	F35 MiDDLE PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)									"-65 To -55"					STACK	"55 To 95"		
		}
		
		if((reach >= -65 && reach <= -55) && (stack >= 55 && stack <= 95)){
			//N	F19 MiDDLE FRoNT PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)								"-65 To -55"					STACK	"55 To 95"		
		}
		
		if((reach >= -45 && reach <= -35) && (stack >= 55 && stack <= 95)){
			//P	F35 FRoNT PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)									"-45 To -35"					STACK	"55 To 95"		
		}
		
		if((reach >= -50 && reach <= -40) && (stack >= 55 && stack <= 95)){
			//Q	F19 FRoNT PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)									"-50 To -40"					STACK	"55 To 95"		
		}
		
		if((reach >= -30 && reach <= -20) && (stack >= 55 && stack <= 95)){
			//R	F35 MiDDLE PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)					"-30 To -20"					STACK	"55 To 95"		
		}
		
		if((reach >= -30 && reach <= -20) && (stack >= 55 && stack <= 95)){
			//S	F19 MiDDLE FRoNT PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)				"-30 To -20"					STACK	"55 To 95"		
		}
		
		if((reach >= -10 && reach <= 0) && (stack >= 55 && stack <= 95)){
			//T	F35 FRoNT PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)					"-10 to 0"						STACK	"55 To 95"		
		}
		
		if((reach >= -15 && reach <= -5) && (stack >= 55 && stack <= 95)){
			//U	F19 FRoNT PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)					"-15 to -5"						STACK	"55 To 95"		
		}
		
		if((reach >= -75 && reach <= -65) && (stack >= 50 && stack <= 135)){
			//V	AERiA T2/T4 F35 iN REAR PoSiTioN													"-75 to -65"					STACK	"50 to 135"		
		}
		
		if((reach >= -55 && reach <= -45) && (stack >= 50 && stack <= 135)){
			//X	AERiA T2/T4 F35 iN MiDDLE PoSiTioN													"-55 to -45"					STACK	"50 to 135"		
		}
		
		if((reach >= -35 && reach <= -25) && (stack >= 50 && stack <= 135)){
			//Y	AERiA T2/T4 F35 iN FRoNT PoSiTioN													"-35 to -25"					STACK	"50 to 135"		
		}
		
		if((reach == -40) && (stack >= 50 && stack <= 135)){
			//Z	AERiA T2/T4 BRACKET FLiPPED F35 iN REAR PoSiTioN									"-40"							STACK	"50 to 135"		
		}
		
		if((reach >= -20  && reach <= -10) && (stack >= 50 && stack <= 135)){
			//1	AERiA T2/T4 BRACKET FLiPPED F35 iN MiDDLE PoSiTioN									"-20 to -10"					STACK	"50 to 135"		
		}
		
		if((reach >= 0  && reach <= 10) && (stack >= 50 && stack <= 135)){
			//2	AERiA T2/T4 BRACKET FLiPPED F35 iN FRoNT PoSiTioN									"0 to 10"						STACK	"50 to 95"		
		}
		
		if((reach >= -65  && reach <= -55) && (stack >= 55 && stack <= 135)){
			//3	AERiA F25 iN REAR PoSiTioN															"-65 to -55"					STACK	"55 to 135"		
		}
		
		if((reach >= -45  && reach <= -35) && (stack >= 55 && stack <= 135)){
			//4	AERiA F25 iN FRoNT PoSiTioN															"-45 to -35"					STACK	"55 to 135"		
		}
		
		if((reach >= -25  && reach <= -15) && (stack >= 55 && stack <= 135)){
			//5	AERiA F25 iN REAR PoSiTioN															"-25 to -15"					STACK	"55 to 135"		
		}
		
		if((reach >= -5  && reach <= -5) && (stack >= 55 && stack <= 135)){
			//6	AERiA F25 iN FRoNT PoSiTioN															"-5 to 5"						STACK	"55 to 135"		
		}
		
		if(((reach >= -100  && reach <= -90) && (stack >= 35 && stack <= 40)) || ((reach >= -95 && reach <= -85) && (stack >= 45 && stack <= 50))){
			//7	ZBS F19 REAR PoSiTioN																"-100 to -90"	"-95 to -85"	STACK	"35 to 40"		"45 to 50"		
		}
		
		if(((reach >= -85  && reach <= -75) && (stack >= 35 && stack <= 40)) || ((reach >= -80 && reach <= -70) && (stack >= 45 && stack <= 50))){
			//8	ZBS F19 REAR MiDDLE PoSiTioN														"-85 to 75"		"-80 to -70"	STACK	"35 to 40"		"45 to 50"		
		}
		
		if(((reach >= -70  && reach <= -60) && (stack >= 35 && stack <= 40)) || ((reach >= -65 && reach <= -55) && (stack >= 45 && stack <= 50))){
			//9	ZBS F19 FRoNT MiDDLE PoSiTioN														"-70 to 60"		"-65 to -55"	STACK	"35 to 40"		"45 to 50"		
		}
		
		if(((reach >= -55  && reach <= -45) && (stack >= 35 && stack <= 40)) || ((reach >= -50 && reach <= -40) && (stack >= 45 && stack <= 50))){
			//0	ZBS F19 FRoNT PoSiTioN																"-55 to -45"	"-50 to -40"	STACK	"35 to 40"		"45 to 50"		
		}

		
		
		
		
		
		
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
			
			((TextView)findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
		}
		
		
//		> If reach is less than -65 (-66,-65,-64�) and stack is greater than 96 then contact customer service

		else if((reach >= -65) && (stack >= 96)){
			((TextView)findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
		}
		
		
//		> If reach is less than -95 (-96,-97,-98�) then contact customer service

		else if((reach <= -95)){
			((TextView)findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
		}
		
		
//		> If reach is greater than -5 (-4,-3,-3�) and stack is greater than 95 then contact customer service

		else if((reach >= -5) && (stack >= 95)){
			((TextView)findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
		}
		
		else{
			((TextView)findViewById(R.id.product_result)).setVisibility(View.VISIBLE);
			product = "Sorry. No matches were found. Speak with a Profile Design represetative today to find the best fit for you!";
		}
		
		//product = "Carbon T1/2/3/4 with brackets flipped";
		
		((TextView)findViewById(R.id.product_result)).setText(product);
	 
	}
	
	
	private void generateProduct(String productTitle, final String productPath, String imgPath, String description, String colors, String material, String armrests, String armrestsMaterial, String weight){
		
		LayoutInflater inflater = LayoutInflater.from(this);
		
		RelativeLayout listItem = (RelativeLayout) inflater.inflate(R.layout.result_item, null);
		
		listItem.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(productPath));
				startActivity(i);
			}
		});
		
		WebView webView = (WebView) listItem.findViewById(R.id.webView);

		webView.setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY);
		webView.setFocusable(true);
		webView.setHorizontalScrollBarEnabled(false);
		webView.setVerticalScrollBarEnabled(false);
		webView.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.listitemselector));

		String html = "<a href=\"" + productPath + "\">" + "<img src=\"" + imgPath + "\" width=\"100\" height=\"100\"/></a>";
		
		
		webView.loadData(html, "text/html", "utf8");
		
		webView.setWebViewClient(new WebViewClient(){
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(productPath));
				startActivity(i);
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
