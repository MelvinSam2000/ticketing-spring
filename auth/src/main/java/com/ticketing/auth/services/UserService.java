package com.ticketing.auth.services;

import com.ticketing.auth.models.ReqUserDto;

public interface UserService {
    
    public void createUser(ReqUserDto user);
    public boolean validateUser(ReqUserDto user);
    public boolean emailExists(String email);
}
