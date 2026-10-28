package com.estudo.rivals.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.rivals.service.proficiencyService;

@RestController 
@RequestMapping("/proficiency")
@RequiredArgsConstructor 
public class proficiencyController {
    
    private final proficiencyService service;

    @GetMapping("/{id}/rewards")
    public String getRewards(@PathVariable Integer id){
        return service.getRewards(id);
    }

    @GetMapping("/{id}/quests")
    public String getQuests(@PathVariable Integer id){
        return service.getQuests(id);
    }

    @GetMapping("/levels")
    public String getLevels(){
        return service.getLevels();
    }
}
