package com.lumaassistant.util;

import com.lumaassistant.tools.impl.createfile.CreateFileRequest;
import org.junit.Assert;
import org.junit.Test;

public class JsonMapperHelperTest {

    @Test
    public void mapperTest() {
        String path = "workspace/Aluno.java";
        String content = "public class Aluno {\n private String nome;\n}";

        String inputJson = String.format("{\"path\": \"%s\", \"content\": \"%s\" }",path, content);
        CreateFileRequest request = JsonMapperHelper.map(inputJson, CreateFileRequest.class);

        Assert.assertEquals("workspace/Aluno.java", request.getPath());
        Assert.assertEquals("public class Aluno {\n    private String nome;\n    private", request.getContent());

    }

}