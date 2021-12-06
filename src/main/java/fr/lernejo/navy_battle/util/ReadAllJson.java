package fr.lernejo.navy_battle.util;

import java.io.IOException;
import java.io.Reader;

public class ReadAllJson {
    public String readAll(Reader read) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = read.read()) != -1){
            sb.append((char) cp);
        }
        return read.toString();
    }
}
