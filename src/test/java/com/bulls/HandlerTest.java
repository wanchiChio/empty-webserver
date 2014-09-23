package com.bulls;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by anton.perez on 9/22/14.
 */
public class HandlerTest {

    @Test
    public void handler404test() throws Exception {
        RequestHandler handler = new FourOhFourHandler();
        String output = handler.generateDefaultResponse();

        assertEquals("HTTP/1.0 404 Not Found", output);
    }

    @Test
    public void processInput() throws Exception {
        String data = "GET /pub/WWW/TheProject.html HTTP/1.1";
        RequestHandler handler = new FourOhFourHandler();
        handler.parseInput(data);
        assertEquals("/pub/WWW/TheProject.html", handler.getEndPoint());
    }

    @Test
    public void verifyRequestHandlerFactory404() throws Exception
    {
       String data = "GET /foobar HTTP/1.1";
       RequestHandler handler = RequestHandlerFactory.generateRequestHandler(data);

       assertTrue(handler instanceof FourOhFourHandler);
    }

    @Test
    public void handler200Test() throws Exception {
        String data = "GET /redirect HTTP/1.1";
        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(data);
        handler.processRequest();

        assertEquals("200", handler.getResponseCode());
    }

    @Test
    public void redirectLocalhostTest() throws Exception {
        String data = "GET /redirect HTTP/1.1";
        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(data);
        handler.processRequest();

        assertEquals("http://localhost:5000", handler.getRequestPath());
    }

    @Test
    public void testResponse() throws Exception {
        String data = "GET /redirect HTTP/1.1";
        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(data);
        handler.processRequest();

        assertEquals("HTTP/1.1 200\r\nhttp://localhost:5000", handler.generateResponse());
    }



}

