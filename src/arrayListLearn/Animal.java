package arrayListLearn;

/**
 * Created by pxc on 2018/4/18.
 */
public class Animal {

    public String name;

    public void run() {
        System.out.println("animal" + name + "run");
    }

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }
}
