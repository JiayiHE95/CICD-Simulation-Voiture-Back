package org.acme;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.*;
import java.util.Timer;
import java.util.TimerTask;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.websocket.Session;

@ServerEndpoint("/websocket/{username}")
@ApplicationScoped
public class WebSocketServer {
    private Timer timer;
    private Logger logger = Logger.getLogger(Compilateur.class.getName());
    Map<String, Session> sessions = new ConcurrentHashMap<>();

    public WebSocketServer() {

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                broadcast(Simulateur.getPosition());
            }
        }, 0, 1000);
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        broadcast(username + " joined");
        sessions.put(username, session);
    }

    @OnClose
    public void onClose(Session session, @PathParam("username") String username) {
        sessions.remove(username);
        broadcast(username + " left");
    }

    @OnError
    public void onError(Session session, @PathParam("username") String username, Throwable throwable) {
        sessions.remove(username);
        broadcast(username + " left on error: " + throwable);
    }

    @OnMessage
    public void onMessage(String message, @PathParam("username") String username) {
        Simulateur.processRequest(message);
        broadcast(Simulateur.getPosition());

    }

    private void broadcast(String message) {
        sessions.values().forEach(s -> s.getAsyncRemote().sendObject(message, result -> {
            if (result.getException() != null) {
                logger.info("Unable to send message: " + result.getException());
            }
        }));
    }

}