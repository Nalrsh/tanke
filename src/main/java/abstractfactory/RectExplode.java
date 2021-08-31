//package abstractfactory;
//
//import tankone.Audio;
//import tankone.ResourceMgr;
//import tankone.TankTwo;
//
//import java.awt.*;
//
//public class RectExplode extends BaseExplode {
//
//    public static int WIDTH= ResourceMgr.explodes[0].getWidth();
//        public static int HEIGH=ResourceMgr.explodes[0].getHeight();
//        private int x,y;
//        //private boolean living=true;
//        TankTwo tf=null;
//        private int step=0;
//
//        public RectExplode(int x, int y, TankTwo tf){
//            this.x=x;
//            this.y=y;
//            this.tf=tf;
//            new Thread(()->new Audio("audio/explode.wav").play()).start();
//        }
//
//        @Override
//        public void paint(Graphics g){
//            Color c =g.getColor();
//            g.setColor(Color.RED);
//            g.fillRect(x,y,10*step,10*step);
//            step++;
//            if(step>=10)
//                tf.explodes.remove(this);
//            g.setColor(c);
//
//            //g.drawImage(ResourceMgr.explodes[step++],x,y,null);
//
//        }
//
//}
