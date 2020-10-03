package com.roger.component.redis.domain;

/**
 * map实体类
 *
 * @author work
 * @since 2020/9/29
 */
public class MapsKey {

    private String mapKey;

    private String mapField;

    private String mapValue;

    public String getMapKey() {
        return mapKey;
    }

    public void setMapKey(String mapKey) {
        this.mapKey = mapKey;
    }

    public String getMapField() {
        return mapField;
    }

    public void setMapField(String mapField) {
        this.mapField = mapField;
    }

    public String getMapValue() {
        return mapValue;
    }

    public void setMapValue(String mapValue) {
        this.mapValue = mapValue;
    }
}
