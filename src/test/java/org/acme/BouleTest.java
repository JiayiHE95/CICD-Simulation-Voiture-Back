package org.acme;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BouleTest {

    private Boule boule;

    @BeforeEach
    public void setUp() {
        boule = new Boule();
    }

    @Test
    public void testGetPosition() {
        String position = boule.getPosition();
        assertEquals(",0,0", position);
    }

    @Test
    public void testGetPositionX() {
        assertEquals(0, boule.getPositionX());
    }

    @Test
    public void testGetPositionY() {
        assertEquals(0, boule.getPositionY());
    }

    @Test
    public void testMouvement_HorizontalMove() {
        boule.mouvement();
        assertEquals(10, boule.getPositionX());
        assertEquals(0, boule.getPositionY());

        boule.mouvement();
        assertEquals(20, boule.getPositionX());
        assertEquals(0, boule.getPositionY());

        boule.setPositionX(490);  
        boule.mouvement();
        assertEquals(0, boule.getPositionX());  
        assertEquals(20, boule.getPositionY());
    }

    @Test
    public void testMouvement_VerticalMove() {
        boule.setPositionX(boule.largeurPlateau);  
        boule.mouvement();
        assertEquals(0, boule.getPositionX());
        assertEquals(20, boule.getPositionY());

        boule.mouvement();
        assertEquals(10, boule.getPositionX());
        assertEquals(20, boule.getPositionY());

        boule.setPositionX(boule.largeurPlateau);
        boule.setPositionY(290);  
        boule.mouvement();
        assertEquals(0, boule.getPositionX());
        assertEquals(0, boule.getPositionY());
        
    }

    
    @Test
    public void testPositionContientBoule() {
        assertTrue(boule.positionContientBoule(0, 0));
        assertFalse(boule.positionContientBoule(10, 10));
        
        boule.mouvement();
        assertTrue(boule.positionContientBoule(10, 0));
        assertFalse(boule.positionContientBoule(20, 0));
        
        boule.mouvement();
        assertTrue(boule.positionContientBoule(20, 0));
        assertFalse(boule.positionContientBoule(30, 0));
    }
}
