//package abstractfactory;
//
//import tankone.*;
//
//public class DefaultFactory extends GameFactory{
//    @Override
//    public BaseTank createTank(int x, int y, Dir dir, Group group, TankTwo tf) {
//        return new Tank(x,y,dir,group,tf);
//    }
//
//    @Override
//    public BaseExplode createExlode(int x, int y, TankTwo tf) {
//        return new Explode(x,y,tf);
//    }
//
//    @Override
//    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankTwo tf) {
//        return new Bullet(x,y,dir,group,tf);
//    }
//}
