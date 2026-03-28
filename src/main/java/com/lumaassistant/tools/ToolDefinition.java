package com.lumaassistant.tools;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ToolDefinition {

    private String type = "function";
    private Function function;

    public String getType() {
        return type;
    }

    public Function getFunction() {
        return function;
    }

    public ToolDefinition(ITool tool) {
        this.function = new Function(tool);
    }

    public static class Function {
        private String name;
        private String description;
        private Object parameters;

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public Object getParameters() {
            return parameters;
        }

        public Function(ITool tool) {
            this.name = tool.getName();
            this.description = tool.getDescription();

            try {
                ObjectMapper mapper = new ObjectMapper();
                this.parameters = mapper.readValue(
                        tool.getInputSchema(), Object.class
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
