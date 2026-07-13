package com.orporsoft.inventory.controller;

import com.orporsoft.inventory.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final JwtService jwtService;

    @GetMapping("/test")
    public String test() {

        return jwtService.generateToken("admin");

    }

}