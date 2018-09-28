package fanshe;

import java.util.Date;

/**
 * @author pengxincheng@ipaynow.cn
 * @Date: 2018/9/26
 * @Time 16:20
 */
public class FanSHe {

    private String name;

    public void printName(String name, Integer age) {
        System.out.println("#############" + name + "+++++++" + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
