package ui;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 图片工具类
 */
public class ImageUtil {

    public static BufferedImage getImg(String path){
        try {
            BufferedImage img= ImageIO.read(ImageUtil.class.getResource(path));
            //成功
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
