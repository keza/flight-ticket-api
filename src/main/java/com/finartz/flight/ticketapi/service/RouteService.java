package com.finartz.flight.ticketapi.service;

import com.finartz.flight.ticketapi.exception.EntityNotFoundException;
import com.finartz.flight.ticketapi.model.entity.Route;
import com.finartz.flight.ticketapi.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    
    @Autowired
    RouteRepository repository;

    public Route findById(Long id) throws EntityNotFoundException {
        Route route = repository.findById(id).orElse(null);
        if (route == null) {
            throw new EntityNotFoundException(Route.class,"id", id.toString());
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

    public List<Route> findName(String name) throws EntityNotFoundException {
        List<Route> routes = repository.findByNameContaining(name);
        if(routes.size()==0) {
            throw new EntityNotFoundException(Route.class,"name", name.toString());
        }
        return routes;
    }
}
