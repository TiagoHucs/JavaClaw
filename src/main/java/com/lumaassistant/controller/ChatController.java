package com.lumaassistant.controller;

import com.lumaassistant.services.LumaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {

    @Autowired
    private LumaService lumaService;

    @PostMapping
    public String chat(@RequestBody String message) throws Exception {
        return lumaService.processarChat(message);

    }

}
