package team10;

import java.util.HashMap;

public class hashvalues {
	 
	static HashMap<String , Double> lowerFace = new HashMap<String,Double>();
	 static HashMap<String , Double> upperFace = new HashMap<String, Double>();  
	 static HashMap<String , Integer> eyes = new HashMap<String , Integer>();  
	 static HashMap<String , Double> performanceMatrix = new HashMap<String , Double>(); 
	 
	 public static void initialize()
	 {
		 
		 
		 
		 
		 lowerFace.put("Smile", 1.0);
		 lowerFace.put("Clench", 0.0);
		 lowerFace.put("Smirk Left", 0.0);
		 lowerFace.put("Smirk Right", 0.0);
		 lowerFace.put("Laugh", 0.0);
		 
		 upperFace.put("Raise Brow", 1.0);
		 upperFace.put("Furrow Brow", 0.0);
		
		 eyes.put("Blink", 1);
		 eyes.put("wink left", 0);
		 eyes.put("wink right", 0);
		 eyes.put("look left", 0);
		 eyes.put("look right", 1);
		 
		 performanceMatrix.put("abc", 1.0);
		 performanceMatrix.put("2", 1.0);
		 performanceMatrix.put("3", 0.0);
		 performanceMatrix.put("4", 0.0);
	 }
	 
	 public static HashMap<String, Double> getLf() {
		    return lowerFace;
		}
	 public static HashMap<String, Double> getUf() {
		    return upperFace;
		}
	 
	 public static HashMap<String, Integer> geteye() {
		    return eyes;
		}
	 public static HashMap<String, Double> getPm() {
		    return performanceMatrix;
		}
	 
	 public static void setLf(HashMap<String, Double> lf) {
		   	lowerFace.putAll(lf);
		   	System.out.println(lowerFace);
		}
	 public static void setUf( HashMap<String, Double> uf ) {
		    upperFace.putAll(uf);
		    System.out.println(upperFace);
		}
	 
	 public static void seteye(HashMap<String, Integer> eye) {
		    eyes.putAll(eye);
		    System.out.println(eyes);
		}
	 public static void  setPm(HashMap<String, Double> Pm) {
		    performanceMatrix.putAll(Pm);
		    System.out.println(performanceMatrix);
		}

}


