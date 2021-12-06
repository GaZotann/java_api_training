package fr.lernejo.navy_battle.handler;

import fr.lernejo.navy_battle.util.ReadAllJson;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import java.util.UUID;

import java.io.*;
import java.nio.charset.Charset;
import java.security.SecureRandom;


public class StartHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String body = "";
        int code = 400;
        if(!"POST".equals(exchange.getRequestMethod())){code = 404;}
        else if(checkJson(exchange.getRequestBody())){
            body = createbody(exchange);
            code = 202;
        }
        exchange.sendResponseHeaders(code, body.length());
        try(OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(body.getBytes());
        }
    }

    private boolean checkJson(InputStream inputStream){
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            JSONObject json = new JSONObject(new ReadAllJson().readAll(read));
            if(json != null){
                if(json.has("id") && json.has("url") && json.has("message")){return true;}
            }
        }catch(Exception e){}
        return false;
    }

    private String createbody(HttpExchange exchange){
        JSONObject object = new JSONObject();
        object.put("id", UUID.randomUUID().toString());
        object.put("url", "http://localhost:" + exchange.getHttpContext().getServer().getAddress().getPort());
        object.put("message", "Start game");
        return object.toString();
    }
}
