package tankone;

import java.awt.*;

public class Explode {
    public static int WIDTH=ResourceMgr.explodes[0].getWidth();
    public static int HEIGH=ResourceMgr.explodes[0].getHeight();
    private int x,y;
    //private boolean living=true;
    TankTwo tf=null;
    private int step=0;

    public Explode(int x, int y, TankTwo tf){
        this.x=x;
        this.y=y;
        this.tf=tf;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }
    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);

        if(step>=ResourceMgr.explodes.length)
            tf.explodes.remove(this);

    }

}
