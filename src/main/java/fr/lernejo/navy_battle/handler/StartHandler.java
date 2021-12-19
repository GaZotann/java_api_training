package fr.lernejo.navy_battle.handler;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.jetbrains.annotations.VisibleForTesting;
import org.json.JSONObject;
import java.util.UUID;
import java.io.*;
import java.nio.charset.Charset;


public class StartHandler implements HttpHandler {
    private String body = "";
    private int code = 400;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if(!exchange.getRequestMethod().equals("POST")){this.code = 404;}
        else if(checkJson(exchange.getRequestBody())){
            this.body = createbody(exchange);
            this.code = 202;
        }
        exchange.sendResponseHeaders(this.code, this.body.length());
        try(OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(this.body.getBytes());
        }
        System.out.println(this.body + this.code);
    }

    public boolean checkJson(InputStream inputStream) {
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            StringBuilder futurJson = new StringBuilder();
            String value;
            while ((value = read.readLine()) != null){futurJson.append(value);}
            JSONObject json = new JSONObject(futurJson.toString());
            return true;
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
