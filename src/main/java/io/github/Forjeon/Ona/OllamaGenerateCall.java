package io.github.Forjeon.Ona;

import com.google.gson.Gson;

public class OllamaGenerateCall implements IOllamaCall {
    private final boolean stream = false;
    private final boolean think;
    private final String format = "json";
    private final String model;
    private final String prompt;

    public OllamaGenerateCall(String model, String prompt, boolean think) {
        this.model = model;
        this.prompt = prompt;
        this.think = think;
    }

    @Override
    public String getJsonData() {
        return new Gson().toJson(this);
    }
}
