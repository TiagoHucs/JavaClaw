package com.javaclaw.tools;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ToolRegistry {

    private final Map<String, ITool> tools = new HashMap<>();

    public ToolRegistry(List<ITool> toolList) {
        for (ITool tool : toolList) {
            tools.put(tool.getName(), tool);
        }
    }

    public ITool getTool(String name) {
        return tools.get(name);
    }

    public Collection<ITool> getAllTools() {
        return tools.values();
    }
}
