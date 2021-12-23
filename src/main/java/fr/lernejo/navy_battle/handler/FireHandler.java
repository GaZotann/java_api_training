package fr.lernejo.navy_battle.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;

public class FireHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String body = "";
        int code = 400;
        if(!exchange.getRequestMethod().equals("GET")){code = 404;}
        else{
            code = 202;
            body = createbody();
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
