package redisDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redisDemo.dao.RedisDao;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pxc on 2017/7/3.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})

public class TestRedis {
    @Autowired
    private RedisDao redisDao;

    @Test
    public void  testAdd(){
        /*redisDao.set("test","hello world!");*/

        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("!");
        redisDao.set("testList",list.toString());
    }

    @Test
    public void TestGet(){
       /* System.out.println(redisDao.get("test"));*/
       List<String> list = Arrays.asList(redisDao.get("testList").split(","));
        System.out.println(list.size());
    }

    /**
     * 存list
     */
    @Test
    public void testPush(){
       /* redisDao.push("testPush","q");
        redisDao.push("testPush","w");
        redisDao.push("testPush","e");
        redisDao.push("testPush","q");*/

    }

    /**
     * 取list
     */
    @Test
    public void testPop(){
        System.out.println(redisDao.pop("testPush"));
    }
}
