//package abstractfactory;
//
//import tankone.Dir;
//import tankone.Group;
//import tankone.TankTwo;
//
//public class RectFactory extends GameFactory {
//    @Override
//    public BaseTank createTank(int x, int y, Dir dir, Group group, TankTwo tf) {
//        return null;
//    }
//
//    @Override
//    public BaseExplode createExlode(int x, int y, TankTwo tf) {
//        return new RectExplode(x,y,tf);
//    }
//
//    @Override
//    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankTwo tf) {
//        return new RectBullet(x,y,dir,group,tf);
//    }
//}
