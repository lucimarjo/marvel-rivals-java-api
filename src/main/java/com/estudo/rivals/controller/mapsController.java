package com.estudo.rivals.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import com.estudo.rivals.service.mapsService;


@RestController 
@RequestMapping("/maps")
@RequiredArgsConstructor 
public class mapsController {
    
    private final mapsService service;

    @GetMapping
    public String getMaps(){
        return service.getMaps();
    }
}
