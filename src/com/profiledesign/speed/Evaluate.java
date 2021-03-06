package com.profiledesign.speed;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

import com.speed.model.Aeria;
import com.speed.model.F19;
import com.speed.model.F25;
import com.speed.model.F35;
import com.speed.model.Flipped;
import com.speed.model.J2;
import com.speed.model.J4;
import com.speed.model.PosFront;
import com.speed.model.PosMiddle;
import com.speed.model.PosRear;
import com.speed.model.Product;
import com.speed.model.T1Carbon;
import com.speed.model.T1Plus;
import com.speed.model.T2Carbon;
import com.speed.model.T2Plus;
import com.speed.model.T3Carbon;
import com.speed.model.T3Plus;
import com.speed.model.T4Carbon;
import com.speed.model.T4Plus;
import com.speed.model.ZBS;

public class Evaluate {
	
	
	private AppContext appContext;
	
	private static ArrayList<Product> products;
	
	public Evaluate(Context context){
		this.appContext = (AppContext) context.getApplicationContext();
		products = appContext.getProducts();
	}

	
	/**
	A	F19 T1 (J2 BRACKET)															REACH	"-185 To 0"		"15 To 85"		STACK	"55 To 95"		
	B	F19 T2 (J2 BRACKET)															REACH	"-165 To 0"		"15 To 70"		STACK	"55 To 95"		
	C	F19 T3 (J2 BRACKET)															REACH	"-165 To 0"		"15 To 75"		STACK	"55 To 95"		
	D	F19 T4 (J2 BRACKET)															REACH	"-165 To 0"		"15 To 70"		STACK	"55 To 95"		
	E	F35 T1 CARBON(J2 BRACKET)															REACH	"-170 To 0"		"15 To 85"		STACK	"55 To 95"		
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
//	3	AERiA F25 iN REAR PoSiTioN															"-65 to -55"					STACK	"55 to 135"		
//	4	AERiA F25 iN FRoNT PoSiTioN															"-45 to -35"					STACK	"55 to 135"		
//	5	AERiA F25 iN REAR PoSiTioN															"-25 to -15"					STACK	"55 to 135"		
//	6	AERiA F25 iN FRoNT PoSiTioN															"-5 to 5"						STACK	"55 to 135"		
	7	ZBS F19 REAR PoSiTioN																"-100 to -90"	"-95 to -85"	STACK	"35 to 40"		"45 to 50"
	8	ZBS F19 REAR MiDDLE PoSiTioN														"-85 to 75"		"-80 to -70"	STACK	"35 to 40"		"45 to 50"
	9	ZBS F19 FRoNT MiDDLE PoSiTioN														"-70 to 60"		"-65 to -55"	STACK	"35 to 40"		"45 to 50"
	0	ZBS F19 FRoNT PoSiTioN																"-55 to -45"	"-50 to -40"	STACK	"35 to 40"		"45 to 50"
	**/
	
	
	
	//static ArrayList<Product> products = new ArrayList<Product>();
	
	static ArrayList<String> tFamily = new ArrayList<String>();
	
	//static ArrayList<String> fFamily = new ArrayList<String>();

	public static ArrayList<String> getTFamily(){
		return tFamily;
	}
	
	public static void addT(String tItem){
		if(!tFamily.contains(tItem)){
			tFamily.add(tItem);
		}
	}
	
