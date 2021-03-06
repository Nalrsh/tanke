package tankone;

public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.y + Tank.HEIGH / 2 - Bullet.HEIGH / 2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bX, bY, dir, t.group, t.tf);
        }
    }
}
