package com.bulls;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HttpTest {

    @Test
    public void itStartsAServer() throws Exception {
        Server server = new Server();
        server.start();
        assertEquals("Started", server.getStatus());
    }

    @Test
    public void itReturnsA404() throws Exception {
        Server server = new Server();
        server.start();
        server.setResponseCode("404");
        assertEquals(404, server.getResponseCode());
    }

    @Test
    public void itCreatesASocketInstance() throws Exception {
        Server server = new Server(5000);
        assertEquals(5000, server.getPort());
        assertNotNull(server.getSocket());
    }

    @Test
    public void itReturnsABody() throws Exception {
        Server server = new Server();
        server.start();
        server.setBody("Hello, world!");
        assertEquals("Hello, world!", server.getBody());
    }
}
