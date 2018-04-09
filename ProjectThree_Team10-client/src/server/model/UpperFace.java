package server.model;

public class UpperFace {
	private double furrowBrow;
	private double raiseBrow;
    
    
    public UpperFace() {
    		this.furrowBrow = hashvalues.upperFace.get("Furrow Brow");
	    this.raiseBrow = hashvalues.upperFace.get("Raise Brow");
    }
	 public void setFurrowBrow(double furrowBrow) {
	        hashvalues.upperFace.put("Furrow Brow", furrowBrow);
	    }

	    /**
	     * @return the furrowBrow
	     */
	    public double getFurrowBrow() {
	        return hashvalues.upperFace.get("Furrow Brow");
	    }

	    /**
	     * @param raiseBrow the raiseBrow to set
	     */
	    public void setRaiseBrow(double raiseBrow) {
	        hashvalues.upperFace.put("Raise Brow", raiseBrow);
	    }

	    /**
	     * @return the raiseBrow
	     */
	    public double getRaiseBrow() {
	        return hashvalues.upperFace.get("Raise Brow");
	    }

}
