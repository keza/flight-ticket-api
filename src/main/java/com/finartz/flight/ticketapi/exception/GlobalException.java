package com.finartz.flight.ticketapi.exception;

import org.apache.commons.lang3.StringUtils;

public class GlobalException extends Exception {

    public GlobalException(Class clazz, String message) {
        super(GlobalException.generateMessage(clazz.getSimpleName(), message));
    }

    private static String generateMessage(String entity, String message) {
        return "(" + StringUtils.capitalize(entity) + ") " + message;
    }
}