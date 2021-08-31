package tankone;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public  static BufferedImage goodtankL,goodtankU,goodtankR,goodtankD;
    public  static BufferedImage badtankL,badtankU,badtankR,badtankD;
    public  static BufferedImage bulletL,bulletU,bulletR,bulletD;
    public static BufferedImage[] explodes=new BufferedImage[16];

    static {
        try {
            goodtankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankU.gif"));
            goodtankL = ImageUtil.rotateImage(goodtankU,-90);
            goodtankR = ImageUtil.rotateImage(goodtankU,90);
            goodtankD = ImageUtil.rotateImage(goodtankU,180);

            badtankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tank.D.gif"));
            badtankL = ImageUtil.rotateImage(badtankU,-90);
            badtankR = ImageUtil.rotateImage(badtankU,90);
            badtankD = ImageUtil.rotateImage(badtankU,180);

            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bullet.gif"));
            bulletL = ImageUtil.rotateImage(bulletU,-90);
            bulletR = ImageUtil.rotateImage(bulletU,90);
            bulletD = ImageUtil.rotateImage(bulletU,180);

            for(int i=0;i<16;i++){
                explodes[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/"+ (i+1) +".png"));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

