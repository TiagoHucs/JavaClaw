package com.javaclaw.services;

import com.javaclaw.openrouter.IOpenRouterClient;
import com.javaclaw.openrouter.request.RequestMessage;
import com.javaclaw.openrouter.response.Response;
import com.javaclaw.openrouter.response.ToolCall;
import com.javaclaw.tools.ToolDefinition;
import com.javaclaw.tools.ToolDefinitionFactory;
import com.javaclaw.tools.ToolExecutor;
import com.javaclaw.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JavaClawService {
    private static final Logger log = LoggerFactory.getLogger(JavaClawService.class);

    @Autowired
    private ToolDefinitionFactory toolDefinitionFactory;

    @Autowired
    private IOpenRouterClient modelClient;

    @Autowired
    private ToolExecutor toolExecutor;

    public String chatProcess(String userInput) throws Exception {

        List<RequestMessage> contexto = new ArrayList<>();
        contexto.add(new RequestMessage("system", Utils.readFile("IDENTITY.md")));
        contexto.add(new RequestMessage("user",userInput));

        List<ToolDefinition> toolDefinitions = toolDefinitionFactory.getToolDefinitions();

        Response response = modelClient.call(contexto,toolDefinitions);

        while (response.haveToolCalls()) {

            for (ToolCall tc : response.getToolCalls()) {

                contexto.add(new RequestMessage("assistant",tc.toString()));

                String result = toolExecutor.execute(
                        tc.getFunction().getName(),
                        tc.getFunction().getArguments()
                );
                log.info(String.format("tool %s response: %s ", tc.getFunction().getName(), result ));
                contexto.add(new RequestMessage("tool",result));

                response = modelClient.call(contexto,toolDefinitions);
            }
        }

        return response.getChoices().get(0).getMessage().getContent();
    }

}
