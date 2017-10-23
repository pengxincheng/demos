package wordDemo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pxc on 2017/9/27.
 */
public class WordDemo {

    public void exportSimpleWord() throws Exception{
        Map<String,String> dataMap = new HashMap<String,String>();
        dataMap.put("name", "张三");

        //Configuration用于读取ftl文件
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");

          /*以下是两种指定ftl文件所在目录路径的方式, 注意这两种方式都是
           * 指定ftl文件所在目录的路径,而不是ftl文件的路径
           */
        //指定路径的第一种方式(根据某个类的相对路径指定)
        //configuration.setClassForTemplateLoading(this.getClass(),"");

        //指定路径的第二种方式,我的路径是C:/a.ftl
        configuration.setDirectoryForTemplateLoading(new File("D:/"));

      //  configuration.setClassForTemplateLoading(this.getClass(),"");
        // 输出文档路径及名称
        File outFile = new File("D:/test11.doc");

        //以utf-8的编码读取ftl文件
        Template t =  configuration.getTemplate("test.xml","utf-8");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);
        t.process(dataMap, out);
        out.close();
    }

    @Test
    public void test1(){
        try {
            exportSimpleWord();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
