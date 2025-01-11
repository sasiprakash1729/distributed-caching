package com.techland.iris.client;

public interface CacheClient {
    void put(Object key, Object value);
    Object get(Object key);
}
