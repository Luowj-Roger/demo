package com.roger.work.refugescene.web.rest;

import com.roger.component.redis.domain.GeoCriteria;
import com.roger.component.redis.service.RedisGeoService;
import com.roger.roger.refugescene.domain.RefugeScene;
import com.roger.roger.refugescene.service.RefugeSceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 避难场所 Resource
 *
 * @author work
 * @since 2020/9/30
 */
@RestController
@RequestMapping("/api/sceneResource")
public class RefugeSceneResource {

    @Autowired
    private RefugeSceneService refugeSceneService;

    @Autowired
    private RedisGeoService redisGeoService;

    /**
     * 获取有效的避难场所
     * @return
     */
    @RequestMapping(value = "/getVildSceneResource", method = RequestMethod.GET)
    public List<RefugeScene> getVildSceneResource(){
        return  refugeSceneService.getValidRefugeScene();
    }

    /**
     * 插入指定的避难场所到指定的key中
     * @param key
     * @param refugeScenes
     * @return
     */
    @RequestMapping(value = "/addRefugeSceneGeos/{key}", method = RequestMethod.POST)
    public Long addRefugeSceneGeos(@PathVariable("key") String key,@RequestBody List<RefugeScene> refugeScenes){
        Set<RedisGeoCommands.GeoLocation<String>> locations = new HashSet<>();
        refugeScenes.forEach(res -> locations.add(new RedisGeoCommands.GeoLocation<String>(
                res.getCspm(), new Point(Double.valueOf(res.getLongitude()), Double.valueOf((res.getLatitude()))
        ))));
        return redisGeoService.addGeos(key,locations);
    }

    /**
     * 插入所有有效的避难场所到key中
     * @param key
     * @return
     */
    @RequestMapping(value = "/addAllRefugeSceneGeos/{key}", method = RequestMethod.POST)
    public Long addAllRefugeSceneGeos(@PathVariable("key") String key){
        List<RefugeScene> refugeScenes = refugeSceneService.getValidRefugeScene();
        Set<RedisGeoCommands.GeoLocation<String>> locations = new HashSet<>();
        refugeScenes.forEach(res -> locations.add(new RedisGeoCommands.GeoLocation<String>(
                res.getCspm(), new Point(Double.valueOf(res.getLongitude()), Double.valueOf((res.getLatitude()))
        ))));
        return redisGeoService.addGeos(key,locations);
    }

    /**
     * 在key中获取指定的member的坐标
     * @param key
     * @param member
     * @return
     */
    @RequestMapping(value = "/getRefugeSceneGeo/{key}", method = RequestMethod.POST)
    public List<Point>  getRefugeSceneGeo(@PathVariable("key") String key,@RequestBody String [] member){
        return redisGeoService.getGeoPos(key,member);
    }

    /**
     * 根据给定地理位置坐标获取指定范围内的地理位置集合
     * @param key
     * @param geoCriteria
     * @return
     */
    @RequestMapping(value = "/getPointRadius/{key}", method = RequestMethod.POST)
    public GeoResults<RedisGeoCommands.GeoLocation<String>> getPointRadius(@PathVariable("key") String key, @RequestBody GeoCriteria geoCriteria){

        Circle within = new Circle(
                new Point(geoCriteria.getLongitude(),geoCriteria.getLatitude()),
                new Distance(geoCriteria.getDistanceValue(), Metrics.KILOMETERS));
        RedisGeoCommands.GeoRadiusCommandArgs args =
                RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().
                        includeDistance().limit(geoCriteria.getLmit()).sortAscending();
        return  redisGeoService.getPointRadius(key,within,args);
    }

    /**
     * 根据给定地理位置获取指定范围内的地理位置集合
     * @param key
     * @param geoCriteria
     * @return
     */
    @RequestMapping(value = "/getMemberRadius/{key}", method = RequestMethod.POST)
    public GeoResults<RedisGeoCommands.GeoLocation<String>> getMemberRadius(@PathVariable("key") String key, @RequestBody GeoCriteria geoCriteria){

        Distance distance =
                new Distance(geoCriteria.getDistanceValue(), Metrics.KILOMETERS);
        RedisGeoCommands.GeoRadiusCommandArgs args =
                RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().
                        includeDistance().limit(geoCriteria.getLmit()).sortAscending();
        return  redisGeoService.getMemberRadius(key,geoCriteria.getMember(),distance,args);
    }
}
