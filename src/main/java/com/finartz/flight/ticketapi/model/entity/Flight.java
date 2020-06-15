package com.finartz.flight.ticketapi.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name alanı gereklidir.")
    private String name;

    @OneToOne
    private Route route;

    @OneToOne
    private Airline airline;

    @Min(0)
    @Max(100)
    private Integer quota;

    private Integer sold;

    private Double price;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date date;

    @Basic
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Date time;

}
