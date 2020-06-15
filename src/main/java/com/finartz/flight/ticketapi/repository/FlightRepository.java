package com.finartz.flight.ticketapi.repository;

import com.finartz.flight.ticketapi.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByNameContaining(String name);

}
