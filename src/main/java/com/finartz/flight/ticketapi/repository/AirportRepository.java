package com.finartz.flight.ticketapi.repository;

import com.finartz.flight.ticketapi.model.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findByNameContaining(String name);
}
