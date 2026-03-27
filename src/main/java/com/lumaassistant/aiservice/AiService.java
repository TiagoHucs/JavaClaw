package com.lumaassistant.aiservice;

import com.lumaassistant.aiservice.openrouter.OpenRouterClient;
import com.lumaassistant.command.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AiService {

    @Autowired
    private CommandExecutor commandExecutor;

    @Autowired
    private OpenRouterClient openRouterClient;

    private final String API_KEY = "SUA_API_KEY";

    public String processarChat(String userInput) throws Exception {
        return openRouterClient.chamada(userInput);
    }

}
