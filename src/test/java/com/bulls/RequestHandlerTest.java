package com.bulls;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by anton.perez on 9/24/14.
 */
public class RequestHandlerTest {

    @Test
    public void verifyEndpoint() throws Exception {
        MockRequestHandler handler = new MockRequestHandler();
        handler.setEndPoint("/test");

        assertEquals("/test", handler.getEndPoint());
    }

    @Test
    public void verifyHttpMethod() throws Exception {
        MockRequestHandler handler = new MockRequestHandler();
        handler.setHttpMethod("GET");

        assertEquals("GET", handler.getHttpMethod());
    }

    @Test
    public void verifyResponseCode() throws Exception {
        MockRequestHandler handler = new MockRequestHandler();
        handler.processRequest();

        assertEquals("888", handler.getResponseCode());
    }

    @Test
    public void verifyRequestPath() throws Exception {
        MockRequestHandler handler = new MockRequestHandler();
        handler.processRequest();

        assertEquals("/mock", handler.getRequestPath());
    }

    @Test
    public void verifyDefaultResponse() throws Exception {
        MockRequestHandler handler = new MockRequestHandler();

        assertEquals("HTTP/1.0 404 Not Found", handler.generateDefaultResponse());
    }

    @Test
    public void verifyGenerateResponse() throws Exception {
        MockRequestHandler handler = new MockRequestHandler();
        handler.processRequest();

        assertEquals("HTTP/1.1 888\r\nLocation: /mock", handler.generateResponse());
    }

}
