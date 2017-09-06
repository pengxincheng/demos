package sortDemo.ArraySortDemo;

import org.junit.Test;
import sortDemo.TestEntity;

import java.util.*;


/**
 * Created by pxc on 2017/6/29.
 */
public class ArraySort {
    private static final String[] s1 = {"3", "5", "1", "2", "9", "8"};
    private static final String[] s2 = {"3q", "qwer", "5w", "v1", "2v", "9b", "8m"};
    private static final TestEntity[] testEntities = {new TestEntity("李循环", 12),new TestEntity("张小刘", 12),  new TestEntity("红旗", 15)};

    @Test
    public void sortString() {
        Arrays.sort(s1);
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }

    }

    @Test
    public void sortStirngNum() {
        Arrays.sort(s2);
        for (int i = 0; i < s2.length; i++) {
            System.out.println(s2[i]);
        }
    }

    @Test
    public void sortObject() {
        Arrays.sort(testEntities, new Comparator<TestEntity>() {
            @Override
            public int compare(TestEntity o1, TestEntity o2) {
                return o2.getAge().compareTo(o1.getAge()); //按照年龄由大到小
                //return o1.getAge().compareTo(o2.getAge());按照年龄由小到大
               // return o1.getName().compareTo(o2.getName());
                //先按年龄 再按名字
            }
        });
        for (int i = 0; i < testEntities.length; i++) {
            System.out.println(testEntities[i].toString());
        }
    }

    @Test
    public void  testTime(){

        Calendar c2 = new GregorianCalendar();
        c2.set(Calendar.HOUR_OF_DAY, 23);
        c2.set(Calendar.MINUTE, 59);
        c2.set(Calendar.SECOND, 59);
        System.out.println(c2.getTime());
    }

    @Test
    public void testWeek(){
        Date d = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
    }

}
