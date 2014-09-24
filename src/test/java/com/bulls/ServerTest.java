package com.bulls;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ServerTest {

    public Server server;

    @Before
    public void setUp() throws IOException {
        server = new Server(5000);
    }

    @After
    public void cleanUp() throws IOException {
        server.stop();
    }

    @Test
    public void itCreatesASocketInstance() throws Exception {
        assertEquals(5000, server.getPort());
        assertNotNull(server.getServerSocket());
    }

    @Test
    public void testServerStart() throws Exception {
        server.start();
        server.stop();
        assertEquals(true, server.getServerSocket().isClosed());
    }

    @Test
    public void testGenerateOutputClosesSocket() throws Exception {
        Mocket mocket = new Mocket();
        server.generateOutput(mocket.getSocket());

        assertTrue(mocket.isClosed());
    }

}
