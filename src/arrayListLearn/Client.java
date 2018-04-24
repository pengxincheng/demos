package arrayListLearn;

import java.util.*;

/**
 * Created by pxc on 2018/4/18.
 */
public class Client {
    public static void main(String[] args) {

      /*  Dog dog = new Dog("qq");
        Dog dog1 = new Dog("ww");
        Set<Dog> dogSet = new HashSet<>();
        dogSet.add(dog);
        dogSet.add(dog1);

        List<Animal> animalList = new ArrayList<>(dogSet);

        animalList.get(0).run();

        animalList.stream().filter(d -> d.name.equals("qq")).forEach((Animal d) -> d.run());

        dogSet.forEach(dog2 -> System.out.println(dog2.name));

        System.out.println( animalList.stream().filter(d -> d.name.equals("qq")).count());*/

        int i = 100;
        System.out.println(i + (i >> 1));

        System.out.println(1^3);

        System.out.println(new String("qwer").hashCode());
    }


}
