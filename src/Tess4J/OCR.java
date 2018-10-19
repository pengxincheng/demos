package Tess4J;

import net.sourceforge.tess4j.Tesseract;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author pengxincheng@ipaynow.cn
 * @Date: 2018/10/18
 * @Time 17:50
 */
public class OCR {
    /**
     * @param srImage  图片路径
     * @param language 字库
     * @return 识别结果
     */
    public static String FindOCR(String srImage, String language) {
        try {
            System.out.println("start");
            double start = System.currentTimeMillis();
            File imageFile = new File(srImage);
            if (!imageFile.exists()) {
                return "图片不存在";
            }
            BufferedImage textImage = ImageIO.read(imageFile);
            Tesseract instance = new Tesseract();
            instance.setDatapath("C:\\Program Files (x86)\\Tesseract-OCR\\tessdata");//设置训练库
            instance.setLanguage(language);

            String result = null;
            result = instance.doOCR(textImage);
            double end = System.currentTimeMillis();
            System.out.println("耗时" + (end - start) / 1000 + " s");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "发生未知错误";
        }
    }

    public static void main(String[] args) throws Exception {
        String result = FindOCR("D:\\testOcr\\test2.png", "normal");
        System.out.println(result);

        String result2 = FindOCR("D:\\testOcr\\test1.png", "chi_sim");
        System.out.println(result2);

        String result3 = FindOCR("D:\\testOcr\\test3.png", "normal");
        System.out.println(result3);

        String result4 = FindOCR("D:\\testOcr\\test6.png", "eng");
        System.out.println(result4);
    }
}

