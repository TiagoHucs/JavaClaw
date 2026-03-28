package com.lumaassistant.command;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class CommandExecutor {

    private static final String DIRETORIO = "./target";

    public String executar(String... command) throws Exception {

        ProcessBuilder pb = new ProcessBuilder(command);
        pb.directory(new File(DIRETORIO));

        Process process = pb.start();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
        );

        return reader.lines().collect(Collectors.joining("\n"));
    }

}
