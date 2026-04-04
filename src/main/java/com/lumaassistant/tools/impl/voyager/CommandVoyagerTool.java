package com.lumaassistant.tools.impl.voyager;

import com.lumaassistant.config.Config;
import com.lumaassistant.tools.AbstractTool;
import com.lumaassistant.util.LumaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CommandVoyagerTool extends AbstractTool {
    private static final Logger log = LoggerFactory.getLogger(CommandVoyagerTool.class);

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
            log.info("Voyager command acept: " + command);
            return "Command acept!";
        }  else {
            log.error("Voyager command not recognized: " + command);
            return "Command not recognized!";
        }
    }
}
