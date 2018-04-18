package genericParadigm.test;


import genericParadigm.Pair;
import org.junit.Test;

/**
 * Created by pxc on 2018/4/11.
 */

public class PairTest {

    @Test
    public void test1(){
        String[] words = {"Mary","had","a","little","lamb"};
        System.out.println(minMax(words).getFirst());
        System.out.println(minMax(words).getSecond());
    }

    public static Pair<String> minMax(String[] a){
        if(null ==a || a.length ==0){
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i = 0; i <a.length ; i++) {
            if(min.compareTo(a[i]) > 0 ){
                min = a[i];
            }
            if(max.compareTo(a[i])<0){
                max = a[i];
            }
        }
        return new Pair<>(min,max);
    }
}
