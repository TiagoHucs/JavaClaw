package com.lumaassistant.tools;

import com.lumaassistant.openrouter.request.FunctionDefinition;
import com.lumaassistant.openrouter.request.Parameters;
import com.lumaassistant.openrouter.request.Tool;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToolsFactory {

    public static List<Tool> getTools(){
        return Arrays.asList(
                createHelloTool(),
                createCreateFolderTool()
        );
    }

    private static Tool createHelloTool(){
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
        return tool;
    }

    private static Tool createGoodByTool(){
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
        function.setName("say_good_bye");
        function.setDescription("Se despede de uma pessoa");
        function.setParameters(parameters);

        Tool tool = new Tool();
        tool.setType("function");
        tool.setFunction(function);
        return tool;
    }

    private static Tool createCreateFolderTool(){
        Map<String, Object> nameProperty = new HashMap<>();
        nameProperty.put("type", "string");
        nameProperty.put("description", "Nome da pasta");

        Map<String, Object> properties = new HashMap<>();
        properties.put("folderName", nameProperty);

        Parameters parameters = new Parameters();
        parameters.setType("object");
        parameters.setProperties(properties);
        parameters.setRequired(List.of("folderName"));

        FunctionDefinition function = new FunctionDefinition();
        function.setName("create_folder");
        function.setDescription("Cria uma pasta no diretorio de trabalho");
        function.setParameters(parameters);

        Tool tool = new Tool();
        tool.setType("function");
        tool.setFunction(function);
        return tool;
    }
}
