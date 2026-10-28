package com.estudo.rivals.controller;


import com.estudo.rivals.service.heroesService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController 
@RequestMapping("/heroes")
@RequiredArgsConstructor 
public class heroesController {

    private final heroesService service;
    
    @GetMapping("/all")
        public String getHeroes(){
            return service.getHeroes();
    }   

    @GetMapping("/{id}")
        public String getHero(@PathVariable Integer id){
            return service.getHeroId(id);
        }
    }