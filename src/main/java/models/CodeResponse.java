package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeResponse {
    private String result;
    private String documentation;
    private String termsOfUse;

    @JsonProperty("supported_codes")
    private List<List<String>> supportedCodes;

    public String getResult() { return result; }
    public void setResult(String value) { this.result = value; }

    public String getDocumentation() { return documentation; }
    public void setDocumentation(String value) { this.documentation = value; }

    public String getTermsOfUse() {
        return termsOfUse;
    }
    public void setTermsOfUse(String value) { this.termsOfUse = value; }

    public List<List<String>> getSupportedCodes() { return supportedCodes; }
    public void setSupportedCodes(List<List<String>> value) { this.supportedCodes = value; }
}
