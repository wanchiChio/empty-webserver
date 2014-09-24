package com.bulls;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by anton.perez on 9/22/14.
 */
public class HandlerTest {

    @Test
    public void processInput() throws Exception {
        String data = "GET /pub/WWW/TheProject.html HTTP/1.1";
        RequestHandler handler = new NotFoundHandler();
        handler.parseInput(data);
        assertEquals("/pub/WWW/TheProject.html", handler.getEndPoint());
    }

}

