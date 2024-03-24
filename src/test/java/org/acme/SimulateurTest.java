package org.acme;


import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimulateurTest {

    private Simulateur simulateur;
    private Voiture voiture;
    private Boule boule;

    @BeforeEach
    void setUp() {
        simulateur = Simulateur.getSimulateur();
        voiture = simulateur.getVoiture();
        boule = simulateur.getBoule();

        voiture.setPositionX(0);
        voiture.setPositionY(0);
        
    }

    @Test
    public void testGetBoule() {
        assertNotNull(boule); 
    }

    @Test
    public void testGetBouleInstance() {
        assertSame(boule, simulateur.getBoule());  
    }

    @Test
    void testGetPosition() {
        String position = Simulateur.getPosition();
        assertNotNull(position);
    }

    @Test
    public void testGetPositionUpdatesScoreWhenBallContainsCar() {
        boule.setPositionX(voiture.getPositionX()-10);
        boule.setPositionY(voiture.getPositionY());

        int initialScore = voiture.getScore();

        simulateur.getPosition();

        assertEquals(initialScore + 1, voiture.getScore());
    }

    @Test
    void testProcessRequestAvancer() {
        Simulateur.processRequest("avancer");
        assertEquals("5,0", voiture.getPosition()); 
    }
    

    @Test
    void testProcessRequestReculerBlocage() {
        Simulateur.processRequest("reculer");
        assertEquals("0,0", voiture.getPosition()); 
    }

    @Test
    void testProcessRequestReculer() {
        voiture.setPositionX(10);
        Simulateur.processRequest("reculer");
        assertEquals("5,0", voiture.getPosition()); 
    }

    @Test
    void testProcessRequestMonter() {
        Simulateur.processRequest("monter");
        assertEquals("0,5", voiture.getPosition()); 
    }

    @Test
    void testProcessRequestDescendreBlocage() {
        Simulateur.processRequest("descendre");
        assertEquals("0,0", voiture.getPosition()); 
    }

    @Test
    void testProcessRequestDescendre() {
        
        voiture.setPositionY(10);
        Simulateur.processRequest("descendre");
        assertEquals("0,5", voiture.getPosition()); 
    }

    @Test
    void testProcessRequestInvalidCommand() {
        Simulateur.processRequest("invalid");
        assertEquals("0,0", voiture.getPosition()); 
    }

    @Test
    void testProcessRequestCrashMaison() {
        // Set initial position inside a maison
        voiture.setPositionX(400);
        voiture.setPositionY(90);
        
        Simulateur.processRequest("avancer"); // This should trigger a crash with a maison
        assertEquals("0,0", voiture.getPosition()); // Assuming initial position is (0,0) and carburant is 100 and score is reset to 0
    }

    @Test
    void testProcessRequestRecharge() {
        // Set initial position inside a station
        voiture.setPositionX(200);
        voiture.setPositionY(250);
        
        Simulateur.processRequest("avancer"); // This should trigger a recharge
        assertEquals(100, voiture.getCarburant()); // Assuming initial position is (0,0) and carburant is 100 and score is 0
    }
}
