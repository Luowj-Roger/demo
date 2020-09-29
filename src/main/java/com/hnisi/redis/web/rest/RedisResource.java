package com.hnisi.redis.web.rest;


import com.hnisi.account.user.domain.SUser;
import com.hnisi.redis.domain.StringKey;
import com.hnisi.redis.service.RedisStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis")
public class RedisResource {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisStringService redisService;

    /******************** String 类型操做 begin*****************************/
    @RequestMapping(value = "/setUser/{key}", method = RequestMethod.POST)
    public void setStudent(@PathVariable("key") String key,@RequestBody SUser user) {
        redisService.setUserToRedis(key,user);

    }

    //@GetMapping("/get/{key}")
    @RequestMapping(value = "/getUser/{key}", method = RequestMethod.GET)
    public SUser getStudent(@PathVariable("key") String key){

        return redisService.getUserForRedis(key);
    }

    @RequestMapping(value = "/setString", method = RequestMethod.POST)
    public void setString(@RequestBody StringKey stringKey) {
        redisService.setStringToRedis(stringKey);

    }

    @RequestMapping(value = "/getString/{key}", method = RequestMethod.GET)
    public String getString(@PathVariable("key") String key){
        return  redisService.getStringForRedis(key);
    }
    /******************** String 类型操做 end*****************************/

    /******************** Map 类型操做 begin*****************************/
    /******************** Map 类型操做 begin*****************************/
}
