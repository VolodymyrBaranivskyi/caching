package com.interview.caching.view.controller;

import com.interview.caching.view.dto.Dto;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

public class Response {

    private Response() {
    }


    public static ResponseEntity<List<? extends Dto>> okWith(List<? extends Dto> dtos) {
        return new ResponseEntity<>(dtos, OK);
    }

    public static ResponseEntity<Dto> okWith(Dto dto) {
        return new ResponseEntity<>(dto, OK);
    }

    public static ResponseEntity<?> okWith(String message) {
        return new ResponseEntity<>(message, OK);
    }

}
