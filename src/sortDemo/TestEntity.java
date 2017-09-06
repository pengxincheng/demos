package sortDemo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by pxc on 2017/6/29.
 */

@Setter
@Getter
public class TestEntity implements Serializable {

    private String name;

    private Integer age;

    public TestEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

  /*  @Override
    public boolean equals(Object obj) {
        if((TestEntity) obj){

        }
    }*/

    @Override
    public String toString() {
        return "name:"+this.name+"  age:"+this.age;
    }
}
