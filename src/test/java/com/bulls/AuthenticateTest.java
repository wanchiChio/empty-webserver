package com.bulls;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticateTest {

    @Test
    public void authenticationFail() throws Exception
    {
        String data = "GET /logs HTTP/1.1";
        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(data);
        handler.processRequest();

        assertEquals("401", handler.getResponseCode());
    }
}
