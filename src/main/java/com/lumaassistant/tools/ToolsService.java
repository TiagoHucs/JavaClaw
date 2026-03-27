package com.lumaassistant.tools;

import com.lumaassistant.aiservice.openrouter.request.FunctionDefinition;
import com.lumaassistant.aiservice.openrouter.request.Parameters;
import com.lumaassistant.aiservice.openrouter.request.Tool;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ToolsService {

    public List<Tool> getTools(){
        Map<String, Object> nameProperty = new HashMap<>();
        nameProperty.put("type", "string");
        nameProperty.put("description", "Nome da pessoa");

        Map<String, Object> properties = new HashMap<>();
        properties.put("name", nameProperty);

        Parameters parameters = new Parameters();
        parameters.setType("object");
        parameters.setProperties(properties);
        parameters.setRequired(List.of("name"));

        FunctionDefinition function = new FunctionDefinition();
        function.setName("say_hello");
        function.setDescription("Retorna uma saudação");
        function.setParameters(parameters);

        Tool tool = new Tool();
        tool.setType("function");
        tool.setFunction(function);

        return Arrays.asList(tool);
    }
}
