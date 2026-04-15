package com.javaclaw.tools.impl.sendmessage;

import com.javaclaw.config.Config;
import com.javaclaw.tools.AbstractTool;
import com.javaclaw.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SendMessageTool extends AbstractTool {
    private static final Logger log = LoggerFactory.getLogger(SendMessageTool.class);

    private final Config config;

    public SendMessageTool(Config config) {
        this.config = config;
    }

    @Override
    public String getDescription() {
        return Utils.readFile("tools/sendmessage/DESCRIPTION.md");
    }

    @Override
    public String getInputSchema() {
        return Utils.readFile("tools/sendmessage/send-message-schema.json");
    }

    @Override
    public String execute(String inputJson) throws Exception {

        SendMessageSchema sendMessageSchema = Utils.map(inputJson, SendMessageSchema.class);

        String name = sendMessageSchema.name;
        String message = sendMessageSchema.message;

        if(name == null || name.isEmpty()) {
            return "Field: name,  cannot be null or empty";
        } else if(message == null || message.isEmpty()) {
            return "Field: message,  cannot be null or empty";
        } else {
            log.error("SendMessageTool receive a message: \"" + message + "\" for " + name);
            return "I sent your message for "+name+"!";
        }
    }
}
