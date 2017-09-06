package redisDemo.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import redisDemo.dao.RedisDao;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/**
 * Created by pxc on 2017/7/3.
 */
@Repository("redisDao")
public class RedisDaoImpl implements RedisDao {
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static String redisCode = "utf-8";

    @Override
    public void set(String key, String value, long liveTime) {
        try {
            this.set(key.getBytes(redisCode), value.getBytes(redisCode), liveTime);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void set(String key, String value) {
        this.set(key, value, 0L);
    }

    @Override
    public void set(byte[] key, byte[] value, long liveTime) {
        redisTemplate.execute(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set(key, value);
                if (liveTime > 0) {
                    redisConnection.expire(key, liveTime);
                }
                return 1L;
            }
        });
    }

    @Override
    public String get(String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                try {
                    return new String(redisConnection.get(key.getBytes(redisCode)),redisCode);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return "";
            }
        });
    }

    @Override
    public Long push(String key, String value) {
        return stringRedisTemplate.opsForList().leftPush(key,value);
    }

    @Override
    public String pop(String key) {
        return stringRedisTemplate.opsForList().leftPop(key);
    }
}
