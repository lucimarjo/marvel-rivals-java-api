package com.estudo.rivals.controller.players;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.rivals.service.players.careerService;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

@RestController 
@RequiredArgsConstructor 
@RequestMapping("/players")
public class careerController {
    
    private final careerService service;

    @GetMapping("/{uid}/career")
    public JsonNode getCareerStats(@PathVariable Integer uid){
        return service.getCareerStats(uid);
    }
}
