package com.estudo.rivals.controller.game;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.rivals.service.game.teamupsService;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequiredArgsConstructor
@RequestMapping("/teamups")
public class teamupsController {
    
    private final teamupsService service;

    @GetMapping
    public JsonNode getAllTeamUps() {
        return service.getAllTeamUps();
    }

    @GetMapping("/{id}")
    public JsonNode getTeamUp(@PathVariable Integer id){
        return service.getTeamUp(id);
    }
    
}
