package com.finartz.flight.ticketapi.controller;

import com.finartz.flight.ticketapi.model.entity.Airport;
import com.finartz.flight.ticketapi.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    AirportService service;

    @GetMapping("/")
    public List<Airport> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Airport findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public Airport save(@Valid @RequestBody Airport airport) {
        return service.save(airport);
    }

    @GetMapping("/airports")
    public List<Airport> findName(@RequestParam("name") String name) {
        return service.findName(name);
    }
}
