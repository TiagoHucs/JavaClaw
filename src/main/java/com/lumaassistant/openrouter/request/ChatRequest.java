package com.lumaassistant.openrouter.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lumaassistant.tools.ToolDefinition;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatRequest {
    private String model = "openrouter/free";
    private List<RequestMessage> messages;
    private List<ToolDefinition> tools;

    @JsonProperty("tool_choice")
    private String toolChoice;

    private Double temperature;

    @JsonProperty("max_tokens")
    private Integer maxTokens;

    private Boolean stream;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<RequestMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<RequestMessage> messages) {
        this.messages = messages;
    }

    public List<ToolDefinition> getTools() {
        return tools;
    }

    public void setTools(List<ToolDefinition> tools) {
        this.tools = tools;
    }

    public String getToolChoice() {
        return toolChoice;
    }

    public void setToolChoice(String toolChoice) {
        this.toolChoice = toolChoice;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public Boolean getStream() {
        return stream;
    }

    public void setStream(Boolean stream) {
        this.stream = stream;
    }
}
