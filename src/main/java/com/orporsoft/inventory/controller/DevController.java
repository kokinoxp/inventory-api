package com.orporsoft.inventory.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dev")
@RequiredArgsConstructor
public class DevController {

    private final PasswordEncoder encoder;

    @GetMapping("/password")
    public String password() {

        return encoder.encode("admin123");

    }

}