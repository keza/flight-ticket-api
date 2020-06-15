package com.finartz.flight.ticketapi.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Route {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name alanı gereklidir.")
    private String name;

    @OneToOne
    private Airport from;

    @OneToOne
    private Airport to;

    private Long distance;
}
