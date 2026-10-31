package com.estudo.rivals.controller.players;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.rivals.service.players.searchService;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

@RestController 
@RequiredArgsConstructor 
@RequestMapping("/players") 
public class searchController {
    
    private final searchService service;

    /* exemplo de uso:
       /players/search?name=lucimarjo1 (minha conta)
       retorna informações gerais sobre a conta*/
    @GetMapping("/search")
    public JsonNode getSearchPlayer(@RequestParam("name") String playerName){
        return service.getSearchPlayer(playerName);
    }

    @GetMapping("/{uid}")
    public JsonNode getPlayer(@PathVariable Integer uid){
        return service.getPlayerProfile(uid);
    }
}
