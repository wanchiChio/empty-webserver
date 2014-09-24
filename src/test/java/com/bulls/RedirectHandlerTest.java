package com.bulls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by wanchi.chio on 9/24/14.
 */
public class RedirectHandlerTest {
    private RedirectHandler handler;

    @Before
    public void setup() {
        handler = new RedirectHandler();
        handler.setEndPoint("/redirect");
    }


    @Test
    public void verifyResponse() throws Exception {
        handler.processRequest();

        assertEquals("303", handler.getResponseCode());
        assertEquals("http://localhost:5000/", handler.getRequestPath());
        assertEquals("HTTP/1.1 303\r\nLocation: http://localhost:5000/", handler.generateResponse());
    }
}
