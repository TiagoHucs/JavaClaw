package com.lumaassistant.openrouter.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PromptTokensDetails {
    private int cached_tokens;
    private int cache_write_tokens;
    private int audio_tokens;
    private int video_tokens;

    public int getCached_tokens() {
        return cached_tokens;
    }

    public void setCached_tokens(int cached_tokens) {
        this.cached_tokens = cached_tokens;
    }

    public int getCache_write_tokens() {
        return cache_write_tokens;
    }

    public void setCache_write_tokens(int cache_write_tokens) {
        this.cache_write_tokens = cache_write_tokens;
    }

    public int getAudio_tokens() {
        return audio_tokens;
    }

    public void setAudio_tokens(int audio_tokens) {
        this.audio_tokens = audio_tokens;
    }

    public int getVideo_tokens() {
        return video_tokens;
    }

    public void setVideo_tokens(int video_tokens) {
        this.video_tokens = video_tokens;
    }
}
