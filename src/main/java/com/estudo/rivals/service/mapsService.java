package com.estudo.rivals.service;

import com.estudo.rivals.client.rivalsApiClient;
import com.estudo.rivals.constants.rivalsApiEndpoints;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class mapsService {
    private final rivalsApiClient client;

    // Retorna todos os mapas do jogo 
    public String getMaps(){
        return client.getRestClient().get()
        .uri(rivalsApiEndpoints.MAPS)
        .retrieve()
        .body(String.class);
    }
}
