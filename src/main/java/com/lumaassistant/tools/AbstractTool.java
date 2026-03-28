package com.lumaassistant.tools;

public abstract class AbstractTool implements ITool {

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getInputSchema() {
        return "{}";
    }
}
