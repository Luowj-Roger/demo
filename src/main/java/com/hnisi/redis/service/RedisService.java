package com.hnisi.redis.service;

import com.hnisi.redis.domain.StringKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RedisService类
 *
 * @author Roger
 * @since 2020/9/27
 */
@Service
@Transactional
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 插入指定的key和value
     * @param stringKey
     */
    public void setStringToRedis(StringKey stringKey){
        String key = stringKey.getKey();
        Object value = stringKey.getValue();
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取指定的key
     * @param key
     * @return
     */
    public String getStringForRedis(Object key){
        //String key = "test";
        Object value = redisTemplate.opsForValue().get(key);
        // 知识追寻者
        return value!=null?value.toString():"";
    }
}
