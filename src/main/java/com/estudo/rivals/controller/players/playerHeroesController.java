package com.estudo.rivals.controller.players;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.rivals.service.players.playerHeroesService;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

@RestController 
@RequiredArgsConstructor
@RequestMapping("/players")
public class playerHeroesController {
    private final playerHeroesService service;

    @GetMapping("/{uid}/heroes")
    public JsonNode getAllHeroesStats(@PathVariable Integer uid){
        return service.getAllHeroesStats(uid);
    }

    @GetMapping("/{uid}/heroes/{heroId}")
    public JsonNode getHeroStats(@PathVariable Integer uid, @PathVariable Integer heroId){
        return service.getHeroStats(uid, heroId);
    }
}
