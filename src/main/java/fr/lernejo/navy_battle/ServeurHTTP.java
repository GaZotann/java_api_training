package fr.lernejo.navy_battle;

import com.sun.jdi.connect.Connector;
import com.sun.net.httpserver.HttpServer;
import fr.lernejo.navy_battle.handler.CallHandler;
import fr.lernejo.navy_battle.handler.StartHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ServeurHTTP {
    private final int port;
    public ServeurHTTP(int port) {
        this.port = port;
    }

    public void create() throws IOException {
        System.out.println("Server Init");
        InetSocketAddress newSocket = new InetSocketAddress(this.port);
        HttpServer httpServer = HttpServer.create(newSocket, 0);
        httpServer.setExecutor(Executors.newFixedThreadPool(1));
        httpServer.createContext("/ping", new CallHandler());
        httpServer.createContext("/api/game/start", new StartHandler());
        httpServer.start();
    }
}
