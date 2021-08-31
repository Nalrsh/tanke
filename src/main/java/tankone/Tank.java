package tankone;

import java.awt.*;
import java.util.Random;


public class Tank {
    int x,y;
    Dir dir=Dir.DOWM;
    public static final int SPEED=4;

    public static int WIDTH=ResourceMgr.goodtankU.getWidth();
    public static int HEIGH=ResourceMgr.goodtankU.getHeight();

    Rectangle rect= new Rectangle();

    private Random random=new Random();

    private boolean moving=true;
    TankTwo tf;
    private boolean living=true;

    Group group=Group.BAD;
    FireStrategy fs;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }


    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Tank(int x, int y, Dir dir,Group group, TankTwo tf ){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.group=group;
        this.tf=tf;

        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGH;

        if(group==Group.GOOD) {
            String goodFSName = (String)PropertyMgr.get("goodFS");
            try {
                fs = (FireStrategy) Class.forName(goodFSName).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            String badFSName=(String)PropertyMgr.get("badFS");

            try {
                fs=(FireStrategy) Class.forName(badFSName).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

    }
    public void paint(Graphics g){
        if(!living) tf.Tanks.remove(this);


        switch (dir) {
            case LEFT:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodtankL:ResourceMgr.badtankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodtankR:ResourceMgr.badtankR,x,y,null);
                break;
            case UP:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodtankU:ResourceMgr.badtankU,x,y,null);
                break;
            case DOWM:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodtankD:ResourceMgr.badtankD,x,y,null);
                break;
        }

        move();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void die(){
        this.living=false;
    }

    public void move(){
        if(!moving) return;

        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case UP :
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWM:
                y+=SPEED;
                break;
        }

        if(this.group==Group.BAD&&random.nextInt(100)>95)
            this.fire();
        if(this.group==Group.BAD&&random.nextInt(100)>95)
            randomDir();
        boundsCheck();

        rect.x=this.x;
        rect.y=this.y;

    }

    public void boundsCheck() {
        if(this.x<2) x=2;
        if (this.y<28) y=28;
        if (this.x> TankTwo.GAME_WIDTH-Tank.WIDTH-2) x= TankTwo.GAME_WIDTH-Tank.WIDTH-2;
        if(this.y> TankTwo.GAME_HEIGHT-Tank.HEIGH-2) y= TankTwo.GAME_HEIGHT-Tank.HEIGH-2;
    }

    private void  randomDir(){
        this.dir=Dir.values() [random.nextInt(4)];

    }
    public void fire(){
        fs.fire(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
