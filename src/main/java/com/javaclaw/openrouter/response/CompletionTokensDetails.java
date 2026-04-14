package com.javaclaw.openrouter.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompletionTokensDetails {
    private int reasoning_tokens;
    private int image_tokens;
    private int audio_tokens;

    public int getReasoning_tokens() {
        return reasoning_tokens;
    }

    public void setReasoning_tokens(int reasoning_tokens) {
        this.reasoning_tokens = reasoning_tokens;
    }

    public int getImage_tokens() {
        return image_tokens;
    }

    public void setImage_tokens(int image_tokens) {
        this.image_tokens = image_tokens;
    }

    public int getAudio_tokens() {
        return audio_tokens;
    }

    public void setAudio_tokens(int audio_tokens) {
        this.audio_tokens = audio_tokens;
    }
}
