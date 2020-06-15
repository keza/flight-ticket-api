package com.finartz.flight.ticketapi.service;

import com.finartz.flight.ticketapi.exception.EntityNotFoundException;
import com.finartz.flight.ticketapi.model.entity.Flight;
import com.finartz.flight.ticketapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository repository;

    public Flight findById(Long id) throws EntityNotFoundException {
        Flight flight = repository.findById(id).orElse(null);
        if (flight == null) {
            throw new EntityNotFoundException(Flight.class,"id", id.toString());
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

    public List<Flight> findName(String name) throws EntityNotFoundException {
        List<Flight> flights = repository.findByNameContaining(name);
        if(flights.size()==0) {
            throw new EntityNotFoundException(Flight.class,"name", name.toString());
        }
        return flights;
    }

    public Flight ticketSold(Flight flight) {
        flight.setSold(flight.getSold()+1);
        flight = repository.save(flight);
        return flight;
    }
}
