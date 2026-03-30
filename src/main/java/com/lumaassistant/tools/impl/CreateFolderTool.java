package com.lumaassistant.tools.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumaassistant.tools.AbstractTool;
import com.lumaassistant.config.Config;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class CreateFolderTool extends AbstractTool {

    private final Config config;

    // Assunção: a variável de configuração usada é TOOLS_BASE_DIR (variável de ambiente ou propriedade Spring).
    // Se não definida, o fallback será ./tools_data dentro do diretório de trabalho.
    public CreateFolderTool(Config config) {
        this.config = config;
    }

    @Override
    public String getDescription() {
        return "Cria uma pasta no sistema de arquivos (limitado a um diretório base configurável)";
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

        String requestedPath = pathNode.asText();

        // Base directory from config (env property LUMA_WORKSPACE). Fallback to ./tools_data
        String baseDir = config.getVar("LUMA_WORKSPACE");
        if (baseDir == null || baseDir.isBlank()) {
            baseDir = "./target/tools_data";
        }

        Path base = Paths.get(baseDir).toAbsolutePath().normalize();
        // Ensure base exists
        try {
            Files.createDirectories(base);
        } catch (IOException e) {
            return "Erro: não foi possível garantir o diretório base: " + e.getMessage();
        }

        Path requested = Paths.get(requestedPath);
        Path resolved;
        if (requested.isAbsolute()) {
            resolved = requested.toAbsolutePath().normalize();
        } else {
            resolved = base.resolve(requested).toAbsolutePath().normalize();
        }

        // Security check: resolved must be inside base
        if (!resolved.startsWith(base)) {
            return "Erro: Caminho não permitido. Só é possível criar pastas dentro de: " + base;
        }

        // Create directories
        try {
            Files.createDirectories(resolved);

            // Extra safety: after creation, resolve real paths (symlinks) and ensure still inside base
            Path realBase = base.toRealPath();
            Path realResolved = resolved.toRealPath();
            if (!realResolved.startsWith(realBase)) {
                return "Erro: Caminho não permitido após resolução de links simbólicos.";
            }

        } catch (IOException e) {
            return "Erro ao criar pasta: " + e.getMessage();
        }

        return "Pasta criada: " + resolved;
    }
}
