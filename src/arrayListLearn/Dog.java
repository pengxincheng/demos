package arrayListLearn;

/**
 * Created by pxc on 2018/4/18.
 */
public class Dog extends Animal {

    @Override
    public void run() {
        System.out.println("dog" + name + "run");
    }

    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }
}
