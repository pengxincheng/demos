package lambdaDemo;

import org.junit.Test;

import java.util.function.Consumer;

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
     * @return          返回布尔类型结果
     */
    public static boolean doPredicate(int age, Predicate<Integer> predicate) {
        return predicate.test(age);
    }

    public static void donation(Integer money, Consumer<Integer> consumer){
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
    public void testDonation(){
        donation(200,(Integer m)-> System.out.println(m));
    }
}