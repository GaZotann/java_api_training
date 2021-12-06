package fr.lernejo.navy_battle;

public class Launcher {
    public static void main(String[] args){
        if(args.length > 0){
            int port = Integer.parseInt(args[0]);
            try {
               ServeurHTTP serveurHTTP = new ServeurHTTP(port);
               serveurHTTP.create();
           }catch (Exception e){}
        }
        if(args.length <= 0){
            System.out.println("Arguments invalide");
        }
    }
}
