package io.github.Forjeon.Ona;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.file.Files;
import java.nio.file.Path;

public class PromptTemplate {
    private final String prefix;
    private final String suffix;

    public PromptTemplate(Path templateFilepath) {
        try {
            String content = Files.readString(templateFilepath);
            JsonObject json = JsonParser.parseString(content).getAsJsonObject();
            this.prefix = json.get("prefix").getAsString();
            this.suffix = json.get("suffix").getAsString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read template file", e);
        }
    }

    public PromptTemplate(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String makePrompt(String input) {
        return this.prefix + input + this.suffix;
    }
}
