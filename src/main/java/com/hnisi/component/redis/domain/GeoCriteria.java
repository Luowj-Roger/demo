package com.hnisi.component.redis.domain;

/**
 * 地图查询实体类
 *
 * @author work
 * @since 2020/10/3
 */
public class GeoCriteria {

    /**
     * 经度
     */
    private double longitude;

    /**
     * 纬度
     */
    private double latitude;

    /**
     * Geo中的某一个位置的member
     */
    private String member;

    /**
     * 距离长度
     */
    private double distanceValue;

    /**
     * 距离长度单位
     *         //    Metrics.KILOMETERS(6378.137D, "km"),公里
     *         //    Metrics.MILES(3963.191D, "mi"), 英里
     *         //    Metrics.NEUTRAL(1.0D, ""); 米
     * 默认值为 km 公里
     */
    private String distanceMetric;

    /**
     * 返回的个数
     */
    private long lmit;

    /**
     * 返回列表的排序
     * desc asc
     *
     * 默认值为desc
     */
    private String direction;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public double getDistanceValue() {
        return distanceValue;
    }

    public void setDistanceValue(double distanceValue) {
        this.distanceValue = distanceValue;
    }

    public String getDistanceMetric() {
        return distanceMetric;
    }

    public void setDistanceMetric(String distanceMetric) {
        this.distanceMetric = distanceMetric;
    }

    public long getLmit() {
        return lmit;
    }

    public void setLmit(long lmit) {
        this.lmit = lmit;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
