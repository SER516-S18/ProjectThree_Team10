package server.model;

public class LowerFace {
	private double smile;
	private double clench;
    private double smirkLeft;
    private double smirkRight;
    private double laugh;
    
    public LowerFace() {
    		this.smile = hashvalues.lowerFace.get("Smile");
	    this.clench = hashvalues.lowerFace.get("Clench");
	    this.smirkLeft = hashvalues.lowerFace.get("Smirk Right");
	    this.smirkRight = hashvalues.lowerFace.get("Smirk Left");
	    this.laugh = hashvalues.lowerFace.get("Laugh");
    }
    public void setSmile(double smile) {
        hashvalues.lowerFace.put("Smile", smile);
    }

    /**
     * @return the smile
     */
    public double getSmile() {
        return hashvalues.lowerFace.get("Smile");
    }

    /**
     * @param clench the clench to set
     */
    public void setClench(double clench) {
        hashvalues.lowerFace.put("Clench", clench);
    }

    /**
     * @return the clench
     */
    public double getClench() {
        return hashvalues.lowerFace.get("Clench");
    }

    /**
     * @param smirkLeft the smirkLeft to set
     */
    public void setSmirkLeft(double smirkLeft) {
        hashvalues.lowerFace.put("Smirk Left", smirkLeft);
    }
    public double getSmirkLeft() {
        return hashvalues.lowerFace.get("Smirk Left");
    }

    /**
     * @param smirkRight the smirkRight to set
     */
    public void setSmirkRight(double smirkRight) {
        hashvalues.lowerFace.put("Smirk Right", smirkRight);
    }

    /**
     * @return the smirkRight
     */
    public double getSmirkRight() {
        return hashvalues.lowerFace.get("Smirk Right");
    }

    /**
     * @param laugh the laugh to set
     */
    public void setLaugh(double laugh) {
        hashvalues.lowerFace.put("Laugh", laugh);
    }

    /**
     * @return the laugh
     */
    public double getLaugh() {
        return hashvalues.lowerFace.get("Laugh");
    }

}
