package com.lumaassistant.openrouter;

import com.lumaassistant.openrouter.response.Response;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class OpenRouterClient {

    private static final String URL = "https://openrouter.ai/api/v1/chat/completions";
    //TODO: pegar como variavel de ambiente
    private static final String TOKEN = "meutoken";

    public String chamada(String texto) {

        RestTemplate restTemplate = new RestTemplate();

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(TOKEN);

        // Body (JSON)
        Map<String, Object> body = new HashMap<>();
        body.put("model", "openrouter/free");

        List<Map<String, String>> messages = new ArrayList<>();

        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", texto);

        messages.add(message);

        body.put("messages", messages);

        // Request
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        // Call
/*        ResponseEntity<String> response = restTemplate.exchange(
                URL,
                HttpMethod.POST,
                request,
                String.class
        );*/

        Response response = restTemplate.postForObject(
                URL,
                request,
                Response.class
        );

        // Resultado
        return response.getChoices().get(0).getMessage().getContent();
    }
}
