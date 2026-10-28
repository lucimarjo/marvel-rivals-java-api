package com.estudo.rivals.service;

import org.springframework.stereotype.Service;

import com.estudo.rivals.client.rivalsApiClient;
import com.estudo.rivals.constants.rivalsApiEndpoints;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class skinsService {
    
    private final rivalsApiClient client;

    public String getSkinsHero(Integer heroId){
        return client.getRestClient().get()
            .uri(rivalsApiEndpoints.SKINS + "?hero_id={heroId}", heroId)
            .retrieve()
            .body(String.class);
    }

    public String getSkinDetail(Integer skinId){
        return client.getRestClient().get()
            .uri(rivalsApiEndpoints.SKINS + "/" + skinId)
            .retrieve()
            .body(String.class);
    }
}
