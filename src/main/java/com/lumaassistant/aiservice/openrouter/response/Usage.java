package com.lumaassistant.aiservice.openrouter.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public  class Usage {
    private int prompt_tokens;
    private int completion_tokens;
    private int total_tokens;
    private double cost;
    private boolean is_byok;
    private PromptTokensDetails prompt_tokens_details;
    private CostDetails cost_details;
    private CompletionTokensDetails completion_tokens_details;

}