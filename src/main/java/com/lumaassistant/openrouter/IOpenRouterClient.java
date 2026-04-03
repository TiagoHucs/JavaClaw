package com.lumaassistant.openrouter;

import com.lumaassistant.openrouter.request.RequestMessage;
import com.lumaassistant.openrouter.response.Response;
import com.lumaassistant.tools.ToolDefinition;

import java.util.List;

public interface IOpenRouterClient {

     Response call(List<RequestMessage> contexto, List<ToolDefinition> tools);

}
