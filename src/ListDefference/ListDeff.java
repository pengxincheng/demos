package ListDefference;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pxc on 2017/7/19.
 */
public class ListDeff {

    /**
     *
     */
    @Test
    public void test1() {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            list1.add("test" + i);
            list2.add("test" + i * 2);
        }
        getDiffrent(list1, list2);
        //输出：total times  748153134
    }


    /**
     * 获取两个List的不同元素
     *
     * @param list1
     * @param list2
     * @return
     */
    private static List<String> getDiffrent(List<String> list1, List<String> list2) {
        long st = System.nanoTime();
        List<String> diff = new ArrayList<String>();
        for (String str : list1) {
            if (!list2.contains(str)) {
                diff.add(str);
            }
        }
        System.out.println("total times " + (System.nanoTime() - st));
        return diff;
    }
}
