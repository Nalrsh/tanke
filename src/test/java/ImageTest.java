import org.junit.jupiter.api.Test;
import sun.awt.windows.WBufferStrategy;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


class ImageTest {

    @Test
     void test (){


         try{
             BufferedImage image = ImageIO.read(new File("C:/rua/xxxx/image/tankL.png"));
            assertNotNull(image);

            BufferedImage image2= ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("image/tankL.png"));
            assertNotNull(image2);
     } catch (IOException e){
            e.printStackTrace();
        }

     }

}