package com.example.movietix.model;

import java.util.List;

public class Theater {
    private String name;
    private String location;
    private List<String> tags; // ✅ Ubah dari String[] ke List<String>

    public Theater() {
        // Diperlukan oleh Firebase
    }

    public Theater(String name, String location, List<String> tags) {
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

    public List<String> getTags() {
        return tags;
    }
}
