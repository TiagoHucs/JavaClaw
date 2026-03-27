package com.lumaassistant.aiservice;

import com.lumaassistant.aiservice.openrouter.OpenRouterClient;
import com.lumaassistant.aiservice.openrouter.response.Message;
import com.lumaassistant.aiservice.openrouter.response.Response;
import com.lumaassistant.aiservice.openrouter.response.ToolCall;
import com.lumaassistant.command.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    @Autowired
    private CommandExecutor commandExecutor;

    @Autowired
    private OpenRouterClient openRouterClient;

    public String processarChat(String userInput) throws Exception {
        Response response = openRouterClient.chamada(userInput);

        //verificar se tem acoes:
        Message message = response.getChoices().get(0).getMessage();

        if (message.getToolCalls() != null) {
            System.out.println("🔥 TOOL CHAMADA!");

            for (ToolCall tc : message.getToolCalls()) {
                System.out.println("Nome: " + tc.getFunction().getName());
                System.out.println("Args: " + tc.getFunction().getArguments());
            }
        } else {
            System.out.println("❌ Nenhuma tool chamada");
        }

        return response.getChoices().get(0).getMessage().getContent();
    }

}
