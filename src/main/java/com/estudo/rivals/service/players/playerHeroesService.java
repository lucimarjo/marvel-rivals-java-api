package com.estudo.rivals.service.players;

import org.springframework.stereotype.Service;

import com.estudo.rivals.client.rivalsApiClient;
import com.estudo.rivals.constants.rivalsApiGameEndpoints;
import com.estudo.rivals.constants.rivalsApiPlayerEndpoints;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

@Service 
@RequiredArgsConstructor 
public class playerHeroesService {
    
    private final rivalsApiClient client;

    public JsonNode getAllHeroesStats(Integer uid){
        return client.getRestClient().get()
        .uri(rivalsApiPlayerEndpoints.PLAYERS + rivalsApiPlayerEndpoints.UID + rivalsApiPlayerEndpoints.ALL_HEROES, uid)
        .retrieve()
        .body(JsonNode.class);
    }

    public JsonNode getHeroStats(Integer uid, Integer heroId){ 
        return client.getRestClient().get()
        .uri(rivalsApiPlayerEndpoints.PLAYERS + rivalsApiPlayerEndpoints.UID + rivalsApiPlayerEndpoints.HEROES + rivalsApiGameEndpoints.HERO_ID, uid, heroId)
        .retrieve()
        .body(JsonNode.class);
    }
}
