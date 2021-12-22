package com.ticketing.auth.controllers;

import com.ticketing.auth.models.AuthTokenDto;
import com.ticketing.auth.models.ReqUserDto;
import com.ticketing.auth.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping("/status")
    public String getStatus() {
        log.debug("status: working!");
        return "Working!";
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(ReqUserDto user) {
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/signin")
    public ResponseEntity<AuthTokenDto> signIn(ReqUserDto user) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signout")
    public ResponseEntity<String> signOut() {
        return ResponseEntity.ok().build();
    }
}
