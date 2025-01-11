package com.techland.iris.models;

import java.util.HashMap;
import java.util.Map;

public class CacheNode<K, V> extends Node {
    private final Map<K, V> storage = new HashMap<>();

    public CacheNode(String name, String ipAddress) {
        super(name, ipAddress);
    }

    public V getValue(final K key) {
        return storage.get(key);
    }

    public void put(final K key, final V value) {
        storage.put(key, value);
    }
}
