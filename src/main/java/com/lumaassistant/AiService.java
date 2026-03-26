package com.lumaassistant;

import com.lumaassistant.openrouter.OpenRouterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class AiService {

    @Autowired
    private CommandExecutor commandExecutor;

    @Autowired
    private OpenRouterClient openRouterClient;

    private final String API_KEY = "SUA_API_KEY";

    public String processar(String userInput) throws Exception {

        String soul = Files.readString(Path.of("soul.md"));
        String identity = Files.readString(Path.of("identity.md"));
        String rules = Files.readString(Path.of("rules.md"));

        String prompt = soul + "\n" + identity + "\n" + rules +
                "\nUsuário: " + userInput;

        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

/*        String body = """
        {
          "model": "gpt-4o-mini",
          "messages": [
            {"role": "user", "content": "%s"}
          ]
        }
        """.formatted(prompt.replace("\"", "\\\""));*/

        HttpEntity<String> request = new HttpEntity<>("body", headers);

        ResponseEntity<String> response = rest.postForEntity(
                "https://api.openai.com/v1/chat/completions",
                request,
                String.class
        );

        return response.getBody();
    }

    public String processarChat(String userInput) throws Exception {
        return openRouterClient.chamada(userInput);
    }

    public String processarMock(String... userInput) throws Exception {
       return commandExecutor.executar(userInput);
    }
}
