package com.mosi.sp.gateway.interfaces;

import com.mosi.sp.gateway.interfaces.dto.SampleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/samples")
@RequiredArgsConstructor
public class SampleController {

    @GetMapping
    public List<SampleDTO> samples() {
        return Arrays.asList(
                SampleDTO.builder().id(UUID.randomUUID().toString()).content("content 1").build(),
                SampleDTO.builder().id(UUID.randomUUID().toString()).content("content 2").build()
        );
    }
}
