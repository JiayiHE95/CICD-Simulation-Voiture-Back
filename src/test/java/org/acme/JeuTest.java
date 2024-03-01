package org.acme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JeuTest {
    Jeu jeu1 = new Jeu(null);
    Jeu jeu2 = new Jeu("Test");

    @Test
    void title() {
        assertEquals("#",jeu1.Title(-1));
        assertEquals("Test",jeu2.Title(-1));
        assertEquals("Test",jeu2.Title(0));
        assertEquals("#Test",jeu2.Title(1));
        assertEquals("##Test",jeu2.Title(2));
    }


}