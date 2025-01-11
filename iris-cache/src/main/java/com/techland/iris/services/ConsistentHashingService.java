package com.techland.iris.services;

public class ConsistentHashingService {
    private final Integer ringSize = (int) Math.pow(2, 10) - 1;
    public Integer findRingPosition(final Object key) {
        return Math.abs(key.hashCode()) % ringSize;
    }
}
