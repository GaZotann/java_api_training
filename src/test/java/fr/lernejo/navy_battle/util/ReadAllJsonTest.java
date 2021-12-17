package fr.lernejo.navy_battle.util;

import fr.lernejo.navy_battle.Launcher;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

public class ReadAllJsonTest {
    private final ReadAllJson readAllJson = new ReadAllJson();
    @Test
    void testReadall(){
        Reader reader = new StringReader("1234");
        org.assertj.core.api.Assertions.assertThatNoException().isThrownBy(() -> new ReadAllJson().readAll(reader));
    }
}

