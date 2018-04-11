package client.model;

/**
 * @author Group10
 * @version 1.0
 * Parameters class 
 */
public class Parameters {
    private Eye eye;
    private LowerFace lowerFace;
    private UpperFace upperFace;
    private PerformanceMet performance;
    private double time;

    /**
     * Constructor for Parameters class
     */
    public Parameters() { }

    /**
     * Constructor for Parameters class
     * @param eye
     * @param lowerFace
     * @param upperFace
     * @param performance
     * @param time
     */
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
