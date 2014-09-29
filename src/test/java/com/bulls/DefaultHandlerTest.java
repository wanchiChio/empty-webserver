package com.bulls;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by anton.perez on 9/24/14.
 */
public class DefaultHandlerTest {

    @Test
    public void testDefaultHandler() throws Exception {
        DefaultHandler handler = new DefaultHandler();
        handler.processRequest("");

        assertEquals("200", handler.getResponseCode());
    }
    
    @Test
    public void testDefaultResponseBody() throws Exception
    {
        DefaultHandler handler = new DefaultHandler();
        handler.processRequest("GET /logs HTTP/1.1");
        assertEquals("GET /logs HTTP/1.1", handler.getResponseBody());
    }


}
