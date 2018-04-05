import java.util.Observable;


public class Expressive{


    private boolean blink;
    private boolean rightWink;
    private boolean leftWink;

    private double lookingRight;
    private double lookingLeft;
    private double eyeBrowRaise;
    private double eyesOpen;
    private double smile;
    private double clench;
    private double lookingUp;
    private double lookingDown;

    public Expressive(){}

    /**
     * Copy constructor
     *
     * @param face
     */
    public Expressive(Expressive face) {
        lookingRight = face.lookingRight;
        blink = face.blink;
        rightWink = face.rightWink;
        leftWink = face.leftWink;
        lookingLeft = face.lookingLeft;
        eyeBrowRaise = face.eyeBrowRaise;
        eyesOpen = face.eyesOpen;
        smile = face.smile;
        clench = face.clench;
        lookingUp = face.lookingUp;
        lookingDown = face.lookingDown;
    }

    public boolean isBlink() {
        return blink;
    }

    public void setBlink(boolean blink) {
        this.blink = blink;
    }

    public boolean isRightWink() {
        return rightWink;
    }

    public void setRightWink(boolean rightWink) {
        this.rightWink = rightWink;
    }

    public boolean isLeftWink() {
        return leftWink;
    }

    public void setLeftWink(boolean leftWink) {
        this.leftWink = leftWink;
    }

    public double getLookingLeft() {
        return lookingLeft;
    }

    public void setLookingLeft(double lookingLeft) {
        this.lookingLeft = lookingLeft;
    }

    public double getLookingRight() {
        return lookingRight;
    }

    public void setLookingRight(double lookingRight) {
        this.lookingRight = lookingRight;
    }

    public double getRaiseBrow() {
        return eyeBrowRaise;
    }

    public void setRaiseBrow(double raiseBrow) {
        this.eyeBrowRaise = raiseBrow;
    }

    public double getEyesOpen() {
        return eyesOpen;
    }

    public void setEyesOpen(double eyesOpen) {
        this.eyesOpen = eyesOpen;
    }

    public double getSmile() {
        return smile;
    }

    public void setSmile(double smile) {
        this.smile = smile;
    }

    public double getClench() {
        return clench;
    }

    public void setClench(double clench) {
        this.clench = clench;
    }

    public double getLookingUp() {
        return lookingUp;
    }

    public void setLookingUp(double lookingUp) {
        this.lookingUp = lookingUp;
    }

    public double getLookingDown() {
        return lookingDown;
    }

    public void setLookingDown(double lookingDown) {
        this.lookingDown = lookingDown;
    }

    @Override
    public String toString() {
        return "Expressive{" +
                ", blink=" + blink +
                ", rightWink=" + rightWink +
                ", leftWink=" + leftWink +
                "lookingRight=" + lookingRight +
                ", lookingLeft=" + lookingLeft +
                ", eyeBrowRaise=" + eyeBrowRaise +
                ", eyesOpen=" + eyesOpen +
                ", smile=" + smile +
                ", clench=" + clench +
                ", lookingUp=" + lookingUp +
                ", lookingDown=" + lookingDown +
                '}';
    }

    public boolean equals(Expressive face){

        return  lookingRight == face.lookingRight &&
                blink == face.blink &&
                rightWink == face.rightWink &&
                leftWink == face.leftWink &&
                lookingLeft == face.lookingLeft &&
                eyeBrowRaise == face.eyeBrowRaise &&
                eyesOpen == face.eyesOpen &&
                smile == face.smile &&
                clench == face.clench &&
                lookingUp == face.lookingUp &&
                lookingDown == face.lookingDown;
    }
}