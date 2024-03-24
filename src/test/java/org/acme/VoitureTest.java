package org.acme;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VoitureTest {

    private Voiture voiture;
    private Plateau plateau;

    @BeforeEach
    public void setUp() {
        voiture = new Voiture();
        plateau = new Plateau();
    }

    @Test
    public void testAvancer() {
        voiture.setPositionX(10);
        voiture.setPositionY(10);
        assertEquals("10,10", voiture.getPosition());
        
        voiture.avancer();
        assertEquals("15,10", voiture.getPosition());
        
        voiture.setPositionX(490);
        voiture.avancer();
        assertEquals("490,10", voiture.getPosition());  // Test de la limite du plateau
    }

    @Test
    public void testReculer() {
        voiture.setPositionX(10);
        voiture.setPositionY(10);
        assertEquals("10,10", voiture.getPosition());
        
        voiture.reculer();
        assertEquals("5,10", voiture.getPosition());
        
        voiture.setPositionX(0);
        assertEquals("0,10", voiture.getPosition());  // La voiture ne doit pas sortir du plateau
        voiture.reculer();
        assertEquals("nope hors du cadre", voiture.reculer());  // Test de la limite du plateau
    }

    @Test
    public void testMonter() {
        voiture.setPositionX(10);
        voiture.setPositionY(10);
        assertEquals("10,10", voiture.getPosition());
        
        voiture.monter();
        assertEquals("10,15", voiture.getPosition());
        
        voiture.setPositionY(290);
        assertEquals("10,290", voiture.getPosition());  // Test de la limite du plateau
        voiture.monter();
        assertEquals("nope hors du cadre", voiture.monter());  // Test de la limite du plateau
    }

    @Test
    public void testDescendre() {
        voiture.setPositionX(10);
        voiture.setPositionY(10);
        assertEquals("10,10", voiture.getPosition());
        
        voiture.descendre();
        assertEquals("10,5", voiture.getPosition());
        
        voiture.setPositionY(0);
        assertEquals("10,0", voiture.getPosition());  // La voiture ne doit pas sortir du plateau
        voiture.descendre();
        assertEquals("nope hors du cadre", voiture.descendre());  // Test de la limite du plateau
    }

    

    @Test
    public void testReinitialiserPosition() {
        voiture.setPositionX(200);
        voiture.setPositionY(200);
        assertEquals("200,200", voiture.getPosition());
        
        voiture.reinitialiserPosition();
        assertEquals("0,0", voiture.getPosition());  // Vérifie la réinitialisation de la position
    }

        

    @Test
    public void testChargerCarburant() {
        voiture.setCarburant(50);
        voiture.charger();
        assertEquals(100, voiture.getCarburant());  // Vérifie la recharge complète du carburant
    }




    @Test
    public void testGetPosition() {
        String position = voiture.getPosition();
        assertEquals("0,0", position);
    }

    @Test
    public void testGetScore() {
        assertEquals(0, voiture.getScore());
    }

    @Test
    public void testSetScore() {
        voiture.setScore(10);
        assertEquals(10, voiture.getScore());
    }
    @Test
    public void testCarburant() {
        voiture.setCarburant(10);
        assertEquals(10, voiture.getCarburant());
    }

    @Test
    public void testPositionX() {
        assertEquals(0, voiture.getPositionX());
    }

    @Test
    public void testPositionY() {
        assertEquals(0, voiture.getPositionY());
    }
}
