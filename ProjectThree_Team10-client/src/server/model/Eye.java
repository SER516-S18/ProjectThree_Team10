package server.model;

public class Eye {
	 private Integer blink;
	   private Integer winkLeft;
	    private Integer winkRight;
	    private Integer lookLeft;
	    private Integer lookRight;
	public Eye() {
		 this.blink = hashvalues.eyes.get("Blink");
	     this.winkLeft = hashvalues.eyes.get("wink Left");
	     this.winkRight = hashvalues.eyes.get("wink Right");
	     this.lookLeft = hashvalues.eyes.get("look left");
	     this.lookRight = hashvalues.eyes.get("look Right");
		
	}
	public void setBlink(Integer blink) {
        hashvalues.eyes.put("Blink", blink);
    }
    
    /**
     * @return the blink
     */
    public Integer getBlink() {
        return hashvalues.eyes.get("Blink");
    }

    /**
     * @param winkLeft the winkLeft to set
     */
    public void setWinkLeft(Integer winkLeft) {
        hashvalues.eyes.put("wink left", winkLeft);
    }

    /**
     * @return the left wink
     */
    public Integer getWinkLeft() {
        return hashvalues.eyes.get("wink left");
    }

    /**
     * @param winkRight the winkRight to set
     */
    public void setWinkRight(Integer winkRight) {
    	hashvalues.eyes.put("wink right", winkRight);
    }

    /**
     * @return the right wink
     */
    public Integer getWinkRight() {
        return hashvalues.eyes.get("wink right");
    }

    /**
     * @param lookLeft the lookLeft to set
     */
    public void setLookLeft(Integer lookLeft) {
        hashvalues.eyes.put("look left", lookLeft);
    }

    /**
     * @return the left look
     */
    public Integer getLookLeft() {
        return hashvalues.eyes.get("look left");
    }

    /**
     * @param lookRight the lookRight to set
     */
    public void setLookRight(Integer lookRight) {
    	hashvalues.eyes.put("look right", lookRight);
    }

    /**
     * @return the right look
     */
    public Integer getLookRight() {
        return hashvalues.eyes.get("look right");
    }

}
