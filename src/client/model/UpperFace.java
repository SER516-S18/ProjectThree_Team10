package client.model;

/**
 * @author Group10
 * @version 1.0
 * UpperFace class 
 */
public class UpperFace {
    private double raiseBrow;
    private double furrowBrow;

    /**
     * Constructor for UpperFace class
     * @param raiseBrow
     * @param furrowBrow
     */
    public UpperFace(double raiseBrow, double furrowBrow) {
        this.raiseBrow = raiseBrow;
        this.furrowBrow = furrowBrow;
    }

    /**
     * @param furrowBrow the furrowBrow to set
     */
    public void setFurrowBrow(double furrowBrow) {
        this.furrowBrow = furrowBrow;
    }

    /**
     * @return the furrowBrow
     */
    public double getFurrowBrow() {
        return furrowBrow;
    }

    /**
     * @param raiseBrow the raiseBrow to set
     */
    public void setRaiseBrow(double raiseBrow) {
        this.raiseBrow = raiseBrow;
    }

    /**
     * @return the raiseBrow
     */
    public double getRaiseBrow() {
        return raiseBrow;
    }
    
}
