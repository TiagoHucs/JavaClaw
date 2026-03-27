package com.lumaassistant.aiservice.openrouter;

import com.lumaassistant.aiservice.openrouter.request.*;
import com.lumaassistant.aiservice.openrouter.response.Response;
import com.lumaassistant.config.Config;
import com.lumaassistant.filereader.FileReader;
import com.lumaassistant.tools.ToolsService;
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

    @Autowired
    private ToolsService toolsService;

    public Response chamada(String texto) {

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
        chatRequest.setTools(toolsService.getTools());

        // configs
        //chatRequest.setToolChoice("auto");
        //chatRequest.setTemperature(0.3);

        // Request
        HttpEntity<ChatRequest> request = new HttpEntity<>(chatRequest, headers);
        // Call
        Response response = restTemplate.postForObject(
                URL,
                request,
                Response.class
        );

        // Resultado
        return response;
    }
}
