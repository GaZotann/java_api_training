package fr.lernejo.navy_battle.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

import java.io.IOException;

public class FireHandler implements HttpHandler {
    private String body = "";
    private int code = 400;
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if(!exchange.getRequestMethod().equals("GET")){this.code = 404;}
        else{
            this.code = 202;
            this.body = createbody();
        }
        exchange.sendResponseHeaders(code, body.length());
        try(OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(body.getBytes());
        }
        System.out.println(body + code);
    }

    public String createbody(){
        JSONObject object = new JSONObject();
        object.put("consequence", "sunk");
        object.put("shipLeft", "true");
        return object.toString();
    }
}
