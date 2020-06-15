package com.finartz.flight.ticketapi.service;

import com.finartz.flight.ticketapi.model.entity.Airline;
import com.finartz.flight.ticketapi.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AirlineService {

    @Autowired
    AirlineRepository repository;

    public Airline findById(Long id) {
        Airline airline = repository.findById(id).orElse(null);
        if (airline == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return airline;
    }

    public Airline save (Airline airline) {
        return repository.save(airline);
    }

    public List<Airline> findAll() {
        List<Airline> airlines = repository.findAll();
        return airlines;
    }

    public List<Airline> findName(String name) {
        List<Airline> airlineList = repository.findByNameContaining(name);
        if(airlineList.size()==0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return airlineList;
    }
}
