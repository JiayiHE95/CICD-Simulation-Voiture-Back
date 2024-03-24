package org.acme;

import java.util.logging.Logger;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Simulateur {

    private static Voiture voiture;
    private static Plateau plateau;
    private static Boule boule;
    private static Logger logger = Logger.getLogger(Simulateur.class.getName());
    private static final Simulateur simulateur = new Simulateur();

    public static Simulateur getSimulateur() {
        return simulateur;
    }

    private Simulateur() {
        voiture = new Voiture();
        plateau = new Plateau();
        boule = new Boule();
    }

    public static String getPosition() {
        boule.mouvement();
        if (boule.positionContientBoule(voiture.getPositionX(), voiture.getPositionY())) {
            voiture.setScore(voiture.getScore() + 1);
        }
        return voiture.getPosition() + boule.getPosition() + "," + voiture.getCarburant() + "," + voiture.getScore();
    }

    public static Voiture getVoiture() {
        return voiture;
    }

    public static String processRequest(String request) {
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
                logger.info("Commande invalide : " + request);
        }

        if (plateau.positionContientMaison(voiture.getPositionX(), voiture.getPositionY())) {

            voiture.setScore(0);
            voiture.reinitialiserPosition();
        } else if (plateau.positionContientStation(voiture.getPositionX(), voiture.getPositionY())) {

            voiture.charger();
        }

        return getPosition();

    }

    public Boule getBoule() {
        return boule;
    }

}
