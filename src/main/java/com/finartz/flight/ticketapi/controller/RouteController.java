package com.finartz.flight.ticketapi.controller;

import com.finartz.flight.ticketapi.model.entity.Route;
import com.finartz.flight.ticketapi.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    RouteService service;

    @GetMapping("/")
    public List<Route> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Route findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public Route save(@Valid @RequestBody Route route) {
        return service.save(route);
    }

    @GetMapping("/routes")
    public List<Route> findName(@RequestParam("name") String name) {
        return service.findName(name);
    }
}
