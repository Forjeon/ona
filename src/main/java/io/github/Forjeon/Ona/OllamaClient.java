package io.github.Forjeon.Ona;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

import com.google.gson.Gson;

public class OllamaClient {
    private final URI endpoint;

    public OllamaClient(URI endpoint) {
        this.endpoint = endpoint;
    }

    public String respond(IOllamaCall call) {
        // Build HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(this.endpoint)
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // Send request
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Print response
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: " + response.body());

        // Manually parse JSON (very basic, not robust)
        OllamaResponse modelResponse = new Gson().fromJson(response.body(), OllamaResponse.class);
        return modelResponse.response;
    }
}
