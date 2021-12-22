package com.ticketing.tickets.controllers;

import java.util.List;

import com.ticketing.tickets.models.ReqTicketDto;
import com.ticketing.tickets.models.TicketDto;
import com.ticketing.tickets.services.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/tickets")
@Slf4j
public class TicketController {

    @Autowired
    TicketService ticketService;
    
    @GetMapping("/status")
    public String getStatus() {
        log.debug("status: working!");
        return "Working!";
    }

    @GetMapping("/")
    public ResponseEntity<List<TicketDto>> getTickets() {
        log.debug("Called getTickets...");
        var tickets = ticketService.getTickets();
        return ResponseEntity.accepted().body(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable String id) {
        log.debug("Called getTicketById, id: " + id);
        var ticket = ticketService.getTicketById(id);
        return ResponseEntity.accepted().body(ticket);
    }

    @PostMapping("/")
    public ResponseEntity<Void> createTicket(@RequestBody ReqTicketDto ticket) {
        log.debug("Called createTicket, ticket: " + ticket);
        ticketService.createTicket(ticket);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/")
    public ResponseEntity<Void> updateTicket(@RequestBody ReqTicketDto ticket) {
        log.debug("Called updateTicket, ticket: " + ticket);
        ticketService.updateTicket(ticket);
        return ResponseEntity.ok().build();
    }
    
}
