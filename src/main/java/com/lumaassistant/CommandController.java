package com.lumaassistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent")
public class CommandController {

    @Autowired
    private AiService aiService;

    @Autowired
    private CommandExecutor executor;

    @PostMapping
    public String executar(@RequestBody String input) throws Exception {

        String resposta = aiService.processar(input);

        return executor.executar(resposta);
    }
}