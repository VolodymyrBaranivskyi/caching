package com.interview.caching.view.controller;

import com.interview.caching.logic.services.StreetService;
import com.interview.caching.model.Street;
import com.interview.caching.view.dto.mappers.StreetMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.interview.caching.view.controller.Response.okWith;

@Slf4j
@RestController
@RequestMapping("/streets")
public class StreetController {

    private final StreetService streetService;
    private final StreetMapper streetMapper;

    public StreetController(StreetService streetService, StreetMapper streetMapper) {
        this.streetService = streetService;
        this.streetMapper = streetMapper;
    }

    @GetMapping("/{streetName}")
    public ResponseEntity<?> getById(@PathVariable String streetName) {

        Street street = streetService.getCordinateByName(streetName);
        return okWith(street.getCordinates());


    }
}
