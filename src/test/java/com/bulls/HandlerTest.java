package com.bulls;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by anton.perez on 9/22/14.
 */
public class HandlerTest {

    @Test
    public void handler404test() throws Exception {
        RequestHandler handler = new fourOhFourHandler();
        String output = handler.genDefaultResponse();

        assertEquals("HTTP/1.0 404 Not Found", output);

    }

    @Test
    public void processInput() throws Exception {

        
        String data = "GET /pub/WWW/TheProject.html HTTP/1.1";

        RequestHandler handler = new fourOhFourHandler();
        handler.parseInput(data);
        assertEquals("/pub/WWW/TheProject.html", handler.getEndPoint());



        //assertEquals(data, );
        //InputStream is = new ;

    }
}

