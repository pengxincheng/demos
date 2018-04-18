package sortDemo.ListSortDemo;

import org.junit.Test;
import sortDemo.TestEntity;

import java.text.Collator;
import java.util.*;

/**
 * Created by pxc on 2017/6/29.
 */
public class ListSort {
    private static final List<TestEntity> testEntities = new ArrayList<TestEntity>();

    static {
        testEntities.add(new TestEntity("李循环", "12"));
        testEntities.add(new TestEntity("红旗", "15"));
        testEntities.add(new TestEntity("张小刘", "12"));

    }

    @Test
    public void  listSortByName(){
        Collections.sort(testEntities, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        for (TestEntity testEntity:testEntities) {
            System.out.println(testEntity.toString());
        }
    }

    @Test
    public void  listSortByName1(){
        Collections.sort(testEntities, new Comparator<TestEntity>() {
            @Override
            public int compare(TestEntity o1, TestEntity o2) {
                return Collator.getInstance(Locale.CHINESE).compare(o1.getName(),o2.getName());
            }
        });

        for (TestEntity testEntity:testEntities) {
            System.out.println(testEntity.toString());
        }
    }

    @Test
    public void  listSortByName2(){
        Collections.sort(testEntities,(TestEntity o1,TestEntity o2)-> Collator.getInstance(Locale.CHINESE).compare(o1.getName(),o2.getName()));
        testEntities.forEach((TestEntity t)->System.out.println(t.toString()));

    }



    @Test
    public void  listSort(){
       Collections.sort(testEntities, Comparator.comparing(o -> Double.valueOf(o.getAge())));

        for (TestEntity testEntity:testEntities) {
            System.out.println(testEntity.toString());
        }

        testEntities.parallelStream().forEachOrdered(t -> System.out.println("****"+t.toString()));
    }

}
