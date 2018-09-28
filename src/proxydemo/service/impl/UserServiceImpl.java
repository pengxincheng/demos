package proxydemo.service.impl;

import proxydemo.service.UserService;

/**
 * @author pengxincheng@ipaynow.cn
 * @Date: 2018/9/7
 * @Time 15:25
 */
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(String name) {
        System.out.println("保存用户" + name);
    }
}
