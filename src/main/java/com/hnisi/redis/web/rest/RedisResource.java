package com.hnisi.redis.web.rest;


import com.hnisi.account.user.domain.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis")
public class RedisResource {

    @Autowired
    private RedisTemplate redisTemplate;

    //@PostMapping("/setUser")
    @RequestMapping(value = "/setUser", method = RequestMethod.POST)
    public void setStudent(@RequestBody SUser user) {
        /*ValueOperations<K, V>将redis中的key-value封装成一个对象，我们之就只需要操作这个对象即可
        *  public ValueOperations<K, V> opsForValue() {
             return this.valueOps;
            }
        * */
        redisTemplate.opsForValue().set("user", user);

    }

    //@GetMapping("/get/{key}")
    @RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
    public SUser getStudent(@PathVariable("key") String key){
        return (SUser) redisTemplate.opsForValue().get(key);
    }
}
