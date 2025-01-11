package com.techland.iris.services;

import com.techland.iris.client.CacheClient;
import com.techland.iris.models.CacheNode;

import java.util.Set;

public class IrisCache implements CacheClient {
    private final CacheNodeManagerService cacheNodeManagerService;

    public IrisCache(CacheNodeManagerService cacheNodeManagerService) {
        this.cacheNodeManagerService = cacheNodeManagerService;
    }

    @Override
    public void put(Object key, Object value) {
        Set<CacheNode> nodes = cacheNodeManagerService.findAllNodes();
        for(CacheNode cacheNode: nodes) {
            System.out.printf("Adding Key: %s, into Server Name: %s, IPAddress : %s%n", key, cacheNode.getName(),
                    cacheNode.getIpAddress());
            cacheNode.put(key, value);
        }
    }

    @Override
    public Object get(Object key) {
        CacheNode cacheNode = cacheNodeManagerService.findCacheNode(key);
        System.out.printf("Retrieving Data For A Key: %s, into Server Name: %s, IPAddress : %s%n", key,
                cacheNode.getName(), cacheNode.getIpAddress());
        return cacheNode.getValue(key);
    }
}
