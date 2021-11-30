package com.ticketing.tickets.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("ticket")
public @Data class TicketDto {
    
    @Id
    private String id;
    private String title;
    private double price;
    private String userId;
}
