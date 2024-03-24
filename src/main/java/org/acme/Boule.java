package org.acme;

public class Boule {
    private int positionX = 0;
    private int positionY = 0;
    public static final int LARGEUR_PLATEAU = 490;

    public String getPosition() {
        return "," + positionX + "," + positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void mouvement() {
        if (positionX < LARGEUR_PLATEAU) {
            positionX = positionX + 10;

        } else {
            positionX = 0;
            if (positionY < 290) {
                positionY = positionY + 20;
            } else {
                positionY = 0;
            }
        }

    }

    public boolean positionContientBoule(int x, int y) {
        if (x >= (positionX - 5) && x <= (positionX + 5) && y >= (positionY - 5) && y <= (positionY + 5)) {
            return true;
        }

        return false;
    }

    public void setPositionX(int i) {
        positionX = i;
    }

    public void setPositionY(int i) {
        positionY = i;
    }
}
