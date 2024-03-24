package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Simulateur  {

    private static Voiture voiture;
    private static Plateau plateau;
    private static Boule boule;

    private static Simulateur simulateur;

    public static Simulateur getSimulateur() {
        if (simulateur == null) {
            simulateur = new Simulateur();
            voiture = new Voiture();
            plateau = new Plateau();
            boule = new Boule();
        }
        return simulateur;
    }

    public static String getPosition() {
        boule.mouvement();
        if (boule.positionContientBoule(voiture.getPositionX(), voiture.getPositionY())){
            voiture.setScore(voiture.getScore() + 1);
        }
        return voiture.getPosition() + boule.getPosition() + ","+ voiture.getCarburant() + ","+ voiture.getScore();
    }

    public static Voiture getVoiture(){
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
                System.out.println("Commande invalide : " + request);
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
