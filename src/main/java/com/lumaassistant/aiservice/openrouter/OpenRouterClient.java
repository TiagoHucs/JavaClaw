package com.lumaassistant.aiservice.openrouter;

import com.lumaassistant.aiservice.openrouter.request.*;
import com.lumaassistant.aiservice.openrouter.response.Response;
import com.lumaassistant.config.Config;
import com.lumaassistant.filereader.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class OpenRouterClient {

    private final String USER = "user";
    private final String SYSTEM = "system";
    private static final String URL = "https://openrouter.ai/api/v1/chat/completions";

    @Autowired
    private Config config;

    public String chamada(String texto) {

        RestTemplate restTemplate = new RestTemplate();

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(config.getVar("TOKEN"));

        //Request
        ChatRequest chatRequest = new ChatRequest();

        List<Message> messages = new ArrayList<>();

        Message messageSys = new Message();
        messageSys.setRole(SYSTEM);
        messageSys.setContent(FileReader.readFile("IDENTITY.md"));
        messages.add(messageSys);

        Message messageUsr = new Message();
        messageUsr.setRole(USER);
        messageUsr.setContent(texto);
        messages.add(messageUsr);

        chatRequest.setMessages(messages);

        // tool (terminal)
/*
        Property commandProp = new Property();
        commandProp.setType("string");
        commandProp.setDescription("Comando a ser executado");

        Parameters params = new Parameters();
        params.setProperties(Map.of("command", commandProp));
        params.setRequired(List.of("command"));

        FunctionDefinition function = new FunctionDefinition();
        function.setName("run_terminal");
        function.setDescription("Executa comandos no terminal");
        function.setParameters(params);

        Tool tool = new Tool();
        tool.setType("function");
        tool.setFunction(function);

        chatRequest.setTools(List.of(tool));


        // configs
        chatRequest.setToolChoice("auto");
        chatRequest.setTemperature(0.3);
*/

        // Request
        HttpEntity<ChatRequest> request = new HttpEntity<>(chatRequest, headers);
        // Call
        Response response = restTemplate.postForObject(
                URL,
                request,
                Response.class
        );

        // Resultado
        return response.getChoices().get(0).getMessage().getContent();
    }
}
