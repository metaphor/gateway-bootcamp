package com.mosi.sp.gateway.filter;

import com.mosi.sp.gateway.client.SpAuthClient;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    public static final String HEADER_X_USER_ID = "x-user-id";
    private final SpAuthClient spAuthClient;

    @Override
    public Mono<Void> filter(final ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (Strings.isEmpty(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String realToken = token.replace("Bearer ", "");
        return spAuthClient.userFromToken(realToken)
                .map(userDTO -> populateUserInHeader(exchange, userDTO))
                .flatMap(chain::filter);
    }

    private ServerWebExchange populateUserInHeader(ServerWebExchange exchange, com.mosi.sp.gateway.client.UserDTO userDTO) {
        ServerHttpRequest request = exchange.getRequest().mutate().header(HEADER_X_USER_ID, userDTO.getId()).build();
        return exchange.mutate().request(request).build();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
