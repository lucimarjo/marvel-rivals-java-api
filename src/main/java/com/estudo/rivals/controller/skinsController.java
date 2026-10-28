package com.estudo.rivals.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.rivals.service.skinsService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/skins")
@RequiredArgsConstructor 
public class skinsController {
    
    private final skinsService service;

    @GetMapping
    public String getSkinsHero(@RequestParam("heroId") Integer heroId){
        return service.getSkinsHero(heroId);
    }

    @GetMapping("/{skinId}")
    public String getSkinDetail(@PathVariable Integer skinId){
        return service.getSkinDetail(skinId);
    }
}
