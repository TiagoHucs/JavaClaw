package com.lumaassistant.tools.impl.createfile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateFileRequest {

    private String path;
    private String contentBase64;

    public String getPath() {
        return path;
    }

    @JsonProperty("content_base64")
    public String getContentBase64() {
        return contentBase64;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setContentBase64(String contentBase64) {
        this.contentBase64 = contentBase64;
    }
}
