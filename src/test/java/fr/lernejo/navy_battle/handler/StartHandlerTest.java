package fr.lernejo.navy_battle.handler;

import fr.lernejo.navy_battle.ServeurHTTP;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class StartHandlerTest {
    private final StartHandler startHandler = new StartHandler();
    @Test
    void handle_false() throws Exception, InterruptedException {
        ServeurHTTP serveurHTTP = new ServeurHTTP(9092);
        serveurHTTP.create();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:9092/api/game/start"))
            .headers("Accept", "application/json")
            .GET()
            .build();
        CompletableFuture<HttpResponse<String>> completableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        completableFuture.thenApplyAsync(HttpResponse::headers);
        HttpResponse<String> response = completableFuture.join();
        Assertions.assertEquals(response.statusCode(), 404);
    }
    @Test
    void handle_true_1() throws Exception, InterruptedException {
        ServeurHTTP serveurHTTP = new ServeurHTTP(9093);
        serveurHTTP.create();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:9093/api/game/start"))
            .headers("Accept", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("POST"))
            .build();
        CompletableFuture<HttpResponse<String>> completableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        completableFuture.thenApplyAsync(HttpResponse::headers);
        HttpResponse<String> response = completableFuture.join();
        Assertions.assertEquals(response.statusCode(), 400);
    }
    @Test
    void handle_true_2() throws Exception, InterruptedException {
        ServeurHTTP serveurHTTP = new ServeurHTTP(9094);
        serveurHTTP.create();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:9094/api/game/start"))
            .headers("Accept", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + 9094 + "\", \"message\":\"hello\"}"))
            .build();
        CompletableFuture<HttpResponse<String>> completableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        completableFuture.thenApplyAsync(HttpResponse::headers);
        HttpResponse<String> response = completableFuture.join();
        Assertions.assertEquals(response.statusCode(), 202);
    }
}
