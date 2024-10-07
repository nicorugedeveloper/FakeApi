package com.api.fakeapi.service;

import com.api.fakeapi.model.request.AuthRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AuthService {

    private final WebClient webClient;

    public AuthService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.escuelajs.co/api/v1").build();
    }

    public Mono<String> login(AuthRequest authRequest) {
        return this.webClient.post()
                .uri("/auth/login")
                .bodyValue(authRequest)
                .retrieve()
                .bodyToMono(String.class);
    }
}

