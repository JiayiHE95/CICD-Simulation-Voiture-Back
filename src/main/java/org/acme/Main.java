package org.acme;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        System.out.println("Hello, Quarkus!");

        // File d'attente pour les demandes clients
        Simulateur simulateur = Simulateur.getSimulateur();

        // Démarrer le thread de simulation continue
        Thread simulationThread = new Thread(simulateur);

        WebSocketServer webSocketServer = new WebSocketServer();

        // simulationThread.start();

        Quarkus.run(args);
    }
}
