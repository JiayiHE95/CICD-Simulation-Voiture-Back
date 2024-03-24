package org.acme;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class PlateauTest {

    Plateau plateau;

    @BeforeEach
    void setUp() {
        plateau = new Plateau();
    }

    @Test
    void testPositionContientMaison() {
        // Test avec une position qui contient une maison
        assertTrue(plateau.positionContientMaison(405, 95));
        
        // Test avec une position qui ne contient pas de maison
        assertFalse(plateau.positionContientMaison(300, 300));
    }

    @Test
    void testPositionContientStation() {
        // Test avec une position qui contient une station
        assertTrue(plateau.positionContientStation(205, 255));
        
        // Test avec une position qui ne contient pas de station
        assertFalse(plateau.positionContientStation(300, 300));
    }
    
 

    @Test
    void testPositionContientMaisonInvalide() {
        // Test avec une position en dehors de toutes les maisons
        assertFalse(plateau.positionContientMaison(0, 0));
    }

    @Test
    void testPositionContientStationInvalide() {
        // Test avec une position en dehors de toutes les stations
        assertFalse(plateau.positionContientStation(0, 0));
    }
}