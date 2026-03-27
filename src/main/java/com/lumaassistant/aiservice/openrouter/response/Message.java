package com.lumaassistant.aiservice.openrouter.response;

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

    public String getContent() {
        return content;
    }

    public List<ToolCall> getToolCalls(){
        return toolCalls;
    }


}
