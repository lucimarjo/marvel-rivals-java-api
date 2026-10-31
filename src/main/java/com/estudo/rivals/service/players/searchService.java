package com.estudo.rivals.service.players;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

import com.estudo.rivals.client.rivalsApiClient;
import com.estudo.rivals.constants.rivalsApiPlayerEndpoints;


@Service 
@RequiredArgsConstructor 
public class searchService {
    private final rivalsApiClient client;

    public JsonNode getSearchPlayer(String playerName){
        return client.getRestClient().get()
        .uri(rivalsApiPlayerEndpoints.PLAYERS + rivalsApiPlayerEndpoints.SEARCH + rivalsApiPlayerEndpoints.PLAYER_NAME, playerName)
        .retrieve()
        .body(JsonNode.class);
    }

    public JsonNode getPlayerProfile(Integer uid){
        return client.getRestClient().get()
        .uri(rivalsApiPlayerEndpoints.PLAYERS + rivalsApiPlayerEndpoints.UID, uid)
        .retrieve()
        .body(JsonNode.class);
    }
}
