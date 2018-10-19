package sortDemo.SortAlgorithm;

import org.junit.Test;

/**
 * @author pengxincheng@ipaynow.cn
 * @Date: 2018/10/15
 * @Time 17:46
 */
public class TestClient {
    private int[] a = {34, 23, 2, 1, -4};
    private Sort sort = new Sort();

    @Test
    public void testBubbleSort(){
        sort.bubbleSort(a);
    }

    @Test
    public void testSelectSort(){
        sort.selectSort(a);
    }

    @Test
    public void testInsertSort(){
        sort.insetrSort(a);
    }
}
