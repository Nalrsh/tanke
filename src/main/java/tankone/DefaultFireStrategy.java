package tankone;

public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank t) {
        int bX=t.x+ Tank.WIDTH/2- Bullet.WIDTH/2;
        int bY=t.y+ Tank.HEIGH/2- Bullet.HEIGH/2;
        new Bullet(bX,bY,t.dir,t.group,t.tf);

    }
}
