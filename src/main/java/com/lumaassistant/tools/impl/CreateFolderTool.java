package com.lumaassistant.tools.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumaassistant.tools.AbstractTool;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class CreateFolderTool extends AbstractTool {

    @Override
    public String getDescription() {
        return "Cria uma pasta no sistema de arquivos";
    }

    @Override
    public String getInputSchema() {
        //TODO: criar schemas/create-folder.json, vale a pena?
        return """
        {
          "type": "object",
          "properties": {
            "path": { "type": "string" }
          },
          "required": ["path"]
        }
        """;
    }

    @Override
    public String execute(String inputJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(inputJson);

        JsonNode pathNode = node.get("path");

        if (pathNode == null || pathNode.asText().isBlank()) {
            return "Erro: parâmetro 'path' é obrigatório";
        }

        String path = pathNode.asText();

        new File(path).mkdirs();

        return "Pasta criada: " + path;
    }
}
