package com.techland.iris.services;

import com.techland.iris.models.CacheNode;

import java.util.Set;

public interface CacheNodeManagerService {
    void createCacheNode(String name);
    void removeCacheNode(String name);
    CacheNode findCacheNode(Object key);
    Set<CacheNode> findAllNodes();

}
