package com.lumaassistant.aiservice.openrouter.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompletionTokensDetails {
    private int reasoning_tokens;
    private int image_tokens;
    private int audio_tokens;

    // getters e setters
}
