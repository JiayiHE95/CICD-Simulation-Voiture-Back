package org.acme;

import java.util.ArrayList;
import java.util.List;

public class Voiture {
    private final String nom;
    private int positionX;
    private int positionY;

    List<int[]> maisonPositions = new ArrayList<>();


    public Voiture(String name) {
        this.nom = name;
        this.positionX = 0;
        this.positionY = 0;
        maisonPositions.add(new int[]{400, 90});
        maisonPositions.add(new int[]{500, 100});
        maisonPositions.add(new int[]{450, 150});
        maisonPositions.add(new int[]{800, 190});
        maisonPositions.add(new int[]{500, 300});
        maisonPositions.add(new int[]{450, 350});
    }

    public String avancer() {
        if((positionX + 5 ) >490){
            return "nope hors du cadre";
        }
        positionX = positionX + 5;
        return getPosition();
    }

    public String reculer() {
        if((positionX - 5 ) < 0){
            return "nope hors du cadre";
        }
        positionX = positionX - 5;
        return getPosition();
    }

    public String monter() {
        if((positionY + 5 ) > 290){
            return "nope hors du cadre";
        }
        positionY = positionY + 5;
        return getPosition();
    }


    public String descendre() {
        if((positionY - 5 ) < 0){
            return "nope hors du cadre";
        }
        positionY = positionY - 5;
        return getPosition();
    }

    public void reinitialiserPosition() {
        positionX = 0;
        positionY = 0;
    }


    public boolean positionContientMaison() {
        for (int[] maison : maisonPositions) {
            int maisonX = maison[0];
            int maisonY = maison[1];
            int largeurMaison = 4;
            int hauteurMaison = 4;

            if (positionX >= maisonX && positionX <= (maisonX + largeurMaison)
                    && positionY >= maisonY && positionY <= (maisonY + hauteurMaison)) {
                return true;
            }
        }
        return false;
    }


    public String getPosition() {
        int[] positions = { positionX, positionY };
        return positions[0] + "," + positions[1];
    }

}
