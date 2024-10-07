package com.api.fakeapi.controller;

import com.api.fakeapi.model.request.AuthRequest;
import com.api.fakeapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/login")
    public Mono<String> authenticate(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }
}
