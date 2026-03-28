package com.lumaassistant.tools;

import org.springframework.stereotype.Component;

@Component
public class ToolExecutor {

    private final ToolRegistry registry;

    public ToolExecutor(ToolRegistry registry) {
        this.registry = registry;
    }

    public String execute(String toolName, String inputJson) throws Exception {

        ITool tool = registry.getTool(toolName);

        if (tool == null) {
            throw new RuntimeException("Tool não encontrada: " + toolName);
        }

        return tool.execute(inputJson);
    }
}
