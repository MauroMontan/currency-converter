package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import http.HttpService;
import models.Currency;

public class CurrencyExchangeProvider {
    final private String API_KEY;
    final private String BASE_URI = "https://v6.exchangerate-api.com/v6";

    public CurrencyExchangeProvider(){
        API_KEY = System.getenv("API_KEY");
    }

    // GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP
    public Currency pairConvert(String from, String to){

        String res = HttpService.fetchData(buildQuery("pair",from ,to));

        return convertToJson(res);

    }
    private String buildQuery(String ...query){
        return BASE_URI + "/" + API_KEY +"/"+ String.join("/",query);
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
