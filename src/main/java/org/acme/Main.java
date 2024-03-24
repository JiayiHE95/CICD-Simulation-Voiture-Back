package org.acme;


import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Simulateur simulateur = Simulateur.getSimulateur();
        WebSocketServer webSocketServer = new WebSocketServer();

        Quarkus.run(args);
    }
}
