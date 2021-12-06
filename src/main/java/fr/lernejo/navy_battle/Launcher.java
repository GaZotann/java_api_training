package fr.lernejo.navy_battle;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args)throws IOException {
        if(args.length > 0){
            int port = Integer.parseInt(args[0]);
            try {
               ServeurHTTP serveurHTTP = new ServeurHTTP(port);
               serveurHTTP.create();
           }catch (Exception e){}
        }
        if (args.length <= 0){
            throw new IllegalArgumentException("Il manque des arguments");
        }
    }
}
