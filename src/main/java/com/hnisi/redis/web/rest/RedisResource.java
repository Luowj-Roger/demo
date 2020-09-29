package com.hnisi.redis.web.rest;


import com.hnisi.account.user.domain.SUser;
import com.hnisi.redis.domain.MapsKey;
import com.hnisi.redis.domain.StringKey;
import com.hnisi.redis.service.RedisMapService;
import com.hnisi.redis.service.RedisStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/redis")
public class RedisResource {


    @Autowired
    private RedisStringService redisStringService;

    @Autowired
    private RedisMapService redisMapService;

    /******************** String 类型操做 begin*****************************/
    @RequestMapping(value = "/setUser/{key}", method = RequestMethod.POST)
    public void setStudent(@PathVariable("key") String key,@RequestBody SUser user) {
        redisStringService.setUserToRedis(key,user);

    }

    //@GetMapping("/get/{key}")
    @RequestMapping(value = "/getUser/{key}", method = RequestMethod.GET)
    public SUser getStudent(@PathVariable("key") String key){

        return redisStringService.getUserForRedis(key);
    }

    @RequestMapping(value = "/setString", method = RequestMethod.POST)
    public void setString(@RequestBody StringKey stringKey) {
        redisStringService.setStringToRedis(stringKey);

    }

    @RequestMapping(value = "/getString/{key}", method = RequestMethod.GET)
    public String getString(@PathVariable("key") String key){
        return  redisStringService.getStringForRedis(key);
    }
    /******************** String 类型操做 end*****************************/

    /******************** Map 类型操做 begin*****************************/

    /**
     * 插入一个key-value  map
     * @param mapsKey
     */
    @RequestMapping(value = "/setMap", method = RequestMethod.POST)
    public void setMap(@RequestBody MapsKey mapsKey) {
        redisMapService.setMapToRedis(mapsKey);

    }

    /**
     * 插入一个map
     * @param mapsKey
     */
    @RequestMapping(value = "/setMaps", method = RequestMethod.POST)
    public void setMaps(@RequestBody List<MapsKey> mapsKey) {
        redisMapService.setMapsToRedis(mapsKey);

    }

    /**
     * 获取map
     * @param key
     * @return
     */
    @RequestMapping(value = "/getMaps/{key}", method = RequestMethod.GET)
    public Map<Object,Object> getMaps(@PathVariable("key") String key){
        return  redisMapService.getMapsForRedis(key);
    }

    /**
     * 获取map中指定的字段
     * @param mapsKey
     * @return
     */
    @RequestMapping(value = "/getMapField", method = RequestMethod.POST)
    public String getMapField(@RequestBody MapsKey mapsKey){
        return  redisMapService.getMapForRedis(mapsKey);
    }

    /**
     * 删除map中指定的字段
     * @param mapsKey
     */
    @RequestMapping(value = "/deleteMapField", method = RequestMethod.POST)
    public void deleteMapField(@RequestBody MapsKey mapsKey){
        redisMapService.deleteField(mapsKey);
    }

    /******************** Map 类型操做 end*****************************/
}
