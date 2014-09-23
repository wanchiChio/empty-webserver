package com.bulls;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ServerTest {
    public Server server;


    @Before
    public void setUp() throws IOException {
        server = new Server(5000);
    }
    @Test
    public void itStartsAServer() throws Exception {
        //server.start();
        //assertEquals("Started", server.getStatus());
    }

    @Test
    public void itReturnsA404() throws Exception {
        //server.start();
        server.setResponseCode("404");
        assertEquals(404, server.getResponseCode());
    }

    @Test
    public void itCreatesASocketInstance() throws Exception {
        assertEquals(5000, server.getPort());
        assertNotNull(server.getSocket());
    }

    @Test
    public void itReturnsABody() throws Exception {
        server.setBody("Hello, world!");
        assertEquals("Hello, world!", server.getBody());
    }

    @Test
    public void testServerStart() throws Exception
    {
       server.start();
       server.stop();
        assertEquals(true, server.getSocket().isClosed());
    }

//    @Test
//    public void clientGet404() throws Exception
//    {
//        server.start();
//
//        try {
//            URL url = new URL("http://localhost:5000/foo");
//            URLConnection conn = url.openConnection();
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(
//                            conn.getInputStream())
//            );
//            String inputLine;
//            System.out.println("Haha");
//            server.stop();
//
//      //      while ((inputLine = in.readLine()) != null)
//      //          System.out.println(inputLine);
//      //      assertEquals("404", inputLine);
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        server.stop();
//
//
//    }

    @After
    public void cleanUp() throws IOException {
        server.stop();

    }


}
