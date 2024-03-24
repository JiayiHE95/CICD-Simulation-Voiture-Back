package org.acme;

import java.util.ArrayList;
import java.util.List;

public class Voiture {
    private int positionX = 0;
    private int positionY = 0;
    private int carburant = 100;
    private int compteurPas = 3;
    private int score = 0;


    List<int[]> maisonPositions = new ArrayList<>();

    public Voiture() {
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
        if (compteurPas == 1) {
            carburant = carburant - 1;
            compteurPas = 3;
            if (carburant == 0) {
                reinitialiserPosition();
                this.carburant = 60;
                setScore(0);
            }
        } else {
            compteurPas = compteurPas - 1;
        }

    }

    

    public String getPosition() {
        int[] positions = { positionX, positionY };
        return positions[0] + "," + positions[1];
    }

    public int getPositionX() {
        return positionX;
    }
    public int getCarburant() {
        return carburant;
    }

    public int getPositionY() {
        return positionY;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public void charger() {
        carburant = 100;
    }

    public void setPositionX(int i) {
       positionX = i;
    }

    public void setPositionY(int i) {
        positionY = i;
    }
    public void setCarburant(int i){
        carburant = i;
    }
}
