package server.model;
/**
 *
 * @SER516  Project Three
 * @author  Group 10  #118 - #131
 * @version 1.0
 * @since   04/03/2018
 * Class for Eye Model
 */
public class Eye {
    private boolean blink;
    private boolean winkLeft;
    private boolean winkRight;
    private boolean lookLeft;
    private boolean lookRight;

    public Eye() {
        setBlink(false);
        setWinkLeft(false);
        setWinkRight(false);
        setLookRight(false);
        setLookRight(false);
    }
    
    public Eye(boolean blink, boolean winkLeft, boolean winkRight, boolean lookLeft, boolean lookRight) {
        this.blink = blink;
        this.winkLeft = winkLeft;
        this.winkRight = winkRight;
        this.lookLeft = lookLeft;
        this.lookRight = lookRight;
    }

    /**
     * @param blink the blink to set
     */
    public void setBlink(boolean blink) {
        this.blink = blink;
    }
    
    /**
     * @return the blink
     */
    public boolean getBlink() {
        return blink;
    }

    /**
     * @param winkLeft the winkLeft to set
     */
    public void setWinkLeft(boolean winkLeft) {
        this.winkLeft = winkLeft;
    }

    /**
     * @return the left wink
     */
    public boolean getWinkLeft() {
        return winkLeft;
    }

    /**
     * @param winkRight the winkRight to set
     */
    public void setWinkRight(boolean winkRight) {
        this.winkRight = winkRight;
    }

    /**
     * @return the right wink
     */
    public boolean getWinkRight() {
        return winkRight;
    }

    /**
     * @param lookLeft the lookLeft to set
     */
    public void setLookLeft(boolean lookLeft) {
        this.lookLeft = lookLeft;
    }

    /**
     * @return the left look
     */
    public boolean getLookLeft() {
        return lookLeft;
    }

    /**
     * @param lookRight the lookRight to set
     */
    public void setLookRight(boolean lookRight) {
        this.lookRight = lookRight;
    }

    /**
     * @return the right look
     */
    public boolean getLookRight() {
        return lookRight;
    }

}
