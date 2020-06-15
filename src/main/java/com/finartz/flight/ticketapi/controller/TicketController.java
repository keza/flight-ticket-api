package com.finartz.flight.ticketapi.controller;

import com.finartz.flight.ticketapi.exception.EntityNotFoundException;
import com.finartz.flight.ticketapi.model.dto.TicketRequest;
import com.finartz.flight.ticketapi.model.dto.TicketResponse;
import com.finartz.flight.ticketapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    TicketService service;

    @PostMapping("/")
    public TicketResponse checkout(@Valid @RequestBody TicketRequest request) throws Exception {
        return service.checkout(request);
    }

    @GetMapping("/{ticketNumber}")
    @ResponseBody
    public TicketResponse find(@PathVariable("ticketNumber") Long ticketNumber) throws EntityNotFoundException {
        return service.findById(ticketNumber);
    }

    @DeleteMapping("/{ticketNumber}")
    public ResponseEntity delete(@PathVariable("ticketNumber") Long ticketNumber) {
        service.delete(ticketNumber);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}