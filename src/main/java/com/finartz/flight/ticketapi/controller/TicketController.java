package com.finartz.flight.ticketapi.controller;

import com.finartz.flight.ticketapi.model.dto.TicketRequest;
import com.finartz.flight.ticketapi.model.entity.Airline;
import com.finartz.flight.ticketapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    TicketService service;

    @PostMapping("/")
    public String checkout(@Valid @RequestBody String request) throws Exception {
        return service.checkout(request);
    }
}
