package com.lumaassistant.tools;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToolDefinitionFactory {

    private final ToolRegistry registry;

    public ToolDefinitionFactory(ToolRegistry registry) {
        this.registry = registry;
    }

    public List<ToolDefinition> getToolDefinitions() {
        return registry.getAllTools()
                .stream()
                .map(ToolDefinition::new)
                .toList();
    }
}
