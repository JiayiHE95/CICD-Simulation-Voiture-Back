package org.acme;

public class Boule {
    private int positionX = 0;
    private int positionY = 0;
    private final int LARGEUR_PLATEAU = 490;
    private final int HAUTEUR_PLATEAU = 300;
    private boolean directionDroite = true; // Indique si la boule se déplace vers la droite
    
    public String getPosition() {
        return "," +positionX + "," + positionY;
    }
    
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
    
    public void mouvement() {
        if (directionDroite) {
            // Déplacer la boule vers la droite
            if (positionX < LARGEUR_PLATEAU) {
                positionX = positionX + 10;
            } else {
                // Changer de direction et monter d'une rangée
                directionDroite = false;
                positionX = 0;
                if (positionY < 290) {
                    positionY = positionY + 20;
                }
                else{
                    positionY = 0;
                }
            }
        } else {
            // Déplacer la boule vers la gauche
            if (positionX < LARGEUR_PLATEAU) {
                positionX = positionX + 10;
            } else {
                // Changer de direction et monter d'une rangée
                directionDroite = true;
                positionX = 0;
                if (positionY < 290) {
                    positionY = positionY + 10;
                }
                else{
                    positionY = 0;
                }
            }
        }
    }
    public boolean positionContientBoule(int x, int y) {
        if (x >= (positionX - 5) && x <= (positionX + 5) && y >= (positionY - 5) && y <= (positionY + 5)) {
            return true;
        }
        
        return false;
    }
}
