package com.estudo.rivals.service.game;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

import com.estudo.rivals.client.rivalsApiClient;
import com.estudo.rivals.constants.rivalsApiGameEndpoints;
import com.estudo.rivals.contracts.game.hero.heroDetailDTO;


@Service
@RequiredArgsConstructor 
public class heroesService {

    private final rivalsApiClient client;

    /*Retorna todos os herois do jogo */
    public JsonNode getHeroes(){
    return client.getRestClient().get()
        .uri(rivalsApiGameEndpoints.HEROES)
        .retrieve()
        .body(JsonNode.class);
    }
    
    /*
    Retorna detalhes do heroi
    Forneça o id para funcionar (1050 é a Mulher Invisivel (minha main)) */
    public heroDetailDTO getHeroId(Integer id){
        return client.getRestClient().get()
        .uri(rivalsApiGameEndpoints.HEROES + "/" + id)
        .retrieve()
        .body(heroDetailDTO.class);
    }
}
