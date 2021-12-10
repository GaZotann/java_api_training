package fr.lernejo.navy_battle.handler;

import fr.lernejo.navy_battle.ServeurHTTP;
import org.junit.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.Assertions;


public class CallHandlerTest {
    private final CallHandler callHandler = new CallHandler();
    @Test
    void testCallHandler1(){
        try{
            ServeurHTTP testServeur = new ServeurHTTP(9876);
            testServeur.create();
            HttpClient newclient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9876/ping"))
                .header("Content-Type", "text/plain; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("start"))
                .build();
            CompletableFuture<HttpResponse<String>> completableFuture = newclient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> response = completableFuture.join();
            Assertions.assertEquals(200,response.statusCode());
            Assertions.assertEquals("OK",response.body() );
        }catch (Exception e){}

    }
}
