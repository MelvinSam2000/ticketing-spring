package com.ticketing.tickets.repository;

import com.ticketing.tickets.models.TicketDto;

import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<TicketDto, String> {
    
}
