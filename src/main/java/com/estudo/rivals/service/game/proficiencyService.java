package com.estudo.rivals.service.game;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.estudo.rivals.client.rivalsApiClient;
import com.estudo.rivals.constants.rivalsApiGameEndpoints;


@Service
@RequiredArgsConstructor 
public class proficiencyService {
 
    private final rivalsApiClient client;

    public String getRewards(Integer id){
        return client.getRestClient().get()
        .uri(rivalsApiGameEndpoints.HEROES + "/" + id + rivalsApiGameEndpoints.PROFICIENCY_REWARDS)
        .retrieve()
        .body(String.class);
    }

    public String getQuests(Integer id){
        return client.getRestClient().get()
        .uri(rivalsApiGameEndpoints.HEROES + "/" + id + rivalsApiGameEndpoints.PROFICIENCY_QUESTS)
        .retrieve()
        .body(String.class);
    }

    public String getLevels(){
        return client.getRestClient().get()
        .uri(rivalsApiGameEndpoints.PROFICIENCY_LEVELS)
        .retrieve()
        .body(String.class);
    }
}
