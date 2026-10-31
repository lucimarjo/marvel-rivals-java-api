package com.estudo.rivals.service.game;

import org.springframework.stereotype.Service;

import com.estudo.rivals.client.rivalsApiClient;
import com.estudo.rivals.constants.rivalsApiGameEndpoints;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class skinsService {
    
    private final rivalsApiClient client;

    public String getSkinsHero(Integer heroId){
        return client.getRestClient().get()
            .uri(rivalsApiGameEndpoints.SKINS + rivalsApiGameEndpoints.HERO_SKIN_ID, heroId)
            .retrieve()
            .body(String.class);
    }

    public String getSkinDetail(Integer skinId){
        return client.getRestClient().get()
            .uri(rivalsApiGameEndpoints.SKINS + "/" + skinId)
            .retrieve()
            .body(String.class);
    }
}
