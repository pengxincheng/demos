package RegexDemo;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author pengxincheng@ipaynow.cn
 * @Date: 2018/10/12
 * @Time 17:20
 */
public class RegexDemo {

    @Test
    public void test1(){
        String s = "3001/finance CenterApply";
        Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)");

       Matcher matcher =  pattern.matcher(s);
        if (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
