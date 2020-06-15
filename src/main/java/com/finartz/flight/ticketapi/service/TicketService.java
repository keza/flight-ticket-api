package com.finartz.flight.ticketapi.service;

import com.finartz.flight.ticketapi.exception.EntityNotFoundException;
import com.finartz.flight.ticketapi.exception.GlobalException;
import com.finartz.flight.ticketapi.model.dto.TicketRequest;
import com.finartz.flight.ticketapi.model.dto.TicketResponse;
import com.finartz.flight.ticketapi.model.entity.Flight;
import com.finartz.flight.ticketapi.model.entity.Ticket;
import com.finartz.flight.ticketapi.repository.TicketRepository;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TicketService {

    @Autowired
    TicketRepository repository;

    @Autowired
    FlightService flightService;

    @Autowired
    ModelMapper modelMapper;

    public TicketResponse findById(Long id) throws EntityNotFoundException {
        Ticket ticket = repository.findById(id).orElse(null);

        if (ticket == null) {
            throw new EntityNotFoundException(Ticket.class, "id", id.toString());
        }

        return mapTicketToTicketResponse(ticket);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public TicketResponse checkout (TicketRequest request) throws Exception {
        Flight flight = null;
        String validCardNumber = creditCardNumberReplace(request.getCreditCardNumber());

        if (StringUtils.isBlank(validCardNumber) || validCardNumber.length() != 16) {
            throw new GlobalException(TicketRequest.class, "Kredi kartı numarası 16 hane olmalıdır");
        }
        validCardNumber = maskString(validCardNumber,6,12, '*');

        flight = flightService.findById(request.getFlight().getId());

        Ticket ticket = modelMapper.map(request, Ticket.class);
        ticket.setCreditCardNumber(validCardNumber);
        ticket.setPrice(flight.getPrice());

        flightService.ticketSold(flight);

        ticket = repository.save(ticket);

        return mapTicketToTicketResponse(ticket);
    }

    private TicketResponse mapTicketToTicketResponse(Ticket ticket) {
        TicketResponse response = null;

        ModelMapper responseMapper = new ModelMapper();
        TypeMap<Ticket, TicketResponse> typeMap = responseMapper.createTypeMap(Ticket.class,TicketResponse.class);
        typeMap.addMappings(mapper -> {
            mapper.map(src -> src.getId(), TicketResponse::setTicketNumber);
        });

        response = responseMapper.map(ticket,TicketResponse.class);
        return response;
    }

    private String creditCardNumberReplace(String creditCardNumber) {
        return creditCardNumber.replaceAll("[^0-9]", "");
    }

    private static String maskString(String strText, int start, int end, char maskChar) throws Exception{

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
