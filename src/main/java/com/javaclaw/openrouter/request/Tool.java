package com.javaclaw.openrouter.request;

public class Tool {

    private String type; // "function"
    private FunctionDefinition function;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FunctionDefinition getFunction() {
        return function;
    }

    public void setFunction(FunctionDefinition function) {
        this.function = function;
    }
}
