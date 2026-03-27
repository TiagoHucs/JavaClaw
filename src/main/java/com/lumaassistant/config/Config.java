package com.lumaassistant.config;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Config {

    private final Environment env;

    public Config(Environment env) {
        this.env = env;
    }

    public String getVar(String var) {
       return env.getProperty(var);
    }
}
