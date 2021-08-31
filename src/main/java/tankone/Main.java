package tankone;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankTwo tf =new TankTwo();

        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for(int i=0;i<initTankCount;i++)
        {
            tf.Tanks.add(new Tank(80+i*80,200,Dir.DOWM,Group.BAD,tf));
        }
        new Thread(()->new Audio("audio/war.wav").play()).start();
        while(true){
            Thread.sleep(50);
            tf.repaint();
        }


    }
}