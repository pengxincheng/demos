package proxydemo.dynamicproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author pengxincheng@ipaynow.cn
 * @Date: 2018/9/28
 * @Time 10:56
 */
public class CglibDynamicProxy implements MethodInterceptor {

    /**
     *
     * @param o        被代理对象
     * @param method     表示拦截的方法
     * @param objects   数组表示参数列表,基本数据类型需要传入其包装类型,如int-->Integer、long-Long、double-->Double
     * @param methodProxy 对方法的代理,invokeSuper方法表示对被代理对象方法的调用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理方法执行之前");
        methodProxy.invokeSuper(o, objects);
        System.out.println("代理方法执行完成后");
        return o;
    }
}
