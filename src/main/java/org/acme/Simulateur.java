package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



@ApplicationScoped
public class Simulateur implements Runnable{


    private final Voiture voiture;

    public static BlockingQueue<String> getClientRequests() {
        return clientRequests;
    }

    private final static BlockingQueue<String> clientRequests = new LinkedBlockingQueue<>();


    @Inject
    public Simulateur() {
        this.voiture = new Voiture("toto");
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Traitement des demandes clients
                System.out.println(getClientRequests());
                String request = clientRequests.poll();
                if (request != null) {
                    System.out.println("Simulateur received request: " + request);
                    processRequest(request);
                }
                System.out.println(voiture.getPosition());
                // Délai pour la simulation continue
                Thread.sleep(1000); // ajustez selon vos besoins
            }
        } catch (InterruptedException e) {
            // Le thread a été interrompu (par exemple, à la fermeture de l'application)
        }
    }

    void processRequest(String request) {
        // Logique pour traiter la demande du client
        System.out.println("Processing client request: " + request);
        switch (request) {
            case "avancer":
                voiture.avancer();
                System.out.println("avancer");
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
            // Ajoutez d'autres cas en fonction de vos besoins
            default:
                System.out.println("Commande invalide : " + request);
        }
    }

}
