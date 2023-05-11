package com.rumikuru.testtmhjava.model;


public class Stop {
    private String place;
    private String departureTime;
    private String arrivalTime;

    public Stop(String place, String departureTime, String arrivalTime) {
        this.place = place;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Stop() {

    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
