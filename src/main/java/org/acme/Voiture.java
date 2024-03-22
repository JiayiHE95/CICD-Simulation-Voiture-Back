package org.acme;

import java.util.ArrayList;
import java.util.List;

public class Voiture {
    private final String nom;
    private int positionX = 0;
    private int positionY = 0;
    private int carburant = 60;
    private int compteurPas = 3;

    List<int[]> maisonPositions = new ArrayList<>();

    public Voiture(String name) {
        this.nom = name;
        maisonPositions.add(new int[] { 400, 90 });
        maisonPositions.add(new int[] { 100, 100 });
        maisonPositions.add(new int[] { 450, 150 });
        maisonPositions.add(new int[] { 200, 190 });
        maisonPositions.add(new int[] { 200, 100 });
        maisonPositions.add(new int[] { 450, 250 });
    }

    public String avancer() {
        if ((positionX + 5) > 490) {
            return "nope hors du cadre";
        }
        positionX = positionX + 5;
        consommerCarburant();
        return getPosition();
    }

    public String reculer() {
        if ((positionX - 5) < 0) {
            return "nope hors du cadre";
        }
        positionX = positionX - 5;
        consommerCarburant();
        return getPosition();
    }

    public String monter() {
        if ((positionY + 5) > 290) {
            return "nope hors du cadre";
        }
        positionY = positionY + 5;
        consommerCarburant();
        return getPosition();
    }

    public String descendre() {
        if ((positionY - 5) < 0) {
            return "nope hors du cadre";
        }
        positionY = positionY - 5;
        consommerCarburant();
        return getPosition();
    }

    public void reinitialiserPosition() {
        positionX = 0;
        positionY = 0;
    }

    public void consommerCarburant() {
        System.out.println("debut carburant: " + carburant + " compteurPas: " + compteurPas);

        if (compteurPas == 1) {
            carburant = carburant - 1;
            compteurPas = 3;
            if (carburant == 0) {
                reinitialiserPosition();
                this.carburant = 60;
            }
        } else {
            compteurPas = compteurPas - 1;
        }

        System.out.println("fin carburant: " + carburant + " compteurPas: " + compteurPas);
    }

    

    public String getPosition() {
        int[] positions = { positionX, positionY };
        return positions[0] + "," + positions[1];
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void charger() {
        if (this.carburant >= 40) {
            this.carburant = 60;
        } else {
            this.carburant += 20;
        }
    }

}
