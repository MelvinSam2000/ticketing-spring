package com.ticketing.tickets.controllers;

import java.util.List;

import com.ticketing.tickets.models.ReqTicketDto;
import com.ticketing.tickets.models.TicketDto;
import com.ticketing.tickets.services.TicketService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    Logger logger = LoggerFactory.getLogger(TicketController.class);

    @Autowired
    TicketService ticketService;
    
    @GetMapping("/status")
    public String getStatus() {
        logger.debug("status: working!");
        return "Working!";
    }

    @GetMapping("/")
    public ResponseEntity<List<TicketDto>> getTickets() {
        logger.debug("Called getTickets...");
        var tickets = ticketService.getTickets();
        return ResponseEntity.accepted().body(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable String id) {
        logger.debug("Called getTicketById, id: " + id);
        var ticket = ticketService.getTicketById(id);
        return ResponseEntity.accepted().body(ticket);
    }

    @PostMapping("/")
    public ResponseEntity<Void> createTicket(@RequestBody ReqTicketDto ticket) {
        logger.debug("Called createTicket, ticket: " + ticket);
        ticketService.createTicket(ticket);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/")
    public ResponseEntity<Void> updateTicket(@RequestBody ReqTicketDto ticket) {
        logger.debug("Called updateTicket, ticket: " + ticket);
        ticketService.updateTicket(ticket);
        return ResponseEntity.ok().build();
    }
    
}
