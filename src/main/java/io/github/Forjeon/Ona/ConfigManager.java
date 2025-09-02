package io.github.Forjeon.Ona;

import java.nio.file.Path;

import main.java.io.github.Forjeon.Ona.PromptTemplate;

public class ConfigManager {
    private final URI ollamaEndpoint;

    public final Path inFilepath;  // Input file to read for prompt
    public final PromptTemplate

    public ConfigManager(String[] args) {
        // TODO: Parse args to set fields
    }

    public Path getInFilepath() {
        return this.inFilepath;
    }
    public boolean readFromStdin() {
        return this.inFilepath == null;
    }
}
