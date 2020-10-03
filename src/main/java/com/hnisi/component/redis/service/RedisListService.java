package com.hnisi.component.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *  list集合操作
 *
 * @author Roger
 * @since 2020/9/29
 */
@Service
@Transactional
public class RedisListService {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 往左侧插入list(头部)
     * @param key
     * @param list
     */
    public void rPushList (String key,List list){
        redisTemplate.opsForList().rightPushAll(key,list);
    }

    /**
     * 往右侧插入list(尾部)
     * @param key
     * @param list
     */
    public void lPushList (String key,List list){
        redisTemplate.opsForList().leftPushAll(key,list);
    }

    /**
     * 左侧弹出(头部)
     * @param key
     * @return
     */
    public String rPopList(String key){
        Object value =  redisTemplate.opsForList().rightPop(key);
        return  value!=null?value.toString():"";
    }

    /**
     * 右侧弹出(尾部)
     * @param key
     * @return
     */
    public String lPopList(String key){
        Object value =  redisTemplate.opsForList().leftPop(key);
        return  value!=null?value.toString():"";
    }

    /**
     * 修改列表指定索引的值
     * @param key
     * @param index
     * @param value
     */
    public void setIndexList(String key ,int index,String value){
        redisTemplate.opsForList().set(key,index,value);
    }

    /**
     * 获取表指定索引的值
     * @param key
     * @param index
     * @return
     */
    public String getIndexList(String key ,int index){
        Object value = redisTemplate.opsForList().index(key,index);
        return  value!=null?value.toString():"";
    }

    /**
     * 获取list内容
     * @param key
     */
    public List getAllList(String key){
        Object value =  redisTemplate.opsForList().range(key,0,-1);
        return  value!=null?(List)value:new ArrayList();
    }

    /**
     * 删除count个key的list中值为value的元素
     * @param key
     * @param count
     * @param value
     */
    public long deleteValue(String key,int count,String value){
        Object num =  redisTemplate.opsForList().remove(key,count,value);
        return  value!=null?(Long)num:0;
    }

    /**
     * 返回并删除名称为srckey的list的尾元素，并将该元素添加到名称为dstkey的list的头部
     * @param srckey
     * @param dstkey
     */
    public String  rPopPush(String srckey,String dstkey){
        Object value =  redisTemplate.opsForList().rightPopAndLeftPush(srckey,dstkey);
        return  value!=null?value.toString():"";
    }
}
