package com.finartz.flight.ticketapi.service;

import com.finartz.flight.ticketapi.model.entity.Airport;
import com.finartz.flight.ticketapi.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    AirportRepository repository;

    public Airport findById(Long id) {
        Airport airport = repository.findById(id).orElse(null);
        if (airport == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return airport;
    }

    public Airport save (Airport airport) {
        return repository.save(airport);
    }

    public List<Airport> findAll() {
        List<Airport> airports = repository.findAll();
        return airports;
    }

    public List<Airport> findName(String name) {
        List<Airport> airports = repository.findByNameContaining(name);
        if(airports.size()==0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return airports;
    }
}
