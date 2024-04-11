package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import http.HttpService;
import models.Currency;

public class CurrencyExchangeProvider {
    final String URI = "https://dont-starve-together-api.xyz/api/crockpot-recipes?page=1";


    public void convert(){
        String res = HttpService.fetchData(URI);
        System.out.println(convertToJson(res).getTotalPages());
    }

    private Currency convertToJson(String data){
        try {
            Currency currency = new ObjectMapper().readValue(data, Currency.class);
            return currency;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
