package sortDemo.SortAlgorithm;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author pengxincheng@ipaynow.cn
 * @Date: 2018/10/15
 * @Time 16:45
 * 排序
 */
public class Sort {

    /**
     * 冒泡排序
     *
     * @param a
     */
    public void bubbleSort(int[] a) {
        int tmp = 0;
        for (int i = 0; i < a.length - 1; i++) {              //可理解为排序趟数，每次确定一个数的位置，所以length-1
            for (int j = 0; j < a.length - i - 1; j++) {    //每趟排序后所要遍历的数组长度减1，i趟后数组长度啊为length-i
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
            System.out.println("第" + (i + 1) + "趟后：");
            printArr(a);
        }
        printArr(a);
    }

    public void selectSort(int[] a) {
        int tmp = 0;
        int k = 0;
        for (int i = 0; i < a.length - 1; i++) {
            k = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[k]) {
                    tmp = a[j];
                    a[j] = a[k];
                    a[k] = tmp;
                }
            }
            System.out.println("第" + (i + 1) + "趟后：");
            printArr(a);
        }

        printArr(a);
    }

    public void insetrSort(int[] a) {
        int tmp = 0;
        for (int i = 1; i < a.length; i++) {           //每个元素都需要插入一次，所以需要 length次
            tmp = a[i];
            int j = i;
            while (j > 0 && a[j] < tmp) {
                a[j] = a[j-1];
                j --;
            }
           a[j] = tmp;
        }
        printArr(a);
    }


    private void printArr(int[] arr) {
        System.out.println("结果：");
        IntStream.of(arr).forEach(System.out::println);
    }

}
