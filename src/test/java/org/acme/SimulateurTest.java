package org.acme;


import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimulateurTest {

    private Simulateur simulateur;
    private Voiture voiture;

    @BeforeEach
    public void setUp() {
        simulateur = Simulateur.getSimulateur();
        voiture = simulateur.getVoiture();

        voiture.setPositionX(0);
        voiture.setPositionY(0);
        
    }

    @Test
    public void testGetPosition() {
        String position = Simulateur.getPosition();
        assertNotNull(position);
    }

    @Test
    public void testProcessRequestAvancer() {
        Simulateur.processRequest("avancer");
        assertEquals("5,0", voiture.getPosition()); 
    }
    

    @Test
    public void testProcessRequestReculerBlocage() {
        Simulateur.processRequest("reculer");
        assertEquals("0,0", voiture.getPosition()); 
    }

    @Test
    public void testProcessRequestReculer() {
        voiture.setPositionX(10);
        Simulateur.processRequest("reculer");
        assertEquals("5,0", voiture.getPosition()); 
    }

    @Test
    public void testProcessRequestMonter() {
        Simulateur.processRequest("monter");
        assertEquals("0,5", voiture.getPosition()); 
    }

    @Test
    public void testProcessRequestDescendreBlocage() {
        Simulateur.processRequest("descendre");
        assertEquals("0,0", voiture.getPosition()); 
    }

    @Test
    public void testProcessRequestDescendre() {
        
        voiture.setPositionY(10);
        Simulateur.processRequest("descendre");
        assertEquals("0,5", voiture.getPosition()); 
    }

    @Test
    public void testProcessRequestInvalidCommand() {
        Simulateur.processRequest("invalid");
        assertEquals("0,0", voiture.getPosition()); 
    }

    @Test
    public void testProcessRequestCrashMaison() {
        // Set initial position inside a maison
        voiture.setPositionX(400);
        voiture.setPositionY(90);
        
        Simulateur.processRequest("avancer"); // This should trigger a crash with a maison
        assertEquals("0,0", voiture.getPosition()); // Assuming initial position is (0,0) and carburant is 100 and score is reset to 0
    }

    @Test
    public void testProcessRequestRecharge() {
        // Set initial position inside a station
        voiture.setPositionX(200);
        voiture.setPositionY(250);
        
        Simulateur.processRequest("avancer"); // This should trigger a recharge
        assertEquals(100, voiture.getCarburant()); // Assuming initial position is (0,0) and carburant is 100 and score is 0
    }
}
