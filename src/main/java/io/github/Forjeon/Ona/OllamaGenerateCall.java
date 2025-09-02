package io.github.Forjeon.Ona;

public class OllamaGenerateCall implements IOllamaCall {
    private final boolean think;
    private final String model;
    private final String prompt;

    public OllamaGenerateCall(String model, String prompt, boolean think) {
        this.model = model;
        this.prompt = prompt;
        this.think = think;
    }

    @Override
    public String getJsonData() {
        return "{\"stream\": false, \"format\": \"json\", \"model\":\"" + model + "\",\"prompt\":\"" + prompt + "\",\"think\":" + think + "}";
    }
}
