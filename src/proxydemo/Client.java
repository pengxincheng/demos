package proxydemo;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;
import proxydemo.dynamicproxy.CglibDynamicProxy;
import proxydemo.dynamicproxy.DynamicProxy;
import proxydemo.service.UserService;
import proxydemo.service.impl.UserServiceImpl;
import proxydemo.staticproxy.StaticProxyDemo;

import java.lang.reflect.Proxy;

/**
 * @author pengxincheng@ipaynow.cn
 * @Date: 2018/9/25
 * @Time 19:28
 */
public class Client {

    @Test
    public void testStaticProxy() {
        UserService userService = new UserServiceImpl();
        StaticProxyDemo target = new StaticProxyDemo(userService);
        target.saveUser("张三");
    }

    @Test
    public void testDynamicProxy() {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");  //设置输出代理class文件
        UserService userService = new UserServiceImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(userService);
        UserService u = (UserService) Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), userService.getClass().getInterfaces(), dynamicProxy);
        u.saveUser("李四");
    }

    @Test
    public void testCglibProxy() {
      //  System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");  //设置输出代理class文件
        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);//设置要代理的对象
        enhancer.setCallback(cglibDynamicProxy);//回调 哪个代理对象
        UserServiceImpl userService = (UserServiceImpl) enhancer.create();//创建代理对象
        userService.saveUser("王五");
    }

}
