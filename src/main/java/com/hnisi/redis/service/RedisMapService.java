package com.hnisi.redis.service;

import com.hnisi.redis.domain.MapsKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map类型操做
 *
 * @author Roger
 * @since 2020/9/29
 */
@Service
@Transactional
public class RedisMapService {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 插入单个 key-value
     * @param mapKeys
     */
    public void setMapToRedis(MapsKey mapKeys){
        String mapKey = mapKeys.getMapKey();
        String mapField = mapKeys.getMapField();
        String value = mapKeys.getMapValue();
        redisTemplate.opsForHash().put(mapKey,mapField,value);
    }

    /**
     * 插入多个 key-value
     * @param mapKeys
     */
    public void setMapsToRedis(List<MapsKey> mapKeys){
        String key = "";
        Map<String, Object> valueMap = new HashMap<>();
        for(MapsKey map:mapKeys){
            key = map.getMapKey();
            valueMap.put(map.getMapField(),map.getMapValue());
        }
        redisTemplate.opsForHash().putAll(key,valueMap);
    }

    /**
     * 获取全部key-value
     * @param key
     * @return
     */
    public Map<Object,Object> getMapsForRedis(String key){
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
        return  entries;
    }

    /**
     * 获取Map中指定的key
     * @param mapKeys
     * @return
     */
    public String getMapForRedis(MapsKey mapKeys){
        String key = mapKeys.getMapKey();
        String item = mapKeys.getMapField();
        Object value = redisTemplate.opsForHash().get(key, item);
        return  value!=null?value.toString():"";
    }

    /**
     * 删除Map中指定的key
     * @param mapKeys
     */
    public void deleteField(MapsKey mapKeys){
        String key = mapKeys.getMapKey();
        String item = mapKeys.getMapField();
        redisTemplate.opsForHash().delete(key,item);
    }

    /**
     * 判断Map中的key是否存在
     * @param mapKeys
     * @return
     */
    public boolean hasMapKey(MapsKey mapKeys){
        String key = mapKeys.getMapKey();
        String item = mapKeys.getMapField();
        return  redisTemplate.opsForHash().hasKey(key,item);
    }
}
