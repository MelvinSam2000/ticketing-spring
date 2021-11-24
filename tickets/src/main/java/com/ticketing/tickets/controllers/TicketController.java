package com.ticketing.tickets.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
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
    
}
