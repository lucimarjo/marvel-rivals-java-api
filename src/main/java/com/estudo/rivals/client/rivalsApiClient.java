package com.estudo.rivals.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class rivalsApiClient {
    private final RestClient client;

    public rivalsApiClient(
            @Value("${API.LINK}") String API_LINK,
            @Value("${API.KEY}") String API_KEY){
        
        this.client = RestClient.builder()
            .baseUrl(API_LINK)
            .defaultHeader("x-api-key", API_KEY)
            .build();
        }

    public RestClient getRestClient(){
        return client;
    }
}
