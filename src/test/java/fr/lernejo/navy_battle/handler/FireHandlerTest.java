package fr.lernejo.navy_battle.handler;

import fr.lernejo.navy_battle.ServeurClient;
import fr.lernejo.navy_battle.ServeurHTTP;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class FireHandlerTest {
    private final FireHandler fireHandler = new FireHandler();
    @Test
    void handle_false() throws Exception, InterruptedException{
        ServeurHTTP serveurHTTP = new ServeurHTTP(9090);
        serveurHTTP.create();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:9090/api/game/fire"))
            .headers("Accept", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("POST"))
            .build();
        CompletableFuture<HttpResponse<String>> completableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        completableFuture.thenApplyAsync(HttpResponse::headers);
        HttpResponse<String> response = completableFuture.join();
        Assertions.assertEquals(response.statusCode(), 404);
    }
    @Test
    void handle_true() throws Exception, InterruptedException{
        ServeurHTTP serveurHTTP = new ServeurHTTP(9091);
        serveurHTTP.create();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:9091/api/game/fire"))
            .headers("Accept", "application/json")
            .GET()
            .build();
        CompletableFuture<HttpResponse<String>> completableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        completableFuture.thenApplyAsync(HttpResponse::headers);
        HttpResponse<String> response = completableFuture.join();
        Assertions.assertEquals(response.body(), "{\"consequence\":\"sunk\",\"shipLeft\":\"true\"}");
        Assertions.assertEquals(response.statusCode(), 202);
    }

    @Test
    void CreatebodyTest(){
        Assertions.assertEquals(fireHandler.createbody(), "{\"consequence\":\"sunk\",\"shipLeft\":\"true\"}");
    }

}