	public static void evaluate(int stack, int reach){
		

		
		if((reach >= -75 && reach < -60) && (stack >= 50 && stack < 140)){
			//V	AERiA T2/T4 F35 iN REAR PoSiTioN													"-75 to -65"					STACK	"50 to 135"
			Log.i("EVALUATE", "V	AERiA T2/T4 F35 iN REAR PoSiTioN");
			addT("T2");addT("T4");
			
			products.add( new Aeria(new T2Carbon(new F35(new PosRear(new Product())))) );
			products.add( new Aeria(new T4Carbon(new F35(new PosRear(new Product())))) );
			
		}
		
		if((reach >= -55 && reach < -40) && (stack >= 50 && stack < 140)){
			//X	AERiA T2/T4 F35 iN MiDDLE PoSiTioN													"-55 to -45"					STACK	"50 to 135"
			Log.i("EVALUATE", "X	AERiA T2/T4 F35 iN MiDDLE PoSiTioN");
			addT("T2");addT("T4");

			products.add( new Aeria(new T2Carbon(new F35(new PosMiddle(new Product())))) );
			products.add( new Aeria(new T4Carbon(new F35(new PosMiddle(new Product())))) );
		}
		
		if((reach >= -35 && reach < -20) && (stack >= 50 && stack < 140)){
			//Y	AERiA T2/T4 F35 iN FRoNT PoSiTioN													"-35 to -25"					STACK	"50 to 135"
			Log.i("EVALUATE", "Y	AERiA T2/T4 F35 iN FRoNT PoSiTioN");
			addT("T2");addT("T4");
			
			products.add( new Aeria(new T2Carbon(new F35(new PosFront(new Product())))) );
			products.add( new Aeria(new T4Carbon(new F35(new PosFront(new Product())))) );
			
		}
		
		if((reach >= -40 && reach < -35) && (stack >= 50 && stack < 140)){
			//Z	AERiA T2/T4 BRACKET FLiPPED F35 iN REAR PoSiTioN									"-40"							STACK	"50 to 135"
			Log.i("EVALUATE", "Z	AERiA T2/T4 BRACKET FLiPPED F35 iN REAR PoSiTioN");
			addT("T2");addT("T4");
			
			products.add( new Aeria(new T2Carbon(new F35(new PosRear(new Flipped(new Product()))))) );
			products.add( new Aeria(new T4Carbon(new F35(new PosRear(new Flipped(new Product()))))) );
			
		}
		
		if((reach >= -20  && reach < -5) && (stack >= 50 && stack < 140)){
			//1	AERiA T2/T4 BRACKET FLiPPED F35 iN MiDDLE PoSiTioN									"-20 to -10"					STACK	"50 to 135"
			Log.i("EVALUATE", "1	AERiA T2/T4 BRACKET FLiPPED F35 iN MiDDLE PoSiTioN");
			addT("T2");addT("T4");
			
			products.add( new Aeria(new T2Carbon(new F35(new PosMiddle(new Flipped(new Product()))))) );
			products.add( new Aeria(new T4Carbon(new F35(new PosMiddle(new Flipped(new Product()))))) );
		}
		
		if((reach >= 0  && reach < 15) && (stack >= 50 && stack < 140)){
			//2	AERiA T2/T4 BRACKET FLiPPED F35 iN FRoNT PoSiTioN									"0 to 10"						STACK	"50 to 95"
			Log.i("EVALUATE", "2	AERiA T2/T4 BRACKET FLiPPED F35 iN FRoNT PoSiTioN");
			addT("T2");addT("T4");
			
			products.add( new Aeria(new T2Carbon(new F35(new PosFront(new Flipped(new Product()))))) );
			products.add( new Aeria(new T4Carbon(new F35(new PosFront(new Flipped(new Product()))))) );
			
		}

		
		if((reach >= -95 && reach < -80) && (stack >= 55 && stack < 100)){
			//J	F19 REAR PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)	
			Log.i("EVALUATE", "J	F19 REAR PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)");
			addT("T1");addT("T2");addT("T3");addT("T4");
			
			products.add( new T1Carbon(new F19(new PosRear(new J4(new Product())))) );
			products.add( new T2Carbon(new F19(new PosRear(new J4(new Product())))) );
			products.add( new T3Carbon(new F19(new PosRear(new J4(new Product())))) );
			products.add( new T4Carbon(new F19(new PosRear(new J4(new Product())))) );
	
		}
		
		if((reach >= -85 && reach < -70) && (stack >= 55 && stack < 100)){
			//K	F35 REAR PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)		
			Log.i("EVALUATE", "K	F35 REAR PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)");
			addT("T1");addT("T2");addT("T3");addT("T4");
			
			products.add( new T1Carbon(new F35(new PosRear(new J4(new Product())))) );
			products.add( new T2Carbon(new F35(new PosRear(new J4(new Product())))) );
			products.add( new T3Carbon(new F35(new PosRear(new J4(new Product())))) );
			products.add( new T4Carbon(new F35(new PosRear(new J4(new Product())))) );
		}
		
		if((reach >= -80 && reach < -65) && (stack >= 55 && stack < 100)){
			//L	F19 MiDDLE REAR PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)		
			Log.i("EVALUATE", "L	F19 MiDDLE REAR PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)");
			addT("T1");addT("T2");addT("T3");addT("T4");
			
			products.add( new T1Carbon(new F19(new PosMiddle(new PosRear(new J4(new Product())))) ));
			products.add( new T2Carbon(new F19(new PosMiddle(new PosRear(new J4(new Product())))) ));
			products.add( new T3Carbon(new F19(new PosMiddle(new PosRear(new J4(new Product())))) ));
			products.add( new T4Carbon(new F19(new PosMiddle(new PosRear(new J4(new Product())))) ));
			
		}
		
		if((reach >= -65 && reach < -50) && (stack >= 55 && stack < 100)){
			//M	F35 MiDDLE PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)									"-65 To -55"					STACK	"55 To 95"
			Log.i("EVALUATE", "M	F35 MiDDLE PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)");
			addT("T1");addT("T2");addT("T3");addT("T4");
			
			products.add( new T1Carbon(new F35(new PosMiddle(new J4(new Product())))) );
			products.add( new T2Carbon(new F35(new PosMiddle(new J4(new Product())))) );
			products.add( new T3Carbon(new F35(new PosMiddle(new J4(new Product())))) );
			products.add( new T4Carbon(new F35(new PosMiddle(new J4(new Product())))) );
		}
		
		if((reach >= -65 && reach < -50) && (stack >= 55 && stack < 100)){
			//N	F19 MiDDLE FRoNT PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)								"-65 To -55"					STACK	"55 To 95"
			Log.i("EVALUATE", "N	F19 MiDDLE FRoNT PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)	");
			addT("T1");addT("T2");addT("T3");addT("T4");
			
			products.add( new T1Carbon(new F19(new PosMiddle(new PosFront(new J4(new Product())))) ));
			products.add( new T2Carbon(new F19(new PosMiddle(new PosFront(new J4(new Product())))) ));
			products.add( new T3Carbon(new F19(new PosMiddle(new PosFront(new J4(new Product())))) ));
			products.add( new T4Carbon(new F19(new PosMiddle(new PosFront(new J4(new Product())))) ));

		}
		
		if((reach >= -45 && reach < -30) && (stack >= 55 && stack < 100)){
			//P	F35 FRoNT PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)									"-45 To -35"					STACK	"55 To 95"
			Log.i("EVALUATE", "P	F35 FRoNT PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)");
			addT("T1");addT("T2");addT("T3");addT("T4");
			
			products.add( new T1Carbon(new F35(new PosFront(new J4(new Product())))) );
			products.add( new T2Carbon(new F35(new PosFront(new J4(new Product())))) );
			products.add( new T3Carbon(new F35(new PosFront(new J4(new Product())))) );
			products.add( new T4Carbon(new F35(new PosFront(new J4(new Product())))) );
		}
		
		if((reach >= -50 && reach < -35) && (stack >= 55 && stack < 100)){
			//Q	F19 FRoNT PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)									"-50 To -40"					STACK	"55 To 95"
			Log.i("EVALUATE", "Q	F19 FRoNT PoSiTioN oN ALL T+ CARBoN (J4 BRACKET)");
			addT("T1");addT("T2");addT("T3");addT("T4");
			
			products.add( new T1Carbon(new F19(new PosFront(new J4(new Product())))) );
			products.add( new T2Carbon(new F19(new PosFront(new J4(new Product())))) );
			products.add( new T3Carbon(new F19(new PosFront(new J4(new Product())))) );
			products.add( new T4Carbon(new F19(new PosFront(new J4(new Product())))) );
		}
		
		if((reach >= -30 && reach < -15) && (stack >= 55 && stack < 100)){
			//R	F35 MiDDLE PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)					"-30 To -20"					STACK	"55 To 95"
			Log.i("EVALUATE", "R	F35 MiDDLE PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)");
			addT("T1");addT("T2");addT("T3");addT("T4");
			
			products.add( new T1Carbon(new F35(new PosMiddle(new Flipped(new J4(new Product())))) ));
			products.add( new T2Carbon(new F35(new PosMiddle(new Flipped(new J4(new Product())))) ));
			products.add( new T3Carbon(new F35(new PosMiddle(new Flipped(new J4(new Product())))) ));
			products.add( new T4Carbon(new F35(new PosMiddle(new Flipped(new J4(new Product())))) ));
			
		}
		
		if((reach >= -30 && reach < -15) && (stack >= 55 && stack < 100)){
			//S	F19 MiDDLE FRoNT PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)				"-30 To -20"					STACK	"55 To 95"
			Log.i("EVALUATE", "S	F19 MiDDLE FRoNT PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)	");
			addT("T1");addT("T2");addT("T3");addT("T4");
			
			products.add( new T1Carbon(new F19(new PosMiddle(new PosFront(new Flipped(new J4(new Product())))) )));
			products.add( new T2Carbon(new F19(new PosMiddle(new PosFront(new Flipped(new J4(new Product())))) )));
			products.add( new T3Carbon(new F19(new PosMiddle(new PosFront(new Flipped(new J4(new Product())))) )));
			products.add( new T4Carbon(new F19(new PosMiddle(new PosFront(new Flipped(new J4(new Product())))) )));
			
			
		}
		
		if((reach >= -10 && reach < 5) && (stack >= 55 && stack < 100)){
			//T	F35 FRoNT PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)					"-10 to 0"						STACK	"55 To 95"
			Log.i("EVALUATE", "T	F35 FRoNT PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)");
			addT("T1");addT("T2");addT("T3");addT("T4");
			
			products.add( new T1Carbon(new F35(new PosFront(new Flipped(new J4(new Product()))))) );
			products.add( new T2Carbon(new F35(new PosFront(new Flipped(new J4(new Product()))))) );
			products.add( new T3Carbon(new F35(new PosFront(new Flipped(new J4(new Product()))))) );
			products.add( new T4Carbon(new F35(new PosFront(new Flipped(new J4(new Product()))))) );
			
		}
		
		if((reach >= -15 && reach < 0) && (stack >= 55 && stack < 100)){
			//U	F19 FRoNT PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)					"-15 to -5"						STACK	"55 To 95"
			Log.i("EVALUATE", "U	F19 FRoNT PoSiTioN BRACKET FLiPPED oN ALL T+ CARBoN (J4 BRACKET)");
			addT("T1");addT("T2");addT("T3");addT("T4");
			
			products.add( new T1Carbon(new F19(new PosFront(new Flipped(new J4(new Product()))))) );
			products.add( new T2Carbon(new F19(new PosFront(new Flipped(new J4(new Product()))))) );
			products.add( new T3Carbon(new F19(new PosFront(new Flipped(new J4(new Product()))))) );
			products.add( new T4Carbon(new F19(new PosFront(new Flipped(new J4(new Product()))))) );
			
		}
		
		
		if(((reach >= -185 && reach < 5) || (reach >= 15 && reach < 90)) && (stack >= 55 && stack < 100)){
			//A	F19 T1 (J2 BRACKET)
			Log.i("EVALUATE", "A	F19 T1 (J2 BRACKET)");

			addT("T1");
			
			products.add( (new T1Plus(new F19(new J2(new Product())))));
		}
		
		if(((reach >= -170 && reach < 5) || (reach >= 15 && reach < 90)) && (stack >= 55 && stack < 100)){
			//E	F35 T1 (J2 BRACKET)	
			Log.i("EVALUATE", "E	F35 T1 (J2 BRACKET");
			
			addT("T1");
			
			products.add( (new T1Plus(new F35(new J2(new Product())))));
			
		}
		
		if(((reach >= -165 && reach < 5) || (reach >= 15 && reach < 75)) && (stack >= 55 && stack < 100)){
			//B	F19 T2 (J2 BRACKET)	
			Log.i("EVALUATE", "B	F19 T2 (J2 BRACKET)");
			addT("T2");
			
			products.add( (new T2Plus(new F19(new J2(new Product())))));
		}
		
		if(((reach >= -165 && reach < 5) || (reach >= 15 && reach < 70)) && (stack >= 55 && stack < 100)){
			//F	F35 T2 (J2 BRACKET)	
			Log.i("EVALUATE", "F	F35 T2 (J2 BRACKET)");
			addT("T2");
			
			products.add( (new T2Plus(new F35(new J2(new Product())))));
		}
		
		if(((reach >= -165 && reach < 5) || (reach >= 15 && reach < 80)) && (stack >= 55 && stack < 100)){
			//C	F19 T3 (J2 BRACKET)
			Log.i("EVALUATE", "C	F19 T3 (J2 BRACKET)");
			addT("T3");
			
			products.add( (new T3Plus(new F19(new J2(new Product())))));
		}
		
		if(((reach >= -155 && reach < 5) || (reach >= 15 && reach < 75)) && (stack >= 55 && stack < 100)){
			//G F35 T3 (J2 BRACKET)		
			Log.i("EVALUATE", "G F35 T3 (J2 BRACKET)");
			addT("T3");
			
			products.add( (new T3Plus(new F35(new J2(new Product())))));
			
		}
		
		if(((reach >= -165 && reach < 5) || (reach >= 15 && reach < 75)) && (stack >= 55 && stack < 100)){
			//D	F19 T4 (J2 BRACKET)	
			Log.i("EVALUATE", "D	F19 T4 (J2 BRACKET)");
			addT("T4");
			
			products.add( (new T4Plus(new F19(new J2(new Product())))));
		}
	
		if(((reach >= -150 && reach < 5) || (reach >= 15 && reach < 75)) && (stack >= 55 && stack < 100)){
			//H	F35 T4 (J2 BRACKET)		
			Log.i("EVALUATE", "H	F35 T4 (J2 BRACKET)");
			addT("T4");
			
			products.add( (new T4Plus(new F35(new J2(new Product())))));
			
		}
		

		
//		if((reach >= -65  && reach <= -55) && (stack >= 55 && stack <= 135)){
//			//3	AERiA F25 iN REAR PoSiTioN															"-65 to -55"					STACK	"55 to 135"
//			Log.i("EVALUATE", "3	AERiA F25 iN REAR PoSiTioN");
//			
//			products.add( new Aeria(new F25(new PosRear(new Product()))) );
//		}
//			
//		if((reach >= -45  && reach <= -35) && (stack >= 55 && stack <= 135)){
//			//4	AERiA F25 iN FRoNT PoSiTioN															"-45 to -35"					STACK	"55 to 135"
//			Log.i("EVALUATE", "4	AERiA F25 iN FRoNT PoSiTioN");
//			
//			products.add( new Aeria(new F25(new PosFront(new Product()))) );
//			
//		}
//			
//		if((reach >= -25  && reach <= -15) && (stack >= 55 && stack <= 135)){
//			//5	AERiA F25 iN REAR PoSiTioN															"-25 to -15"					STACK	"55 to 135"
//			Log.i("EVALUATE", "5	AERiA F25 iN REAR PoSiTioN");
//			
//			products.add( new Aeria(new F25(new PosRear(new Product()))) );
//		}
//		
//		if((reach >= -5  && reach <= -5) && (stack >= 55 && stack <= 135)){
//			//6	AERiA F25 iN FRoNT PoSiTioN															"-5 to 5"						STACK	"55 to 135"
//			Log.i("EVALUATE", "6	AERiA F25 iN FRoNT PoSiTioN");
//			
//			products.add( new Aeria(new F25(new PosFront(new Product()))) );
//		}
		
//		else if((reach >= -90 && reach <= -40) && (stack >= 30 && stack <= 60)){
		
		if(((reach >= -100  && reach < -85) && (stack >= 35 && stack < 45)) || ((reach >= -95 && reach < -80) && (stack >= 45 && stack < 55))){
			//7	ZBS F19 REAR PoSiTioN																"-100 to -90"	"-95 to -85"	STACK	"35 to 40"		"45 to 50"
			Log.i("EVALUATE", "7	ZBS F19 REAR PoSiTioN");
			
			products.add( new ZBS(new F19(new PosRear(new Product()))) );
		}
		
		if(((reach >= -85  && reach < -70) && (stack >= 35 && stack < 45)) || ((reach >= -80 && reach < -65) && (stack >= 45 && stack < 55))){
			//8	ZBS F19 REAR MiDDLE PoSiTioN														"-85 to 75"		"-80 to -70"	STACK	"35 to 40"		"45 to 50"
			Log.i("EVALUATE", "8	ZBS F19 REAR MiDDLE PoSiTioN");
			
			products.add( new ZBS(new F19(new PosRear(new PosMiddle(new Product())))) );
			
		}
		
		if(((reach >= -70  && reach < -55) && (stack >= 35 && stack < 45)) || ((reach >= -65 && reach < -50) && (stack >= 45 && stack < 55))){
			//9	ZBS F19 FRoNT MiDDLE PoSiTioN														"-70 to 60"		"-65 to -55"	STACK	"35 to 40"		"45 to 50"
			Log.i("EVALUATE", "9	ZBS F19 FRoNT MiDDLE PoSiTioN");
			
			products.add( new ZBS(new F19(new PosFront(new PosMiddle(new Product())))) );
			
		}
		
		if(((reach >= -55  && reach < -40) && (stack >= 35 && stack < 45)) || ((reach >= -50 && reach < -35) && (stack >= 45 && stack < 55))){
			//0	ZBS F19 FRoNT PoSiTioN																"-55 to -45"	"-50 to -40"	STACK	"35 to 40"		"45 to 50"
			Log.i("EVALUATE", "0	ZBS F19 FRoNT PoSiTioN");
			
			products.add( new ZBS(new F19(new PosFront(new Product()))) );

		}

		
		
		if(tFamily.size() > 2){
			Log.i("EVALUATE", "MORE THAN 2 T Family Items!!!");
		}
		
	}

}
