package com.lumaassistant.openrouter.response;

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

    public int getPrompt_tokens() {
        return prompt_tokens;
    }

    public void setPrompt_tokens(int prompt_tokens) {
        this.prompt_tokens = prompt_tokens;
    }

    public int getCompletion_tokens() {
        return completion_tokens;
    }

    public void setCompletion_tokens(int completion_tokens) {
        this.completion_tokens = completion_tokens;
    }

    public int getTotal_tokens() {
        return total_tokens;
    }

    public void setTotal_tokens(int total_tokens) {
        this.total_tokens = total_tokens;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isIs_byok() {
        return is_byok;
    }

    public void setIs_byok(boolean is_byok) {
        this.is_byok = is_byok;
    }

    public PromptTokensDetails getPrompt_tokens_details() {
        return prompt_tokens_details;
    }

    public void setPrompt_tokens_details(PromptTokensDetails prompt_tokens_details) {
        this.prompt_tokens_details = prompt_tokens_details;
    }

    public CostDetails getCost_details() {
        return cost_details;
    }

    public void setCost_details(CostDetails cost_details) {
        this.cost_details = cost_details;
    }

    public CompletionTokensDetails getCompletion_tokens_details() {
        return completion_tokens_details;
    }

    public void setCompletion_tokens_details(CompletionTokensDetails completion_tokens_details) {
        this.completion_tokens_details = completion_tokens_details;
    }
}