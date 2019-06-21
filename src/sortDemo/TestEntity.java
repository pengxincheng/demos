package sortDemo;


import java.io.Serializable;

/**
 * Created by pxc on 2017/6/29.
 */

public class TestEntity implements Serializable {

    private String name;

    private String age;

    public TestEntity(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:"+this.name+"  age:"+this.age;
    }
}
