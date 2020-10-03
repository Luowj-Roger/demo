package com.roger.component.redis.web.rest;


import com.roger.common.account.user.domain.SUser;
import com.roger.component.redis.domain.MapsKey;
import com.roger.component.redis.domain.StringKey;
import com.roger.component.redis.service.RedisListService;
import com.roger.component.redis.service.RedisMapService;
import com.roger.component.redis.service.RedisStringService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RedisListService redisListService;

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

    /******************** List 类型操做 begin*****************************/
    /**
     * 插入list
     * @param
     */
    @RequestMapping(value = "/pushList/{type}/{key}", method = RequestMethod.POST)
    public void pushList(@PathVariable("type") String type,@PathVariable("key") String key,@RequestBody List<String> list) {
        if("r".equalsIgnoreCase(type)){
            redisListService.rPushList(key,list);
        }else if("l".equalsIgnoreCase(type)){
            redisListService.lPushList(key,list);
        }
    }

    /**
     * 插入list
     * @param
     */
    @RequestMapping(value = "/popList/{type}/{key}", method = RequestMethod.GET)
    //@RequestParam("type") String type,@RequestParam(value ="keyd" ,required = false) String key
    public String popList(@PathVariable("type") String type,@PathVariable("key") String key) {
        if("r".equalsIgnoreCase(type)){
           return redisListService.rPopList(key);
        }else if("l".equalsIgnoreCase(type)){
            return redisListService.lPopList(key);
        }
        return "";
    }

    /**
     * 插入list
     * @param
     */
    @RequestMapping(value = "/getAllList/{key}", method = RequestMethod.GET)
    public List getAllList(@PathVariable("key") String key) {
        return redisListService.getAllList(key);
    }

    /**
     * 删除count个key的list中值为value的元素
     * @param
     */
    @RequestMapping(value = "/deleteValue/{key}/{count}/{value}", method = RequestMethod.POST)
    public Long deleteValue(@PathVariable("key") String key,@PathVariable("count") int count,@PathVariable("value") String value) {
        return  redisListService.deleteValue(key,count,value);
    }

    /**
     * 返回并删除名称为srckey的list的尾元素，并将该元素添加到名称为dstkey的list的头部
     * @param
     */
    @RequestMapping(value = "/deleteValue/{srckey}/{dstkey}", method = RequestMethod.POST)
    public String rPopPush(@PathVariable("srckey") String srckey,@PathVariable("dstkey") String dstkey) {
        return  redisListService.rPopPush(srckey,dstkey);
    }

    /******************** List 类型操做 end*****************************/
}
