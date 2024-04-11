package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class Currency {

    private String result;
    private String documentation;

    @JsonProperty("base_code")
    private String baseCode;
    @JsonProperty("target_code")
    private String targetCode;

    @JsonProperty("conversion_rate")
    private double conversionRate;

    public Currency(){}


    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return baseCode;
    }


    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

}
