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
        Simulateur simulateur = new Simulateur();


        // Démarrer le thread de simulation continue
        Thread simulationThread = new Thread(simulateur);

        simulationThread.start();
        Quarkus.run(args);
    }
}
