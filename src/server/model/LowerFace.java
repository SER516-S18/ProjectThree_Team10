package server.model;
/**
 *
 * @SER516  Project Three
 * @author  Group 10  #118 - #131
 * @version 1.0
 * @since   04/03/2018
 * Lower Face model class
 */
public class LowerFace {
    private double smile;
    private double clench;
    private double smirkLeft;
    private double smirkRight;
    private double laugh;

    public LowerFace() {
        setClench(0.0);
        setLaugh(0.0);
        setSmile(0.0);
        setSmirkLeft(0.0);
        setSmirkRight(0.0);
    }

    public LowerFace(double smile, double clench, double smirkLeft, double smirkRight, double laugh) {
        this.smile = smile;
        this.clench = clench;
        this.smirkLeft = smirkLeft;
        this.smirkRight = smirkRight;
        this.laugh = laugh;
    }

    /**
     * @param smile the smile to set
     */
    public void setSmile(double smile) {
        this.smile = smile;
    }

    /**
     * @return the smile
     */
    public double getSmile() {
        return smile;
    }

    /**
     * @param clench the clench to set
     */
    public void setClench(double clench) {
        this.clench = clench;
    }

    /**
     * @return the clench
     */
    public double getClench() {
        return clench;
    }

    /**
     * @param smirkLeft the smirkLeft to set
     */
    public void setSmirkLeft(double smirkLeft) {
        this.smirkLeft = smirkLeft;
    }

    /**
     * @return the smirkLeft
     */
    public double getSmirkLeft() {
        return smirkLeft;
    }

    /**
     * @param smirkRight the smirkRight to set
     */
    public void setSmirkRight(double smirkRight) {
        this.smirkRight = smirkRight;
    }

    /**
     * @return the smirkRight
     */
    public double getSmirkRight() {
        return smirkRight;
    }

    /**
     * @param laugh the laugh to set
     */
    public void setLaugh(double laugh) {
        this.laugh = laugh;
    }

    /**
     * @return the laugh
     */
    public double getLaugh() {
        return laugh;
    }
}
