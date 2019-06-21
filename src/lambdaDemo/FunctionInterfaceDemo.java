package lambdaDemo;

import org.junit.Test;
import sortDemo.TestEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by pxc on 2017/8/17.
 */
public class FunctionInterfaceDemo {
    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }

    /**
     * 执行Predicate判断
     *
     * @param age       年龄
     * @param predicate Predicate函数式接口
     * @return 返回布尔类型结果
     */
    public static boolean doPredicate(int age, Predicate<Integer> predicate) {
        return predicate.test(age);
    }

    public static void donation(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }

    public static void main(String[] args) {
        boolean isAdult = doPredicate(20, x -> x >= 18);
       /* boolean isAdult = doPredicate(20, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        });*/
        System.out.println(isAdult);
    }

    @Test
    public void testDonation() {
        donation(200, (Integer m) -> System.out.println(m));
    }


    /**
     * list 转map测试
     */
    @Test
    public void testToMap() {

        TestEntity t1 = new TestEntity("pxc", "25");
        TestEntity t2 = new TestEntity("pxc1", "27");
        TestEntity t3 = new TestEntity("pxc", "26");

        List<TestEntity> testEntities = new ArrayList<TestEntity>() {
        };
        testEntities.add(t1);
        testEntities.add(t2);
        testEntities.add(t3);

       Map<String, Object> map = testEntities.stream().collect(Collectors.toMap(TestEntity::getName, testEntity -> testEntity, (k1, k2) -> k1));

        Map<String,String> map1 = testEntities.stream().collect(Collectors.toMap(tt1->tt1.getName(),tt1->tt1.getAge(),(k1,k2)-> k1+k2));
        System.out.println(map);

    }
}