package com.lumaassistant.openrouter;

import com.lumaassistant.config.Config;
import com.lumaassistant.openrouter.request.ChatRequest;
import com.lumaassistant.openrouter.request.RequestMessage;
import com.lumaassistant.openrouter.response.Response;
import com.lumaassistant.tools.ToolDefinition;
import com.lumaassistant.util.LumaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OpenRouterClient implements IOpenRouterClient {
    private static final Logger log = LoggerFactory.getLogger(OpenRouterClient.class);

    private final String USER = "user";
    private final String SYSTEM = "system";
    private static final String URL = "https://openrouter.ai/api/v1/chat/completions";

    @Autowired
    private Config config;


    public Response call(List<RequestMessage> contexto, List<ToolDefinition> toolDefinitions) {

        RestTemplate restTemplate = new RestTemplate();

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(config.getVar("TOKEN"));

        //Request
        ChatRequest chatRequest = new ChatRequest();

        chatRequest.setModel("openrouter/free");
        chatRequest.setMessages(contexto);
        chatRequest.setTools(toolDefinitions);

        // configs
        //chatRequest.setToolChoice("auto");
        //chatRequest.setTemperature(0.3);

        log.info("REQUEST: {}", LumaUtils.stringlify(chatRequest));

        HttpEntity<ChatRequest> request = new HttpEntity<>(chatRequest, headers);
        // Call
        Response response = restTemplate.postForObject(
                URL,
                request,
                Response.class
        );

        log.info("RESPONSE: {}", LumaUtils.stringlify(chatRequest));

        // Resultado
        return response;
    }

}
