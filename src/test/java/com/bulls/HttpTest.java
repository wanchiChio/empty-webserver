package com.bulls;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HttpTest {

    @Test
    public void itStartsAServer() throws Exception {
        Server server = new Server();
        boolean status = server.start();
        assertEquals(true, status);
    }
}
