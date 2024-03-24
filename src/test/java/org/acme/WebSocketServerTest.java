package org.acme;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import jakarta.websocket.Session;
import org.junit.jupiter.api.Test;

class WebSocketServerTest {

    @Test
    void testOnOpen() {
        WebSocketServer server = new WebSocketServer();
        Session session = mock(Session.class);
        server.onOpen(session, "testUser");
        assertTrue(server.sessions.containsKey("testUser"));
    }

    @Test
    void testOnClose() {
        WebSocketServer server = new WebSocketServer();
        Session session = mock(Session.class);
        server.sessions.put("testUser", session);
        server.onClose(session, "testUser");
        assertTrue(!server.sessions.containsKey("testUser"));
    }

    @Test
    void testOnError() {
        WebSocketServer server = new WebSocketServer();
        Session session = mock(Session.class);
        server.sessions.put("testUser", session);
        Throwable throwable = new Throwable("test error");
        server.onError(session, "testUser", throwable);
        assertTrue(!server.sessions.containsKey("testUser"));
    }

}
