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

    public void avancer() {
        positionX++;
        System.out.println(nom + " avance." + getPosition());
    }

    public void reculer() {
        positionX--;
        System.out.println(nom + " recule" + getPosition());
    }
    // Ajoutez ces méthodes à votre classe Voiture
    public void monter() {
        positionY++;
        System.out.println(nom + " monte. " + getPosition());
    }

    public void descendre() {
        positionY--;
        System.out.println(nom + " descend." + getPosition());
    }
    public String getPosition() {
        int[] positions = {positionX, positionY};
        return "(" + positions[0] + "," + positions[1] + ")";
    }



}


