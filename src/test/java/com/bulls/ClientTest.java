package com.bulls;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by anton.perez on 9/22/14.
 */
public class ClientTest {

    @Test
    public void createClient() throws Exception {
        Client client = new Client();
        assertNotNull(client);
    }

    @Test
    public void createSocketHostAndPort() throws Exception {
        Client client = new Client("localhost", 5000);
        assertEquals("localhost", client.getHost());
        assertEquals(5000, client.getPort());
    }

}
