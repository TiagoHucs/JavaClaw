package com.lumaassistant.services;

import com.lumaassistant.command.CommandExecutor;
import com.lumaassistant.openrouter.IOpenRouterClient;
import com.lumaassistant.openrouter.request.RequestMessage;
import com.lumaassistant.openrouter.response.Response;
import com.lumaassistant.openrouter.response.ToolCall;
import com.lumaassistant.tools.ToolExecutor;
import com.lumaassistant.util.LumaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LumaService {
    private static final Logger log = LoggerFactory.getLogger(LumaService.class);

    @Autowired
    private CommandExecutor commandExecutor;

    @Autowired
    private IOpenRouterClient modelClient;

    @Autowired
    private ToolExecutor toolExecutor;

    public String processarChat(String userInput) throws Exception {

        List<RequestMessage> contexto = new ArrayList<>();
        contexto.add(new RequestMessage("system", LumaUtils.readFile("IDENTITY.md")));
        contexto.add(new RequestMessage("user",userInput));

        Response response = modelClient.call(contexto);

        while (response.haveToolCalls()) {

            for (ToolCall tc : response.getToolCalls()) {

                contexto.add(new RequestMessage("assistant",tc.toString()));

                String result = toolExecutor.execute(
                        tc.getFunction().getName(),
                        tc.getFunction().getArguments()
                );
                log.info("tool {} response: {} "+ tc.getFunction().getName() + result );
                contexto.add(new RequestMessage("tool",result));

                response = modelClient.call(contexto);
            }
        }

        return response.getChoices().get(0).getMessage().getContent();
    }

}
