package com.ticketing.auth.exceptions;

public class InvalidCredentialsException extends Exception {
    
    public InvalidCredentialsException(String message, Throwable err) {
        super(message, err);
    }
}
