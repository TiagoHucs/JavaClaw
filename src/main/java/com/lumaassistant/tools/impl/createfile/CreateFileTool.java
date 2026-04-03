package com.lumaassistant.tools.impl.createfile;

import com.lumaassistant.config.Config;
import com.lumaassistant.tools.AbstractTool;
import com.lumaassistant.util.LumaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Component
public class CreateFileTool extends AbstractTool {

    @Autowired
    private Config config;

    @Override
    public String getDescription() {
        return "Cria um arquivo no caminho informado. Deve ser passado o caminho completo do arquivo, incluindo nome e extensão. " +
                "O conteúdo deve ser enviado em base64 no campo 'content_base64'.";
    }

    @Override
    public String getInputSchema() {
        return """
        {
          "type": "object",
          "properties": {
            "path": { "type": "string" },
            "content_base64": { "type": "string" }
          },
          "required": ["path", "content_base64"]
        }
        """;
    }

    @Override
    public String execute(String inputJson) throws Exception {

        CreateFileRequest request = LumaUtils.map(inputJson, CreateFileRequest.class);

        Path basePath = Paths.get(config.getVar("LUMA_WORKSPACE")).toAbsolutePath();
        Path caminho = basePath.resolve(request.getPath()).normalize();

        if (!caminho.startsWith(basePath)) {
            return "Erro: acesso fora do workspace não permitido";
        }

        if (request.getPath() == null || request.getPath().isBlank()) {
            return "Erro: parâmetro 'path' é obrigatório";
        }

        if (request.getContentBase64() == null || request.getContentBase64().isBlank()) {
            return "Erro: parâmetro 'content_base64' é obrigatório";
        }

        try {

            // evita erro se for arquivo direto na raiz
            if (caminho.getParent() != null) {
                Files.createDirectories(caminho.getParent());
            }

            // 🔥 decode base64
            byte[] decodedBytes = Base64.getDecoder().decode(request.getContentBase64());

            Files.write(caminho, decodedBytes);

        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao criar arquivo: " + e.getMessage();
        } catch (IllegalArgumentException e) {
            return "Erro: content_base64 inválido";
        }

        return "Arquivo criado com sucesso em: " + request.getPath();
    }
}
