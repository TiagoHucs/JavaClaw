package com.lumaassistant.aiservice.openrouter.response;

public class ToolCall {

    private String id;
    private String type;
    private FunctionCall function;

    public FunctionCall getFunction() {
        return function;
    }
}
