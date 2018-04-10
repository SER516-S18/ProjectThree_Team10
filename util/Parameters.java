package util;

import java.util.HashMap;

public class Parameters {

    
    HashMap<String, Double> lowerFace = hashvalues.getLf();
	HashMap<String , Double > upperFace = hashvalues.getUf();
	HashMap<String , Integer> eyes = hashvalues.geteye();
	HashMap<String, Double> performanceMatrix = hashvalues.getPm();
   
    public Parameters(
                        double raiseBrow, 
                        double smile, 
                        Integer blink
                       ) {
        
        setRaiseBrow(raiseBrow);
        setSmile(smile);
        setBlink(blink);
    }

    /**
     * @param time the time to set
     */

    /**
     * @param raiseBrow the raiseBrow to set
     */
    public void setRaiseBrow(double raiseBrow) {
    	
        upperFace.put("Raise Brow", raiseBrow);
        System.out.println(raiseBrow);
        hashvalues.setUf(upperFace);
    }

    /**
     * @return the raiseBrow
     */
    public double getRaiseBrow() {
       Double raisebrow = hashvalues.upperFace.get("Raise Brow");
       System.out.println(raisebrow);
       return raisebrow;
    }

    /**
     * @param smile the smile to set
     */
    public void setSmile(double smile) {
        lowerFace.put("Smile",smile);
        System.out.println(smile);
        hashvalues.setLf(lowerFace);
    }

    /**
     * @return the smile
     */
    public double getSmile() {
    	 Double smile = lowerFace.get("Smile");
    	 System.out.println(smile);
         return smile;
    }

    /**
     * @param blink the blink to set
     */
    public void setBlink(Integer blink) {
        eyes.put("Blink", blink);
        System.out.println(blink);
        hashvalues.seteye(eyes);
    }

    /**
     * @return the blink
     */
    public Integer getBlink() {
        Integer blink = eyes.get("Blink");
        System.out.println(blink);
        return blink;
    }

    /**
     * @param interest the interest to set
     */
   

    
}