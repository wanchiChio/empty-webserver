package com.bulls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticateTest {

    private AuthenticateHandler handler;

    @Before
    public void setup() {
        handler = new AuthenticateHandler();
        handler.setEndPoint("/logs");
    }

    @Test
    public void authenticationFail() throws Exception
    {
        String data = "GET /logs HTTP/1.1";
        handler.processRequest();

        assertEquals("401", handler.getResponseCode());
    }

    @Test
    public void authenticationFailedBodyResponse() throws Exception {
        handler.processRequest();

        System.out.println(handler.generateResponse());
        assertEquals("Authentication required", handler.getResponseBody());
    }

}
