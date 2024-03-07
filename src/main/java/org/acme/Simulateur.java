package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class Simulateur implements Runnable {

    private static Voiture voiture;

    public static BlockingQueue<String> getClientRequests() {
        return clientRequests;
    }

    private final static BlockingQueue<String> clientRequests = new LinkedBlockingQueue<>();

    private static Simulateur simulateur;

    public static Simulateur getSimulateur() {
        if (simulateur == null) {
            simulateur = new Simulateur();
            voiture = new Voiture("toto");
        }
        return simulateur;
    }

    public static String getPosition() {
        return voiture.getPosition();
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Traitement des demandes clients
                String request = clientRequests.poll();
                if (request != null) {
                    System.out.println("Simulateur received request: " + request);
                } else {
                    System.out.println("Simulateur received request: null");
                    Thread.sleep(1000);
                }
                System.out.println(voiture.getPosition());
            }
        } catch (InterruptedException e) {
            // Le thread a été interrompu (par exemple, à la fermeture de l'application)
        }
    }

    public static String processRequest(String request) {
        // Logique pour traiter la demande du client
        System.out.println("Processing client request: " + request);
        String position = null;
        switch (request) {
            case "avancer":
                position = voiture.avancer();
                break;
            case "reculer":
                position = voiture.reculer();
                break;
            case "monter":
                position = voiture.monter();
                break;
            case "descendre":
                position = voiture.descendre();
                break;
            default:
                System.out.println("Commande invalide : " + request);
        }
        return position;

    }

}
