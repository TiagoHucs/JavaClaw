package com.lumaassistant.aiservice.openrouter.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PromptTokensDetails {
    private int cached_tokens;
    private int cache_write_tokens;
    private int audio_tokens;
    private int video_tokens;

}
