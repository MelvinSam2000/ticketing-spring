package com.ticketing.auth.models;

import lombok.Data;

public @Data class UserDto {
    private String id;
    private String email;
    private String hashedPassword;
    private String passwordSalt;
}
