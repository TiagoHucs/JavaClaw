package com.lumaassistant.aiservice.openrouter.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private String id;
    private String object;
    private long created;
    private String model;
    private String provider;
    private String system_fingerprint;
    private List<Choice> choices;
    private Usage usage;

    public List<Choice> getChoices() {
        return choices;
    }


}
