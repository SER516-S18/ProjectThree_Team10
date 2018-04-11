package server.model;
/**
 *
 * @SER516  Project Three
 * @author  Group 10  #118 - #131
 * @version 1.0
 * @since   04/03/2018
 * Model class for upperface 
 */

public class UpperFace {
    private double raiseBrow;
    private double furrowBrow;

    public UpperFace() {
        setFurrowBrow(0.0);
        setRaiseBrow(0.0);
    }

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
