package com.develhope.advanced3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @PostMapping("/flightProvisions")
    public void flightProvisions() {
        Random random = new Random();
        int numberOfFlights = 50;

        for (int i = 0; i < numberOfFlights; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight: " + i);
            flight.setToAirport("Airport: " + random.nextInt(50));
            flight.setFromAirport("Airport: " + random.nextInt(50));
            flight.setStatus(Status.ONTIME);
            flightRepository.save(flight);
        }
    }

    @GetMapping("/getAllFlights")
    public List<Flight> flightList(){
      return flightRepository.findAll();
    }
}
