package fr.lernejo.navy_battle.handler;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import java.util.UUID;
import java.io.*;
import java.nio.charset.Charset;


public class StartHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String body = "";
        int code = 400;
        //if(!"POST".equals(exchange.getRequestMethod())){code = 404;}
        if(!exchange.getRequestMethod().equals("POST")){code = 404;}
        else if(checkJson(exchange.getRequestBody())){
            body = createbody(exchange);
            code = 202;
        }
        exchange.sendResponseHeaders(code, body.length());
        try(OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(body.getBytes());
        }
        System.out.println(body + code);
    }

    private boolean checkJson(InputStream inputStream) {
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            StringBuilder futurJson = new StringBuilder();
            String value;
            while ((value = read.readLine()) != null){futurJson.append(value);}
            JSONObject json = new JSONObject(futurJson.toString());
            if(json != null)
                if(json.getString("id") != null && json.getString("url") != null && json.getString("message") != null){return true;}
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
