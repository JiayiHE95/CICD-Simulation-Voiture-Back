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
    private static Plateau plateau;

    public static BlockingQueue<String> getClientRequests() {
        return clientRequests;
    }

    private final static BlockingQueue<String> clientRequests = new LinkedBlockingQueue<>();

    private static Simulateur simulateur;

    public static Simulateur getSimulateur() {
        if (simulateur == null) {
            simulateur = new Simulateur();
            voiture = new Voiture("toto");
            plateau = new Plateau();
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

        System.out.println("Processing client request: " + request);
        getClientRequests().offer(request);

        switch (request) {
            case "avancer":
                voiture.avancer();
                break;
            case "reculer":
                voiture.reculer();
                break;
            case "monter":
                voiture.monter();
                break;
            case "descendre":
                voiture.descendre();
                break;
            default:
                System.out.println("Commande invalide : " + request);
        }

        System.out.println("verifie position");
        if (plateau.positionContientMaison(voiture.getPositionX(), voiture.getPositionY())) {
            System.out.println("crash maison");
            voiture.reinitialiserPosition();
        } else if (plateau.positionContientStation(voiture.getPositionX(), voiture.getPositionY())) {
            System.out.println("recharge");
            voiture.charger();
        }

        return getPosition();

    }

}
