package com.ticketing.auth.services;

import java.util.List;

import com.ticketing.auth.models.ReqUserDto;
import com.ticketing.auth.models.UserDto;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    List<UserDto> users;

    @Override
    public void createUser(ReqUserDto user) {
        if (this.emailExists(user.getEmail())) {
            // throw exception
        }
        validateCredentials(user.getEmail(), user.getRawPassword());
        UserDto newUser = new UserDto();
        newUser.setEmail(user.getEmail());
        newUser.setHashedPassword(user.getRawPassword());
        users.add(newUser);
    }

    @Override
    public boolean validateUser(ReqUserDto user) {
        return false;
    }

    @Override
    public boolean emailExists(String email) {
        // TODO Auto-generated method stub
        return false;
    }
    
    private void validateCredentials(String email, String rawPassword) {
    }
}
