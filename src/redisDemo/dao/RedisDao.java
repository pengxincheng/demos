package redisDemo.dao;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by pxc on 2017/7/3.
 */
public interface RedisDao {
    /**
     * 添加key value 并且设置存活时间(byte)
     *
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(byte[] key, byte[] value, long liveTime);

    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime 单位秒
     */
    public void set(String key, String value, long liveTime);

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    public void set(String key, String value);

    /**
     * 获取redis value (String)
     * @param key
     * @return
     */
    public String get(String key);

    /**
     * 压栈 List
     * @param key
     * @param value
     * @return
     */
    public Long push(String key, String value);

    /**
     * 出栈   List
     * @param key
     * @return
     */
    public String pop(String key);



}
