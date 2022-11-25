package com.example.pokmon.Modelos;

import java.util.List;

public class Pokemon {
    private final int count;
    private final String next;
    private final String previous;
    private final List<Results> results;

    public Pokemon(int count, String next, String previous, List<Results> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<Results> getResults() {
        return results;
    }

}
