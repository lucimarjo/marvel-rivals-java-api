package com.estudo.rivals.controller.game;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.rivals.service.game.skinsService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/skins")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor 
public class skinsController {
    
    private final skinsService service;

    /*  exemplo de uso: 
        /skins?heroId=1052 
        retorna todas as skins do heroi 1052*/
    @GetMapping
    public String getSkinsHero(@RequestParam("heroId") Integer heroId){
        return service.getSkinsHero(heroId);
    }

    @GetMapping("/{skinId}")
    public String getSkinDetail(@PathVariable Integer skinId){
        return service.getSkinDetail(skinId);
    }
}
