package com.mosi.sp.gateway.interfaces;

import com.mosi.sp.gateway.interfaces.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/{token}/from-token")
    public UserDTO userFromToken(@PathVariable("token") String token) {
        return UserDTO.builder().id("MOSI99999").name("MOSI").build();
    }
}
