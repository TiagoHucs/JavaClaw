package com.lumaassistant.aiservice.openrouter.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CostDetails {
    private double upstream_inference_cost;
    private double upstream_inference_prompt_cost;
    private double upstream_inference_completions_cost;

    public double getUpstream_inference_cost() {
        return upstream_inference_cost;
    }

    public void setUpstream_inference_cost(double upstream_inference_cost) {
        this.upstream_inference_cost = upstream_inference_cost;
    }

    public double getUpstream_inference_prompt_cost() {
        return upstream_inference_prompt_cost;
    }

    public void setUpstream_inference_prompt_cost(double upstream_inference_prompt_cost) {
        this.upstream_inference_prompt_cost = upstream_inference_prompt_cost;
    }

    public double getUpstream_inference_completions_cost() {
        return upstream_inference_completions_cost;
    }

    public void setUpstream_inference_completions_cost(double upstream_inference_completions_cost) {
        this.upstream_inference_completions_cost = upstream_inference_completions_cost;
    }
}
