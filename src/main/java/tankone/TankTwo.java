package tankone;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

 public class TankTwo extends Frame {
    Tank mytank = new Tank(200, 400, Dir.DOWM, Group.GOOD,this);
    List<Bullet> Bullets = new ArrayList<Bullet>();
    List<Tank> Tanks = new ArrayList<>();
    List<Explode> explodes= new ArrayList<>();


    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;

    public TankTwo() {
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new MykeyListener());

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }


    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.magenta);
        g.drawString("子弹的数量:" + Bullets.size(), 10, 60);
        g.drawString("敌人的数量:" + Tanks.size(), 10, 80);
        g.drawString("爆炸数量:" + explodes.size(), 10, 100);
        g.setColor(c);
        mytank.paint(g);
        for (int i = 0; i < Bullets.size(); i++) {
            Bullets.get(i).paint(g);
        }

        for (int i = 0; i < Tanks.size(); i++) {
            Tanks.get(i).paint(g);
        }
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        for (int i = 0; i < Bullets.size(); i++) {
            for (int j = 0; j < Tanks.size(); j++)
                Bullets.get(i).collidewith(Tanks.get(j));
        }





    }


    class MykeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;


        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();

            //x+=200;
            //repaint();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_SPACE:

                    mytank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();

        }

        private void setMainTankDir() {

            if (!bL && !bU && !bR && !bD) mytank.setMoving(false);
            else {
                mytank.setMoving(true);

                if (bL) mytank.setDir(Dir.LEFT);
                if (bU) mytank.setDir(Dir.UP);
                if (bR) mytank.setDir(Dir.RIGHT);
                if (bD) mytank.setDir(Dir.DOWM);
            }


        }
    }

}
