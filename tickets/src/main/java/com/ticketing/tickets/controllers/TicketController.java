package com.ticketing.tickets.controllers;

import java.util.List;

import com.ticketing.tickets.models.ReqTicketDto;
import com.ticketing.tickets.models.TicketDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    @GetMapping("/status")
    public String getStatus() {
        logger.debug("status: working!");
        return "Working!";
    }

    @GetMapping("/")
    public ResponseEntity<List<TicketDto>> getTickets() {
        logger.debug("Called getTickets...");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable String id) {
        logger.debug("Called getTicketById, id: " + id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    public ResponseEntity<Void> createTicket(@RequestBody ReqTicketDto ticket) {
        logger.debug("Called createTicket, ticket: " + ticket);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/")
    public ResponseEntity<Void> updateTicket(@RequestBody ReqTicketDto ticket) {
        logger.debug("Called updateTicket, ticket: " + ticket);
        return ResponseEntity.ok().build();
    }
    
}
