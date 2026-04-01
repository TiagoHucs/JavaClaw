package com.lumaassistant.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapperHelper {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonMapperHelper() {
        // evita instanciar (classe utilitária)
    }

    public static <T> T map(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
