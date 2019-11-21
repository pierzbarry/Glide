
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    FlightRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        Flight flight;

        flight = new Flight("8:00AM BWI", "4:00PM LAX", "oneway", "450", "June 24th", "8036", "Delta", null);
        repository.save(flight);

        flight = new Flight("6:00AM BWI", "1:00PM LAX", "oneway", "390", "June 26th", "8346", "United", null);
        repository.save(flight);

        flight = new Flight("10:00AM BWI", "8:00PM LAX", "oneway", "320", "June 25th", "3236", "Spirit", null);
        repository.save(flight);

        flight = new Flight("1:00AM BWI", "1:00PM LAX", "oneway", "420", "August 5th", "0036", "Delta", null);
        repository.save(flight);
    }
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