package com.estudo.rivals.mappers;

import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import com.estudo.rivals.contracts.game.hero.heroDetailDTO;
import com.estudo.rivals.response.hero.heroResponse;

import lombok.RequiredArgsConstructor;


@Component 
@RequiredArgsConstructor 
public class heroMapper {
    private final ObjectMapper objectMapper;

    public heroDetailDTO toHeroDetailDTO(heroResponse hero){
        return objectMapper.convertValue(hero, heroDetailDTO.class);
    }
}
