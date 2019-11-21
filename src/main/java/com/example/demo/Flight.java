package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String departingAirport;
    private String arrivingAirport;
    private String type;
    private String price;
    private String date;
    private String flightNumber;
    private String airline;
    private String imageurl;


    public Flight() {
    }

    public Flight(String departingAirport, String arrivingAirport, String type, String price, String date, String flightNumber, String airline, String imageurl) {
        this.departingAirport = departingAirport;
        this.arrivingAirport = arrivingAirport;
        this.type = type;
        this.price = price;
        this.date = date;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.imageurl = imageurl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartingAirport() {
        return departingAirport;
    }

    public void setDepartingAirport(String departingAirport) {
        this.departingAirport = departingAirport;
    }

    public String getArrivingAirport() {
        return arrivingAirport;
    }

    public void setArrivingAirport(String arrivingAirport) {
        this.arrivingAirport = arrivingAirport;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}