package com.lumaassistant.aiservice.openrouter.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    private String role;
    private String content;
    private Object refusal;
    private Object reasoning;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getRefusal() {
        return refusal;
    }

    public void setRefusal(Object refusal) {
        this.refusal = refusal;
    }

    public Object getReasoning() {
        return reasoning;
    }

    public void setReasoning(Object reasoning) {
        this.reasoning = reasoning;
    }

    // getters e setters
}
