package fr.lernejo.navy_battle.util;

import fr.lernejo.navy_battle.Launcher;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.Reader;
import java.io.StringReader;

public class ReadAllJsonTest {
    private final ReadAllJson readAllJson = new ReadAllJson();
    @Test
    void testReadall() throws Exception{
        Assertions.assertEquals(readAllJson.readAll(null), null);
    }
}

