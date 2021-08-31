package tankone;

import java.awt.*;

public class Bullet {
    private static final int SPEED=10;
    public static int WIDTH=ResourceMgr.bulletU.getWidth();
    public static int HEIGH=ResourceMgr.bulletU.getHeight();
    Rectangle rect= new Rectangle();
    private int x,y;
    private Dir dir;
    private boolean living = true;
    TankTwo tf=null;

    private Group group=Group.BAD;

    public Bullet(int x, int y, Dir dir, Group group, TankTwo tf){
        super();
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.group=group;
        this.tf=tf;

        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGH;

        tf.Bullets.add(this);
    }


    public void paint(Graphics g){
        if(!living)
        { tf.Bullets.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWM:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }

        move();
    }
    public void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWM:
                y += SPEED;
                break;
        }
        rect.x=this.x;
        rect.y=this.y;

        if (x<0||y<0||x> TankTwo.GAME_WIDTH||y> TankTwo.GAME_HEIGHT) living =false;

    }

    public void collidewith(Tank tank){
        if(this.group==tank.getGroup()) return;



        if(rect.intersects(tank.rect)){
            tank.die();
            this.die();
            int eX=tank.getX()+ Tank.WIDTH/2- Explode.WIDTH/2;
            int eY=tank.getY()+ Tank.HEIGH/2- Explode.HEIGH/2;
            tf.explodes.add(new Explode(eX,eY,tf));
        }
    }
    private void die(){
        this.living=false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

