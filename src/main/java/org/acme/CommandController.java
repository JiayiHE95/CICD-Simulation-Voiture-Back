package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

//@Path("/api/commands")
@ApplicationScoped
public class CommandController {
    /*
     * @POST
     * 
     * @Path("/avancer")
     * public Response avancer() {
     * Simulateur.getClientRequests().offer("avancer");
     * return Simulateur.processRequest("avancer");
     * }
     * 
     * @POST
     * 
     * @Path("/reculer")
     * public Response reculer() {
     * Simulateur.getClientRequests().offer("reculer");
     * return Simulateur.processRequest("reculer");
     * }
     * 
     * @POST
     * 
     * @Path("/monter")
     * public Response monter() {
     * Simulateur.getClientRequests().offer("monter");
     * return Simulateur.processRequest("monter");
     * }
     * 
     * @POST
     * 
     * @Path("/descendre")
     * public Response descendre() {
     * Simulateur.getClientRequests().offer("descendre");
     * return Simulateur.processRequest("descendre");
     * }
     */
}
