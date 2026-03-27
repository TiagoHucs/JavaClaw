package com.lumaassistant.aiservice.openrouter.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Choice {
    private int index;
    private Object logprobs;
    private String finish_reason;
    private String native_finish_reason;
    private Message message;

    public Message getMessage() {
        return message;
    }

}
