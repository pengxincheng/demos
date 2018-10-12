package pictureDemo;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;

/**
 * @author pengxincheng@ipaynow.cn
 * @Date: 2018/10/11
 * @Time 19:21
 */
public class PicDemo {

    public static String path = "D://";

    public static void main(String[] args) throws IOException {
        File file1 = new File(path, "test.png");
        File file2 = new File(path, "test2.png");
        mergeImage(file1, file2);
    }

    public static void mergeImage(File file1, File file2) throws IOException {
        BufferedImage image1 = ImageIO.read(file1);
        BufferedImage image2 = ImageIO.read(file2);


        BufferedImage bufferedImage = new BufferedImage(Math.max(image1.getWidth(),image2.getWidth()), image1.getHeight() + image2.getHeight(), BufferedImage.TYPE_INT_RGB);

        // paint both images, preserving the alpha channels
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(image1, 0, 0, null);
        g.drawImage(image2, 0, image1.getHeight(), null);

        ImageIO.write(bufferedImage, "jpg", new File(path, "3.jpg"));
    }
}

