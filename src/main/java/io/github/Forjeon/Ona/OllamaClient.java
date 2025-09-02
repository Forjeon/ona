package io.github.Forjeon.Ona;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

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
        String body = response.body();
        int nameIndex = body.indexOf("\"name\":\"");
        if (nameIndex != -1) {
            int start = nameIndex + 8;
            int end = body.indexOf("\"", start);
            String name = body.substring(start, end);
            System.out.println("Extracted name: " + name);
        }
    }
}
