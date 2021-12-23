package fr.lernejo.navy_battle.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class CallHandler implements HttpHandler {
    private final String body = "OK";
    private final int code = 200;
    @Override
    public void handle(HttpExchange exchange) throws IOException{
        exchange.sendResponseHeaders(code, body.length());
        try (OutputStream os = exchange.getResponseBody()){
            os.write(body.getBytes());
        }
    }
}
