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
         *
         * @param srImage 图片路径
         * @param ZH_CN 是否使用中文训练库,true-是
         * @return 识别结果
         */
        public static String FindOCR(String srImage, boolean ZH_CN) {
            try {
                System.out.println("start");
                double start=System.currentTimeMillis();
                File imageFile = new File(srImage);
                if (!imageFile.exists()) {
                    return "图片不存在";
                }
                BufferedImage textImage = ImageIO.read(imageFile);
                Tesseract instance=new Tesseract();
                instance.setDatapath("C:\\Program Files (x86)\\Tesseract-OCR\\tessdata");//设置训练库
                if (ZH_CN)
                   instance.setLanguage("normal");//自己训练的字库
                //instance.setLanguage("chi_sim");//中文字库
                String result = null;
                result = instance.doOCR(textImage);
                double end=System.currentTimeMillis();
                System.out.println("耗时"+(end-start)/1000+" s");
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return "发生未知错误";
            }
        }
        public static void main(String[] args) throws Exception {
            String result=FindOCR("D:\\testOcr\\test2.png",true);
            System.out.println(result);

            String result2=FindOCR("D:\\testOcr\\test1.png",true);
            System.out.println(result2);
        }
    }

