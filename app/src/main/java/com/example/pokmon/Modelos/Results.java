package com.example.pokmon.Modelos;

public class Results {
    private final String name;
    private final String url;

    public Results(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
