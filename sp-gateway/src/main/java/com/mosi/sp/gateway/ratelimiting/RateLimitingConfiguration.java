package com.mosi.sp.gateway.ratelimiting;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimitingConfiguration {

    private static final String HEADER_X_USER_ID = "x-user-id";

    @Bean
    public KeyResolver keyResolver() {
        return exchange -> {
            String userId = exchange.getRequest().getHeaders().getFirst(HEADER_X_USER_ID);
            return Mono.justOrEmpty(userId);
        };
    }
}
