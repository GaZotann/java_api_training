package fr.lernejo.navy_battle.handler;

import fr.lernejo.navy_battle.ServeurClient;
import fr.lernejo.navy_battle.ServeurHTTP;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FireHandlerTest {
    private final FireHandler fireHandler = new FireHandler();
    @Test
    void HandleTest(){
        try {
            ServeurClient clientServeur = new ServeurClient(9876);
            ServeurHTTP serveur = new ServeurHTTP(9875);
            serveur.create();
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest requestPUT = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9097/api/game/fire"))
                .header("Accept", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString("test"))
                .build();
            int statusCodePUT = client.sendAsync(requestPUT, HttpResponse.BodyHandlers.ofString()).thenApplyAsync(HttpResponse::statusCode).join();
            Assertions.assertEquals(statusCodePUT,202);


        }catch (Exception e){}

    }
}
