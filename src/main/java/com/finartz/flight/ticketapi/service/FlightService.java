package com.finartz.flight.ticketapi.service;

import com.finartz.flight.ticketapi.model.entity.Flight;
import com.finartz.flight.ticketapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository repository;

    public Flight findById(Long id) {
        Flight flight = repository.findById(id).orElse(null);
        if (flight == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return flight;
    }

    public Flight save (Flight flight) {
        return repository.save(flight);
    }

    public List<Flight> findAll() {
        List<Flight> flights = repository.findAll();
        return flights;
    }

    public List<Flight> findName(String name) {
        List<Flight> flights = repository.findByNameContaining(name);
        if(flights.size()==0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return flights;
    }
}
