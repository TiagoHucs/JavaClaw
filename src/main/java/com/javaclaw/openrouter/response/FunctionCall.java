package com.javaclaw.openrouter.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class FunctionCall {
    private String name;
    private String arguments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public String getArgument(String field) {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> args =
                null;
        try {
            args = mapper.readValue(getArguments(), Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return (String) args.get("folderName");
    }

}
