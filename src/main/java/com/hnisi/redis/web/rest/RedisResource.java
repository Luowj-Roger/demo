package com.hnisi.redis.web.rest;


import com.hnisi.account.user.domain.SUser;
import com.hnisi.redis.domain.StringKey;
import com.hnisi.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis")
public class RedisResource {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/setUser", method = RequestMethod.POST)
    public void setStudent(@RequestBody SUser user) {
        redisTemplate.opsForValue().set("user", user);

    }

    //@GetMapping("/get/{key}")
    @RequestMapping(value = "/getUser/{key}", method = RequestMethod.GET)
    public SUser getStudent(@PathVariable("key") String key){
        return (SUser) redisTemplate.opsForValue().get(key);
    }

    @RequestMapping(value = "/setString", method = RequestMethod.POST)
    public void setString(@RequestBody StringKey stringKey) {
        redisService.setStringToRedis(stringKey);

    }

    @RequestMapping(value = "/getString/{key}", method = RequestMethod.GET)
    public String getString(@PathVariable("key") String key){
        return  redisService.getStringForRedis(key);
    }
}
