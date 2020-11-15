package com.mosi.sp.gateway.interfaces;

import com.mosi.sp.gateway.interfaces.dto.SampleDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.flogger.Flogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/samples")
@RequiredArgsConstructor
public class SampleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @GetMapping
    public List<SampleDTO> samples(@RequestHeader(value = "x-user-id", required = false) String userId) {
        LOGGER.info("user id {}", userId);
        return Arrays.asList(
                SampleDTO.builder().id(UUID.randomUUID().toString()).content("content 1").build(),
                SampleDTO.builder().id(UUID.randomUUID().toString()).content("content 2").build()
        );
    }
}
