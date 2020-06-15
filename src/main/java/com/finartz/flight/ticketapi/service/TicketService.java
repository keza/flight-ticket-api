package com.finartz.flight.ticketapi.service;

import com.finartz.flight.ticketapi.model.dto.TicketRequest;
import com.finartz.flight.ticketapi.repository.TicketRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    TicketRepository repository;

    public String checkout (String request) throws Exception {
        //String validCardNumber = creditCardNumberReplace(request.getCreditCardNumber());
            request = creditCardNumberReplace(request);
        if (StringUtils.isBlank(request) || request.length() != 16) {
            return "hatali kart";
        }

        return maskString(request,6,12, '*');
    }

    private String creditCardNumberReplace(String creditCardNumber) {
        return creditCardNumber.replaceAll("[^0-9]", "");
    }

    private static String maskString(String strText, int start, int end, char maskChar)
            throws Exception{

        if(strText == null || strText.equals(""))
            return "";

        if(start < 0)
            start = 0;

        if( end > strText.length() )
            end = strText.length();

        if(start > end)
            throw new Exception("End index cannot be greater than start index");

        int maskLength = end - start;

        if(maskLength == 0)
            return strText;

        String strMaskString = StringUtils.repeat(maskChar, maskLength);

        return StringUtils.overlay(strText, strMaskString, start, end);
    }
}
