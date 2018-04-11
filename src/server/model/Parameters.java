package server.model;
/**
 *
 * @SER516  Project Three
 * @author  Group 10  #118 - #131
 * @version 1.0
 * @since   04/03/2018
 * Parameters class for Sending message from server to client 
 */

public class Parameters {
    private Eye eye;
    private LowerFace lowerFace;
    private UpperFace upperFace;
    private PerformanceMet performance;
    private double time;

    public Parameters() { }

    public Parameters(Eye eye, LowerFace lowerFace, UpperFace upperFace, PerformanceMet performance, double time) {
        this.eye = eye;
        this.lowerFace = lowerFace;
        this.upperFace = upperFace;
        this.performance = performance;
        this.time = time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * @return the time
     */
    public double getTime() {
        return time;
    }

    /**
     * @param eye the eye to set
     */
    public void setEye(Eye eye) {
        this.eye = eye;
    }

    /**
     * @return the eye
     */
    public Eye getEye() {
        return eye;
    }

    /**
     * @param lowerFace the lowerFace to set
     */
    public void setLowerFace(LowerFace lowerFace) {
        this.lowerFace = lowerFace;
    }
    
    /**
     * @return the lowerFace
     */
    public LowerFace getLowerFace() {
        return lowerFace;
    }

    /**
     * @param performance the performance to set
     */
    public void setPerformance(PerformanceMet performance) {
        this.performance = performance;
    }

    /**
     * @return the performance
     */
    public PerformanceMet getPerformance() {
        return performance;
    }

    /**
     * @param upperFace the upperFace to set
     */
    public void setUpperFace(UpperFace upperFace) {
        this.upperFace = upperFace;
    }

    /**
     * @return the upperFace
     */
    public UpperFace getUpperFace() {
        return upperFace;
    }

}
