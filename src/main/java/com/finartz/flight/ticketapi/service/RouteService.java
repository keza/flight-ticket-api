package com.finartz.flight.ticketapi.service;

import com.finartz.flight.ticketapi.model.entity.Route;
import com.finartz.flight.ticketapi.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RouteService {
    
    @Autowired
    RouteRepository repository;

    public Route findById(Long id) {
        Route route = repository.findById(id).orElse(null);
        if (route == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return route;
    }

    public Route save (Route route) {
        return repository.save(route);
    }

    public List<Route> findAll() {
        List<Route> routes = repository.findAll();
        return routes;
    }

    public List<Route> findName(String name) {
        List<Route> routes = repository.findByNameContaining(name);
        if(routes.size()==0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return routes;
    }
}
