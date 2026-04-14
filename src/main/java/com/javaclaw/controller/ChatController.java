package com.javaclaw.controller;

import com.javaclaw.services.JavaClawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {

    @Autowired
    private JavaClawService javaClawService;

    @PostMapping
    public String chat(@RequestBody String message) throws Exception {
        return javaClawService.processarChat(message);

    }

}
