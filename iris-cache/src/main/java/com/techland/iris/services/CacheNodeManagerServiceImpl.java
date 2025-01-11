package com.techland.iris.services;

import com.techland.iris.helpers.IPV4RandomAddressGenerator;
import com.techland.iris.models.CacheNode;

import java.util.*;
import java.util.stream.Collectors;

public class CacheNodeManagerServiceImpl implements CacheNodeManagerService {
    private final ConsistentHashingService consistentHashingService;
    private final IPV4RandomAddressGenerator ipAddressGenerator;
    private final Integer noOfVirtualNode;
    private final SortedMap<Integer, CacheNode> serverLocations = new TreeMap<>();
    private final Map<String, Integer> cacheNameIdentifier = new HashMap<>();

    public CacheNodeManagerServiceImpl(ConsistentHashingService consistentHashingService,
                                       IPV4RandomAddressGenerator ipAddressGenerator, Integer noOfVirtualNode) {
        this.consistentHashingService = consistentHashingService;
        this.ipAddressGenerator = ipAddressGenerator;
        this.noOfVirtualNode = noOfVirtualNode;
    }

    @Override
    public void createCacheNode(String name) {
        //On receiving new node create request, Create node * Number of virtual node and store it
        for (int i = 0; i < noOfVirtualNode; i++) {
            final String ipAddress = ipAddressGenerator.generateIPV4();
            final CacheNode cacheNode = new CacheNode(name + ":" + i, ipAddress);
            Integer nodeLocation = consistentHashingService.findRingPosition(cacheNode.getIpAddress());
            System.out.printf("Server Name: %s, IPV4: %s Added In Location: %s%n", cacheNode.getName(),
                    cacheNode.getIpAddress(), nodeLocation);
            serverLocations.put(nodeLocation, cacheNode);
            cacheNameIdentifier.put(cacheNode.getName(), nodeLocation);
        }
    }

    @Override
    public void removeCacheNode(String name) {
        for (int i = 0; i < noOfVirtualNode; i++) {
            String cacheName = name + ":" + i;
            final Integer location = cacheNameIdentifier.get(cacheName);
            if(serverLocations.containsKey(location)) {
                final String ipAddress = serverLocations.get(location).getIpAddress();
                System.out.printf("Removing Server Name: %s, IPV4: %s Added In Location: %s%n", cacheName,
                        ipAddress, location);
                serverLocations.remove(location);
            }
        }
    }

    @Override
    public CacheNode findCacheNode(Object key) {
        if (serverLocations.isEmpty()) {
            return null;
        }
        Integer hash = consistentHashingService.findRingPosition(key);
        // Find the first node with a hash greater than or equal to the key's hash
        SortedMap<Integer, CacheNode> tailMap = serverLocations.tailMap(hash);
        int nodeHash = tailMap.isEmpty() ? serverLocations.firstKey() : tailMap.firstKey();
        return serverLocations.get(nodeHash);
    }

    @Override
    public Set<CacheNode> findAllNodes() {
        if (serverLocations.isEmpty()) {
            return null;
        }
        return new HashSet<>(serverLocations.values());
    }
}
