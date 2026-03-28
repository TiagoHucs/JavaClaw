package com.lumaassistant.openrouter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumaassistant.openrouter.request.RequestMessage;
import com.lumaassistant.openrouter.response.Response;
import com.lumaassistant.config.Config;
import com.lumaassistant.filereader.FileReader;
import com.lumaassistant.openrouter.request.ChatRequest;
import com.lumaassistant.tools.ToolDefinitionFactory;
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

    @Autowired
    private ToolDefinitionFactory toolDefinitionFactory;

    public Response chamada(List<RequestMessage> contexto) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(config.getVar("TOKEN"));

        //Request
        ChatRequest chatRequest = new ChatRequest();

        chatRequest.setMessages(contexto);
        chatRequest.setTools(toolDefinitionFactory.getToolDefinitions());

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

        log.info("RESPONSE: {}", mapper.writeValueAsString(response));

        // Resultado
        return response;
    }

    public Response devolucao(String texto) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(config.getVar("TOKEN"));

        //Request
        ChatRequest chatRequest = new ChatRequest();

        List<RequestMessage> messages = new ArrayList<>();

        RequestMessage messageSys = new RequestMessage();
        messageSys.setRole(SYSTEM);
        messageSys.setContent(FileReader.readFile("IDENTITY.md"));
        messages.add(messageSys);

        RequestMessage messageUsr = new RequestMessage();
        messageUsr.setRole(USER);
        messageUsr.setContent(texto);
        messages.add(messageUsr);

        chatRequest.setMessages(messages);
        chatRequest.setTools(toolDefinitionFactory.getToolDefinitions());

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
