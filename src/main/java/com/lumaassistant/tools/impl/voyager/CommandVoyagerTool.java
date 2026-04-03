package com.lumaassistant.tools.impl.voyager;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumaassistant.config.Config;
import com.lumaassistant.tools.AbstractTool;
import com.lumaassistant.util.LumaUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class CommandVoyagerTool extends AbstractTool {

    private final Config config;

    public CommandVoyagerTool(Config config) {
        this.config = config;
    }

    @Override
    public String getDescription() {
        return LumaUtils.readFile("tools/voyager/DESCRIPTION.md");
    }

    @Override
    public String getInputSchema() {
        return LumaUtils.readFile("tools/voyager/voyager-tool-schema.json");
    }

    @Override
    public String execute(String inputJson) throws Exception {

        VoyagerSchema voyagerSchema = LumaUtils.map(inputJson, VoyagerSchema.class);

        String command = voyagerSchema.command;

        if(command == null || command.isEmpty()) {
            return "Field: command,  cannot be null or empty";
        } if (command.equals("turn_on") || command.equals("turn_off")) {
            return "Command acept!";
        }  else {
            return "Command not recognized!";
        }
    }
}
