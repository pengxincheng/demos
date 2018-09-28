package fanshe;


import java.lang.reflect.Method;

/**
 * @author pengxincheng@ipaynow.cn
 * @Date: 2018/9/26
 * @Time 16:21
 */
public class Client {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("fanshe.FanSHe");                                   //获取类
            Method m = clazz.getMethod("printName",String.class,Integer.class);        //获取方法
            Object o = clazz.getConstructor().newInstance();                                  //创建示例
            m.invoke(o,"张三",25);                                                    //执行方法


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
