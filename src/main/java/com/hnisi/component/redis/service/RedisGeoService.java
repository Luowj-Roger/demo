package com.hnisi.component.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * geo地图数据类型
 *
 * @author Roger
 * @since 2020/9/29
 */
@Service
@Transactional
public class RedisGeoService {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 把坐标信息保存到Redis上
     * @param key key值
     * @param locations  name名称 Point<X,Y>坐标经纬度
     * @return 保存的个数
     */
    public Long addGeos(String key,Set<RedisGeoCommands.GeoLocation<String>> locations){
        //Set<RedisGeoCommands.GeoLocation<String>> locations = new HashSet<>();
        return redisTemplate.opsForGeo().add(key,locations);
    }

    /**
     * 从key里面返回所有给定位置对象的位置（经度和纬度）
     * @param key key值
     * @param pos name名称
     * @return List<Point> Point<X,Y>坐标经纬度
     */
    public List<Point> getGeoPos(String key,String [] pos){
        return redisTemplate.opsForGeo().position(key,pos);
    }

    /**
     * 从key中获取 指定的两个地方的距离
     * @param key key值
     * @param member1 地方名称1
     * @param member2 地方名称2
     * @param metric 单位 可为null
     * @return Distance 距离: value距离数值  metric单位
     */
    public Distance getGeoDistance(String key, String member1 , String member2, Metric metric){
        if(metric!=null) {
            return  redisTemplate.opsForGeo().distance(key,member1, member2, metric);
        }else{
            return  redisTemplate.opsForGeo().distance(key,member1, member2);
        }
    }
    /**
     * <h2>根据给定地理位置坐标获取指定范围内的地理位置集合</h2>
     * @param key key值
     * @param within {@link Circle} 中心点和 距离
     * @param args {@link RedisGeoCommands.GeoRadiusCommandArgs} 限制返回的个数和排序方式, 可以是 null
     * @return {@link RedisGeoCommands.GeoLocation}
     * */
    public GeoResults<RedisGeoCommands.GeoLocation<String>> getPointRadius(String key,
            Circle within, RedisGeoCommands.GeoRadiusCommandArgs args){
           if(args!=null){
               return  redisTemplate.opsForGeo().radius(key,within,args);
           }else{
               return  redisTemplate.opsForGeo().radius(key,within);
           }
    }

    /**
     * <h2>根据给定地理位置获取指定范围内的地理位置集合</h2>
     * @param key key值
     * @param member 指定的地方名称
     * @param args {@link RedisGeoCommands.GeoRadiusCommandArgs} 限制返回的个数和排序方式, 可以是 null
     * @return {@link RedisGeoCommands.GeoLocation}
     * */
    public GeoResults<RedisGeoCommands.GeoLocation<String>> getMemberRadius(String key,
            String member, Distance distance, RedisGeoCommands.GeoRadiusCommandArgs args){
        if(args!=null){
            return  redisTemplate.opsForGeo().radius(key,member,distance,args);
        }else{
            return  redisTemplate.opsForGeo().radius(key,member,distance);
        }
    }

    /**
     * 获取key中指定名称的hash值
     * @param key
     * @param members
     * @return 以使用这个编码值去 http://geohash.org/${hash}中进行直接定位，它是 geohash 的标准编码值
     */
    public List<String> getCityGeoHash(String key,String[] members) {
        return redisTemplate.opsForGeo().hash(key,members);
    }

}
