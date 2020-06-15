package com.finartz.flight.ticketapi.service;

import com.finartz.flight.ticketapi.exception.EntityNotFoundException;
import com.finartz.flight.ticketapi.model.entity.Airport;
import com.finartz.flight.ticketapi.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    AirportRepository repository;

    public Airport findById(Long id) throws EntityNotFoundException {
        Airport airport = repository.findById(id).orElse(null);
        if (airport == null) {
            throw new EntityNotFoundException(Airport.class,"id", id.toString());
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

    public List<Airport> findName(String name) throws EntityNotFoundException {
        List<Airport> airports = repository.findByNameContaining(name);
        if(airports.size()==0) {
            throw new EntityNotFoundException(Airport.class,"name", name.toString());
        }
        return airports;
    }
}
