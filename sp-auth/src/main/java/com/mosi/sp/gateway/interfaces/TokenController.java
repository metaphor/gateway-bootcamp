package com.mosi.sp.gateway.interfaces;

import com.mosi.sp.gateway.interfaces.dto.TokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("tokens")
public class TokenController {

    @PostMapping
    public TokenDTO create() {
        return TokenDTO.builder().token("i.am.token").build();
    }
}
