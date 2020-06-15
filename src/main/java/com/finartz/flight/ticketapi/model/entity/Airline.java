package com.finartz.flight.ticketapi.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Airline {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name alanı gereklidir.")
    private String name;
}
