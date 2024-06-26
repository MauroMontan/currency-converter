package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import http.HttpService;
import models.Code;
import models.CodeResponse;
import models.Currency;
import utils.JSONUtils;

import java.util.List;

public class CurrencyExchangeProvider {
    final private String API_KEY;

    private List<Code> cacheCodes;
    final private String BASE_URI = "https://v6.exchangerate-api.com/v6";

    public CurrencyExchangeProvider(){
        API_KEY = System.getenv("API_KEY");
    }

    // GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP
    public Currency pairConvert(String from, String to){

        String res = HttpService.fetchData(buildQuery("pair",from ,to));

        return JSONUtils.encode(res, Currency.class);
    }

    public Double quantityConverter(Currency currency, Double amount){
        return currency.getConversionRate() * amount;
    }

    public List<Code> getCurrencyCodes() {
        if (cacheCodes == null){
            String res = HttpService.fetchData(buildQuery("codes"));
            CodeResponse codes = JSONUtils.encode(res, CodeResponse.class);
            cacheCodes = codes.getSupportedCodes().stream().map(code -> new Code(code)).toList();
        }

        return cacheCodes;

    }

    public String getCurrencyName(String strCode) {
        List<Code> codes = getCurrencyCodes();

        var temp = codes.stream().filter(code -> code.getCode().equals(strCode.toUpperCase())).toList();

        return temp.get(0).getName();
    }
    private String buildQuery(String ...query){
        return BASE_URI + "/" + API_KEY +"/"+ String.join("/",query);
    }
}
