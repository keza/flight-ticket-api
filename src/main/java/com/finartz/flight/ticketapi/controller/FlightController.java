package com.finartz.flight.ticketapi.controller;

import com.finartz.flight.ticketapi.exception.EntityNotFoundException;
import com.finartz.flight.ticketapi.model.entity.Flight;
import com.finartz.flight.ticketapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService service;

    @GetMapping("/")
    public List<Flight> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Flight findById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/")
    public Flight save(@Valid @RequestBody Flight flight) {
        return service.save(flight);
    }

    @GetMapping("/flights")
    public List<Flight> findName(@RequestParam("name") String name) throws EntityNotFoundException {
        return service.findName(name);
    }
}
