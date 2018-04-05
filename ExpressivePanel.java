import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpressivePanel extends JPanel {

    private List<IExpressive> shapes = new ArrayList<>();
    private LeftEye leftEye = new LeftEye();
    private RightEye rightEye = new RightEye();
    private LeftEyeLash leftEyeLash = new LeftEyeLash();
    private RightEyeLash rightEyeLash = new RightEyeLash();
    private LeftEyeBall leftEyeBall = new LeftEyeBall();
    private RightEyeBall rightEyeBall = new RightEyeBall();
    private LeftEyeBrow leftEyeBrow = new LeftEyeBrow();
    private RightEyeBrow rightEyeBrow = new RightEyeBrow();
    private Mouth mouth = new Mouth();
    private Smile smile = new Smile();
    private Clench clench = new Clench();
    BufferedImage img = null;
    Expressive face = null;

    public ExpressivePanel(){
        shapes.add(leftEye);
        shapes.add(rightEye);
        shapes.add(leftEyeLash);
        shapes.add(rightEyeLash);
        shapes.add(leftEyeBall);
        shapes.add(rightEyeBall);
        shapes.add(leftEyeBrow);
        shapes.add(rightEyeBrow);
        shapes.add(mouth);
        shapes.add(smile);
        shapes.add(clench);
        File f = new File("C:\\Users\\Ejaz\\Desktop\\face1.png");

        try {
            img = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        setBackground(Color.WHITE);
        g2.drawImage(img, 0,0,null);

        for (IExpressive e : shapes){
            g2.setColor(e.getColor());
            if(e.getFill()) {
                g2.fill(e);
            } else {
                g2.setStroke(new BasicStroke(3));
                g2.draw(e);
            }
        }
    }

    public void Affect(Expressive f){

        if(face == null || !face.equals(f)){
            for (IExpressive e : shapes)
                e.Reset();

            face = new Expressive(f);
            //Blink
            leftEye.Blink(face.isBlink());
            rightEye.Blink(face.isBlink());
            leftEyeLash.Blink(face.isBlink());
            rightEyeLash.Blink(face.isBlink());
            leftEyeBall.Blink(face.isBlink());
            rightEyeBall.Blink(face.isBlink());

            //Left wink
            leftEye.Blink(face.isLeftWink());
            leftEyeLash.Blink(face.isLeftWink());
            leftEyeBall.Blink(face.isLeftWink());

            //Right wink
            rightEye.Blink(face.isRightWink());
            rightEyeLash.Blink(face.isRightWink());
            rightEyeBall.Blink(face.isRightWink());

            //Look left
            leftEyeBall.LookLeft(face.getLookingLeft());
            rightEyeBall.LookLeft(face.getLookingLeft());

            //Look right
            leftEyeBall.LookRight(face.getLookingRight());
            rightEyeBall.LookRight(face.getLookingRight());

            //Look up
            leftEyeBall.LookUp(face.getLookingUp());
            rightEyeBall.LookUp(face.getLookingUp());

            //Look down
            leftEyeBall.LookDown(face.getLookingDown());
            rightEyeBall.LookDown(face.getLookingDown());

            //Eyebrow raise
            leftEyeBrow.Raise(face.getRaiseBrow());
            rightEyeBrow.Raise(face.getRaiseBrow());

            //Smile and Clench
            smile.Set(face.getSmile());
            clench.Set(face.getClench());
            mouth.Set(face.getSmile());
            mouth.Set(face.getClench());

            Graphics2D g2 =(Graphics2D)getGraphics();
            paintComponent(g2);
        }


    }


}