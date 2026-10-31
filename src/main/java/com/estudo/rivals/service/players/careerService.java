package com.estudo.rivals.service.players;

import org.springframework.stereotype.Service;

import com.estudo.rivals.client.rivalsApiClient;
import com.estudo.rivals.constants.rivalsApiPlayerEndpoints;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

@Service 
@RequiredArgsConstructor 
public class careerService {
    
    private final rivalsApiClient client;

    public JsonNode getCareerStats(Integer uid){
        return client.getRestClient().get()
        .uri(rivalsApiPlayerEndpoints.PLAYERS + rivalsApiPlayerEndpoints.UID + rivalsApiPlayerEndpoints.CAREER, uid)
        .retrieve()
        .body(JsonNode.class);
    }
}
