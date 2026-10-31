package com.estudo.rivals.controller.game;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.rivals.service.game.mapsService;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;


@RestController 
@RequestMapping("/maps")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor 
public class mapsController {
    
    private final mapsService service;

    @GetMapping
    public JsonNode getMaps(){
        return service.getMaps();
    }
}
