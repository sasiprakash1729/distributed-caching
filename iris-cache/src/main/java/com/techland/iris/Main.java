package com.techland.iris;

import com.techland.iris.client.CacheClient;
import com.techland.iris.helpers.IPV4RandomAddressGenerator;
import com.techland.iris.helpers.RandomServerNameGenerator;
import com.techland.iris.services.CacheNodeManagerService;
import com.techland.iris.services.CacheNodeManagerServiceImpl;
import com.techland.iris.services.ConsistentHashingService;
import com.techland.iris.services.IrisCache;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RandomServerNameGenerator generator = new RandomServerNameGenerator();

        final Integer noOfVirtualNodes = 3;
        final IPV4RandomAddressGenerator ipv4RandomAddressGenerator = new IPV4RandomAddressGenerator();
        final ConsistentHashingService consistentHashingService = new ConsistentHashingService();
        final CacheNodeManagerService cacheNodeManagerService = new CacheNodeManagerServiceImpl(consistentHashingService,
                ipv4RandomAddressGenerator, noOfVirtualNodes);

        List<String> servers = generator.getRandomServerNames(100);
        for (String server : servers) {
            if (server == null || server.isBlank()) {
                continue;
            }
            cacheNodeManagerService.createCacheNode(server);
        }

        final CacheClient cacheClient = new IrisCache(cacheNodeManagerService);

        cacheClient.put("name", "sasi");
        String myName = (String) cacheClient.get("name");
        System.out.println(myName);
    }
}