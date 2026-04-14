package com.javaclaw.openrouter.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    private String role;
    private String content;
    private Object refusal;
    private Object reasoning;

    @JsonProperty("tool_calls")
    private List<ToolCall> toolCalls;

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

    public List<ToolCall> getToolCalls() {
        return toolCalls;
    }

    public void setToolCalls(List<ToolCall> toolCalls) {
        this.toolCalls = toolCalls;
    }
}
