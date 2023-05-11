package com.rumikuru.testtmhjava.model;


import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<Stop> stops = new ArrayList<>();

    public Route() {
    }

    public void addStop(Stop stops) {
        this.stops.add(stops);
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }
}
