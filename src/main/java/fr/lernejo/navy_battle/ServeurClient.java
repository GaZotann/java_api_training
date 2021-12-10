package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class ServeurClient {

    private final int port;
    private final HttpClient httpClient;

    public ServeurClient(int p_port){
        this.port = p_port;
        this.httpClient = HttpClient.newHttpClient();
    }

    public HttpRequest NewClientHttp(String adversaryUrl){
        return HttpRequest.newBuilder()
            .uri(URI.create(adversaryUrl + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"hello\"}"))
            .build();
    }

    public void send(String adversaryUrl) throws IOException, InterruptedException {

        HttpRequest requestpost = NewClientHttp(adversaryUrl);
        HttpResponse<String> response = this.httpClient.send(requestpost, HttpResponse.BodyHandlers.ofString());
    }
}
