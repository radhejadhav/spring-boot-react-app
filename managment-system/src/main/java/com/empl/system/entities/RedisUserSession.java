package com.empl.system.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class RedisUserSession {

    @Id
    private String key;

    private String value;

    public RedisUserSession() {
    }

    public RedisUserSession(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RedisUserSession{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
