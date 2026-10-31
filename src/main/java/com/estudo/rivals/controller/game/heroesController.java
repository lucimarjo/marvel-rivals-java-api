package com.estudo.rivals.controller.game;


import com.estudo.rivals.contracts.game.hero.heroDetailDTO;
import com.estudo.rivals.service.game.heroesService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/heroes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor 
public class heroesController {

    private final heroesService service;
    
    @GetMapping("/all")
        public JsonNode getHeroes(){
            return service.getHeroes();
    }   

    @GetMapping("/{id}")
        public heroDetailDTO getHero(@PathVariable Integer id){
            return service.getHeroId(id);
        }
    }