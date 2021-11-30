package com.ticketing.tickets.services;

import java.util.List;

import com.ticketing.tickets.models.ReqTicketDto;
import com.ticketing.tickets.models.TicketDto;

public interface TicketService {
    List<TicketDto> getTickets();
    TicketDto getTicketById(String id);
    void createTicket(ReqTicketDto ticket);
    void updateTicket(ReqTicketDto ticket);
}
