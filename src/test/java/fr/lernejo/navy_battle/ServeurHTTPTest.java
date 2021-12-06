package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import fr.lernejo.navy_battle.handler.CallHandler;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class ServeurHTTPTest {
    @Test
    void createTest2(){
        org.assertj.core.api.Assertions.assertThatNoException().isThrownBy(() -> new ServeurHTTP(9876).create());
    }
}


