package com.finartz.flight.ticketapi.controller;

import com.finartz.flight.ticketapi.model.entity.Airline;
import com.finartz.flight.ticketapi.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

    @Autowired
    AirlineService service;

    @GetMapping("/")
    public List<Airline> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Airline findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public Airline save(@Valid @RequestBody Airline airline) {
        return service.save(airline);
    }

    @GetMapping("/airlines")
    public List<Airline> findName(@RequestParam("name") String name) {
        return service.findName(name);
    }
}
