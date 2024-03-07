package org.acme;

public class Voiture {
    private final String nom;
    private int positionX;
    private int positionY;

    public Voiture(String name) {
        this.nom = name;
        this.positionX = 0;
        this.positionY = 0;
    }

    public String avancer() {
        positionX++;
        System.out.println(nom + " avance." + getPosition());
        return getPosition();

    }

    public String reculer() {
        if (positionX > 0) {
            positionX--;
        }
        System.out.println(nom + " recule" + getPosition());
        return getPosition();
    }

    // Ajoutez ces méthodes à votre classe Voiture
    public String monter() {
        positionY++;
        System.out.println(nom + " monte. " + getPosition());
        return getPosition();
    }

    public String descendre() {
        if (positionY > 0) {
            positionY--;
        }
        System.out.println(nom + " descend." + getPosition());
        return getPosition();
    }

    public String getPosition() {
        int[] positions = { positionX, positionY };
        return "(" + positions[0] + "," + positions[1] + ")";
    }

}
