package com.techland.iris.models;

public abstract class Node {
    private final String name;
    private final String ipAddress;

    public Node(String name, String ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return name;
    }

    public String getIpAddress() {
        return ipAddress;
    }
}
