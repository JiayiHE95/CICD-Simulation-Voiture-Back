package org.acme;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VoitureTest {

    private Voiture voiture;

    @BeforeEach
    void setUp() {
        voiture = new Voiture();
    }

    @Test
    void testAvancer() {
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
    void testReculer() {
        voiture.setPositionX(10);
        voiture.setPositionY(10);
        assertEquals("10,10", voiture.getPosition());
        
        voiture.reculer();
        assertEquals("5,10", voiture.getPosition());
        
        voiture.setPositionX(0);
        assertEquals("0,10", voiture.getPosition());  // La voiture ne doit pas sortir du plateau
        voiture.reculer();
        assertEquals("hors du cadre", voiture.reculer());  // Test de la limite du plateau
    }

    @Test
    void testMonter() {
        voiture.setPositionX(10);
        voiture.setPositionY(10);
        assertEquals("10,10", voiture.getPosition());
        
        voiture.monter();
        assertEquals("10,15", voiture.getPosition());
        
        voiture.setPositionY(290);
        assertEquals("10,290", voiture.getPosition());  // Test de la limite du plateau
        voiture.monter();
        assertEquals("hors du cadre", voiture.monter());  // Test de la limite du plateau
    }

    @Test
    void testDescendre() {
        voiture.setPositionX(10);
        voiture.setPositionY(10);
        assertEquals("10,10", voiture.getPosition());
        
        voiture.descendre();
        assertEquals("10,5", voiture.getPosition());
        
        voiture.setPositionY(0);
        assertEquals("10,0", voiture.getPosition());  // La voiture ne doit pas sortir du plateau
        voiture.descendre();
        assertEquals("hors du cadre", voiture.descendre());  // Test de la limite du plateau
    }

    

    @Test
    void testReinitialiserPosition() {
        voiture.setPositionX(200);
        voiture.setPositionY(200);
        assertEquals("200,200", voiture.getPosition());
        
        voiture.reinitialiserPosition();
        assertEquals("0,0", voiture.getPosition());  // Vérifie la réinitialisation de la position
    }

        

    @Test
    void testChargerCarburant() {
        voiture.setCarburant(50);
        voiture.charger();
        assertEquals(100, voiture.getCarburant());  // Vérifie la recharge complète du carburant
    }




    @Test
    void testGetPosition() {
        String position = voiture.getPosition();
        assertEquals("0,0", position);
    }

    @Test
    void testGetScore() {
        assertEquals(0, voiture.getScore());
    }

    @Test
    void testSetScore() {
        voiture.setScore(10);
        assertEquals(10, voiture.getScore());
    }
    @Test
    void testCarburant() {
        voiture.setCarburant(10);
        assertEquals(10, voiture.getCarburant());
    }

    @Test
    void testPositionX() {
        assertEquals(0, voiture.getPositionX());
    }

    @Test
    void testPositionY() {
        assertEquals(0, voiture.getPositionY());
    }
    @Test
    void testConsommerCarburant_DecrementWhenCompteurPasIs1() {
        voiture.setCarburant(10);
        voiture.setCompteurPas(1);
        
        voiture.consommerCarburant();

        assertEquals(9, voiture.getCarburant());
        assertEquals(3, voiture.getCompteurPas());
    }

    @Test
    void testConsommerCarburant_DecrementCompteurPas() {
        voiture.setCarburant(10);
        voiture.setCompteurPas(2);
        
        voiture.consommerCarburant();

        assertEquals(10, voiture.getCarburant());
        assertEquals(1, voiture.getCompteurPas());
    }

    @Test
    void testConsommerCarburant_ResetPositionAndScoreWhenCarburantIsZero() {
        voiture.setCarburant(1);
        voiture.setPositionX(50);
        voiture.setPositionY(50);
        voiture.setScore(10);
        voiture.setCompteurPas(1);
        
        voiture.consommerCarburant();

        assertAll(
            () -> assertEquals(60, voiture.getCarburant()),
            () -> assertEquals(0, voiture.getScore()),
            () -> assertEquals(0, voiture.getPositionX()),
            () -> assertEquals(0, voiture.getPositionY()),
            () -> assertEquals(3, voiture.getCompteurPas())
        );
    }
    @Test
    void testSetCompteurPas() {
        voiture.setCompteurPas(5);
        assertEquals(5, voiture.getCompteurPas());
    }

    @Test
    void testGetCompteurPas_DefaultValue() {
        assertEquals(3, voiture.getCompteurPas());
    }
}
