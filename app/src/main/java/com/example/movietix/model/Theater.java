package com.example.movietix.model;

public class Theater {
    private String name;
    private String location;
    private String[] tags;

    public Theater(String name, String location, String[] tags) {
        this.name = name;
        this.location = location;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String[] getTags() {
        return tags;
    }
}
