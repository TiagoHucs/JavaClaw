package com.javaclaw.openrouter;

import com.javaclaw.openrouter.request.RequestMessage;
import com.javaclaw.openrouter.response.Choice;
import com.javaclaw.openrouter.response.Message;
import com.javaclaw.openrouter.response.Response;
import com.javaclaw.tools.ToolDefinition;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Fake implementation used when the 'test' profile is active.
 * Provides deterministic, in-memory responses for unit/integration tests.
 */
@Service
@Primary
@Profile("test")
public class FakeOpenRouterClient implements IOpenRouterClient {

    @Override
    public Response call(List<RequestMessage> contexto, List<ToolDefinition> tools) {
        Response r = new Response();
        r.setId("fake-1");
        r.setModel("fake-model");

        Message msg = new Message();
        msg.setRole("assistant");
        // Build a simple content based on the last user message if present
        String content = "";
        if (contexto != null && !contexto.isEmpty()) {
            RequestMessage last = contexto.get(contexto.size() - 1);
            content = "(fake response) received: " + last.getContent();
        } else {
            content = "(fake response) no input";
        }
        msg.setContent(content);
        //msg.setToolCalls(Arrays.asList(new ToolCall())); // No tool calls in this fake response

        Choice choice = new Choice();
        choice.setIndex(0);
        choice.setMessage(msg);

        List<Choice> choices = new ArrayList<>();
        choices.add(choice);
        r.setChoices(choices);

        return r;
    }

}
