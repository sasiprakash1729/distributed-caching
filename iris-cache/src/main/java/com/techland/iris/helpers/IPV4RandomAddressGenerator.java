package com.techland.iris.helpers;

import java.util.Random;

public final class IPV4RandomAddressGenerator {
    private final Random random = new Random();

    public String generateIPV4() {
        // Generate four random integers in the range 0-255 (inclusive) and join them with dots
        return random.nextInt(256) + "." +
                random.nextInt(256) + "." +
                random.nextInt(256) + "." +
                random.nextInt(256);
    }

}

