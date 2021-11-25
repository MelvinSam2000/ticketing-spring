package com.ticketing.auth.models;

import lombok.Data;

public @Data class ReqUserDto {
    private String email;
    private String rawPassword;
}
