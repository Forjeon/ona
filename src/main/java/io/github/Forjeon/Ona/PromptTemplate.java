package io.github.Forjeon.Ona;

public class PromptTemplate {
    private final String prefix;
    private final String suffix;

    public PromptTemplate(Path templateFilepath) {
        // TODO: Load template from file
    }

    public PromptTemplate(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String makePrompt(String input) {
        return this.prefix + input + this.suffix;
    }
}
