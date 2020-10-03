package com.roger.component.redis.domain;

/**
 * 字符串实体类
 *
 * @author work
 * @since 2020/9/27
 */
public class StringKey {
    private String key;

    private Object value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
