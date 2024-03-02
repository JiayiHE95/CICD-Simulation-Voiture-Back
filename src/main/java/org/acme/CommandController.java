package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.concurrent.BlockingQueue;

@Path("/api/commands")
@ApplicationScoped
public class CommandController {



    @POST
    @Path("/avancer")
    public void avancer() {
        Simulateur.getClientRequests().offer("avancer");
        System.out.println(Simulateur.getClientRequests());
    }

    @POST
    @Path("/reculer")
    public void reculer() {
        Simulateur.getClientRequests().offer("reculer");
    }

    @POST
    @Path("/monter")
    public void monter() {
        Simulateur.getClientRequests().offer("monter");
    }

    @POST
    @Path("/descendre")
    public void descendre() {
        Simulateur.getClientRequests().offer("descendre");
    }
}
