package com.estudo.rivals.service.game;

import org.springframework.stereotype.Service;

import com.estudo.rivals.client.rivalsApiClient;
import com.estudo.rivals.constants.rivalsApiGameEndpoints;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

@Service 
@RequiredArgsConstructor 
public class teamupsService {
    
    private final rivalsApiClient client;

    public JsonNode getAllTeamUps(){
        return client.getRestClient().get()
        .uri(rivalsApiGameEndpoints.ALL_TEAM_UPS)
        .retrieve()
        .body(JsonNode.class);
    }

    public JsonNode getTeamUp(Integer id){
        return client.getRestClient().get()
        .uri(rivalsApiGameEndpoints.ALL_TEAM_UPS + "/" + id)
        .retrieve()
        .body(JsonNode.class);
    }
}
