package com.estudo.rivals.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.estudo.rivals.client.rivalsApiClient;
import com.estudo.rivals.constants.rivalsApiEndpoints;


@Service
@RequiredArgsConstructor 
public class heroesService {

    private final rivalsApiClient client;

    /*Retorna todos os herois do jogo */
    public String getHeroes(){
    return client.getRestClient().get()
        .uri(rivalsApiEndpoints.HEROES)
        .retrieve()
        .body(String.class);
    }
    
    /*
    Retorna detalhes do heroi
    Forneça o id para funcionar (1050 é a Mulher Invisivel (minha main)) */
    public String getHeroId(Integer id){
        return client.getRestClient().get()
        .uri(rivalsApiEndpoints.HEROES + "/" + id)
        .retrieve()
        .body(String.class);
    }
}
