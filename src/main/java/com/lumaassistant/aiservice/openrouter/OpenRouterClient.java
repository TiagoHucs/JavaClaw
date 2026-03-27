package com.lumaassistant.aiservice.openrouter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumaassistant.aiservice.openrouter.request.*;
import com.lumaassistant.aiservice.openrouter.response.Response;
import com.lumaassistant.config.Config;
import com.lumaassistant.filereader.FileReader;
import com.lumaassistant.tools.ToolsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class OpenRouterClient {
    private static final Logger log = LoggerFactory.getLogger(OpenRouterClient.class);

    private final String USER = "user";
    private final String SYSTEM = "system";
    private static final String URL = "https://openrouter.ai/api/v1/chat/completions";

    @Autowired
    private Config config;

    public Response chamada(String texto) throws JsonProcessingException {

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
        chatRequest.setTools(ToolsFactory.getTools());

        // configs
        //chatRequest.setToolChoice("auto");
        //chatRequest.setTemperature(0.3);


        ObjectMapper mapper = new ObjectMapper();
        // Request
        log.info("REQUEST: {}", mapper.writeValueAsString(chatRequest));

        HttpEntity<ChatRequest> request = new HttpEntity<>(chatRequest, headers);
        // Call
        Response response = restTemplate.postForObject(
                URL,
                request,
                Response.class
        );

        log.info("ESPONSE: {}", mapper.writeValueAsString(response));

        // Resultado
        return response;
    }
}
