package com.javaclaw.openrouter;

import com.javaclaw.openrouter.request.RequestMessage;
import com.javaclaw.openrouter.response.Response;
import com.javaclaw.tools.ToolDefinition;

import java.util.List;

public interface IOpenRouterClient {

     Response call(List<RequestMessage> contexto, List<ToolDefinition> tools);

}
