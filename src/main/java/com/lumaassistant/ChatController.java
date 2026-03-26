package com.lumaassistant;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {

    @PostMapping
    public String chat(@RequestBody String message) {
        return "Você disse: " + message;
    }
}
