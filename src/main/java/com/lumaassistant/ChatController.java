package com.lumaassistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {

    @Autowired
    private AiService aiService;

    @PostMapping
    public String chat(@RequestBody String message) throws Exception {
        String[] command = message.split(" ");
        return aiService.processarMock(command);
    }
}
