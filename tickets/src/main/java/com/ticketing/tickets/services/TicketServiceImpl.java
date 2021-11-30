package com.ticketing.tickets.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ticketing.tickets.models.ReqTicketDto;
import com.ticketing.tickets.models.TicketDto;
import com.ticketing.tickets.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<TicketDto> getTickets() {
        List<TicketDto> tickets = new ArrayList<>();
        for (var ticket : ticketRepository.findAll())
            tickets.add(ticket);
        return tickets;
    }

    @Override
    public TicketDto getTicketById(String id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public void createTicket(ReqTicketDto ticket) {
        TicketDto ticketDto = new TicketDto();
        String uuid = UUID.randomUUID().toString();
        ticketDto.setId(uuid);
        ticketDto.setTitle(ticket.getTitle());
        ticketDto.setPrice(ticket.getPrice());
        ticketRepository.save(ticketDto);
    }

    @Override
    public void updateTicket(ReqTicketDto ticket) {
        // TODO Auto-generated method stub
        
    }
    
}
