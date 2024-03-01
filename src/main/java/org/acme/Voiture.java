package org.acme;



public class Voiture {
    private String nom;
    private int positionX;
    private int positionY;

    public Voiture(String nom) {
        this.nom = nom;
        this.positionX = 0;
        this.positionY = 0;
    }

    public void avancer() {
        positionX++;
        int[] positions = getPosition();
        System.out.println(nom + " avance. ("+ positions[0] + "," + positions[1] + ")");
    }

    public void reculer() {
        positionX--;
        int[] positions = getPosition();
        System.out.println(nom + " recule. ("+ positions[0] + "," + positions[1] + ")");
    }
    // Ajoutez ces méthodes à votre classe Voiture
    public void monter() {
        positionY++;
        int[] positions = getPosition();
        System.out.println(nom + " monte. ("+ positions[0] + "," + positions[1] + ")");
    }

    public void descendre() {
        positionY--;
        int[] positions = getPosition();
        System.out.println(nom + " descend. ("+ positions[0] + "," + positions[1] + ")");
    }
    public int[] getPosition() {
        int[] positions = {positionX, positionY};
        return positions;
    }



}


