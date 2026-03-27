package com.lumaassistant.aiservice.openrouter.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CostDetails {
    private double upstream_inference_cost;
    private double upstream_inference_prompt_cost;
    private double upstream_inference_completions_cost;

    // getters e setters
}
