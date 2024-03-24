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
        assertTrue(plateau.positionContientMaison(400, 90));
        assertTrue(plateau.positionContientMaison(100, 100));
        assertTrue(plateau.positionContientMaison(450, 150));
        assertTrue(plateau.positionContientMaison(200, 190));
        assertTrue(plateau.positionContientMaison(200, 100));
        assertTrue(plateau.positionContientMaison(450, 250));
        assertFalse(plateau.positionContientMaison(405, 95));
        assertFalse(plateau.positionContientMaison(105, 105));
    }

    @Test
    void testPositionContientStation() {
        assertTrue(plateau.positionContientStation(205, 255));
        assertTrue(plateau.positionContientStation(200, 250));
        assertTrue(plateau.positionContientStation(210, 260));
        assertFalse(plateau.positionContientStation(300, 300));
        assertTrue(plateau.positionContientStation(205, 255));
        assertTrue(plateau.positionContientStation(105, 205));
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