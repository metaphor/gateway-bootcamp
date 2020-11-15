package com.mosi.sp.gateway.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SpAuthClient {

    private final WebClient webClient;

    public SpAuthClient(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("http://sp-auth/users")
                .build();
    }

    public Mono<UserDTO> userFromToken(String token) {
        return webClient.get()
                .uri("/{token}/from-token", token)
                .retrieve()
                .bodyToMono(UserDTO.class);

    }
}
