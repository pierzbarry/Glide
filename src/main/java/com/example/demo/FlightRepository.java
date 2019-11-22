package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    ArrayList<Flight> findByDepartingAirportContainingIgnoreCaseOrArrivingAirportContainingIgnoreCaseOrPriceContainingIgnoreCaseOrDateContainingIgnoreCaseOrFlightNumberContainingIgnoreCaseOrAirlineContainingIgnoreCase
            (String depart, String arrive, String price, String date, String flightNumber, String airline);
}

//    private long id;
//    private String departingAirport;
//    private String arrivingAirport;
//    private String type;
//    private String price;
//    private String date;
//    private String flightNumber;
//    private String airline;
//    private String imageurl;