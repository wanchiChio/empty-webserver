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

        
        String data = "stuff";

        RequestHandler handler = new fourOhFourHandler();

        //assertEquals(data, );
        //InputStream is = new ;

    }
}

