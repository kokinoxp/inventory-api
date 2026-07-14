package com.orporsoft.inventory.debug.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orporsoft.inventory.security.jwt.JwtService;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final JwtService jwtService;

    @GetMapping("/test")
    public String test() {

        return jwtService.generateToken("admin");

    }

}