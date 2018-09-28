package proxydemo.staticproxy;

import proxydemo.service.UserService;

/**
 * @author pengxincheng@ipaynow.cn
 * @Date: 2018/9/6
 * @Time 10:22
 */
public class StaticProxyDemo implements UserService {

    private UserService target;

    public StaticProxyDemo(UserService target) {
        this.target = target;
    }

    @Override
    public void saveUser(String name) {
        System.out.println("插入数据。。。。" + name);
    }
}
