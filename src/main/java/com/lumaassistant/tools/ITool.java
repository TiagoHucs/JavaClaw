package com.lumaassistant.tools;

public interface ITool {

    String getName();

    String getDescription();

    String getInputSchema(); // JSON Schema (string mesmo)

    String execute(String inputJson) throws Exception;
}
