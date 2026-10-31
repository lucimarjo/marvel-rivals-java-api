package com.estudo.rivals.service.game;

import com.estudo.rivals.client.rivalsApiClient;
import com.estudo.rivals.constants.rivalsApiGameEndpoints;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

@Service
@RequiredArgsConstructor 
public class mapsService {
    private final rivalsApiClient client;

    // Retorna todos os mapas do jogo 
    public JsonNode getMaps(){
        return client.getRestClient().get()
        .uri(rivalsApiGameEndpoints.MAPS)
        .retrieve()
        .body(JsonNode.class);
    }
}
