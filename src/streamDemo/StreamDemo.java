package streamDemo;


import com.mysql.cj.core.util.Base64Decoder;
import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author pengxincheng@ipaynow.cn
 * @Date: 2018/9/29
 * @Time 14:48
 */
public class StreamDemo {

    @Test
    public void test1() {
        //IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        //IntStream.range(1, 100).forEach(System.out::println);
        //IntStream.rangeClosed(1, 3).forEach(System.out::println);
        int s = IntStream.rangeClosed(1, 10).sum();
        System.out.println(s);

        IntStream.rangeClosed(1, 10).forEach(value -> {
            System.out.println(value + 2);
        });
    }

    @Test
    public void test2() throws IOException {
        String str = "hello";
        BASE64Encoder base64Encoder = new BASE64Encoder();
       String b = base64Encoder.encode(str.getBytes());

        System.out.println(b);

        BASE64Decoder decoder = new BASE64Decoder();
        System.out.println(  decoder.decodeBuffer(b));
    }
}
