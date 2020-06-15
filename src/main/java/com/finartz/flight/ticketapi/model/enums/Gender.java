package com.finartz.flight.ticketapi.model.enums;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}