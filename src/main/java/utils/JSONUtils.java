package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

    static public <T> T encode(String data,Class<T> type ){
        try {
            T encoded = new ObjectMapper().readValue(data,type);
            return encoded;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
