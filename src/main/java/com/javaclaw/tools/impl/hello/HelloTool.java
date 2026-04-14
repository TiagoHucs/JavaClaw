package com.javaclaw.tools.impl.hello;

import com.javaclaw.config.Config;
import com.javaclaw.tools.AbstractTool;
import com.javaclaw.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloTool extends AbstractTool {
    private static final Logger log = LoggerFactory.getLogger(HelloTool.class);

    private final Config config;

    public HelloTool(Config config) {
        this.config = config;
    }

    @Override
    public String getDescription() {
        return Utils.readFile("tools/hello/DESCRIPTION.md");
    }

    @Override
    public String getInputSchema() {
        return Utils.readFile("tools/hello/hello-schema.json");
    }

    @Override
    public String execute(String inputJson) throws Exception {

        HelloSchema helloSchema = Utils.map(inputJson, HelloSchema.class);

        String name = helloSchema.name;

        if(name == null || name.isEmpty()) {
            return "Field: name,  cannot be null or empty";
        } else {
            log.error("HelloTool receive: " + name);
            return "I sent a hello for "+name+"!";
        }
    }
}
