package com.lumaassistant;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class CommandExecutor {

    private static final String DIRETORIO = "C:/workspace/seu-projeto";

    public String executar(String jsonResposta) throws Exception {

        // ⚠️ simplificado (ideal: usar Jackson)
        if (jsonResposta.contains("git status")) {

            ProcessBuilder pb = new ProcessBuilder("git", "status");
            pb.directory(new File(DIRETORIO));

            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            return reader.lines().collect(Collectors.joining("\n"));
        }

        return "Comando não reconhecido.";
    }
}
