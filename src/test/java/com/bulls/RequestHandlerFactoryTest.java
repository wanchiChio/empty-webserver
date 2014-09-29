package com.bulls;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by wanchi.chio on 9/24/14.
 */
public class RequestHandlerFactoryTest {

    @Test
    public void verifyRequestHandlerFactory404() throws Exception {
        String data = "GET /foobar HTTP/1.1";
        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(data);

        assertTrue(handler instanceof NotFoundHandler);
    }

    @Test
    public void verifyRequestHandlerFactoryRoot() throws Exception {
        String data = "GET / HTTP/1.1";
        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(data);

        assertTrue(handler instanceof DefaultHandler);
    }

    @Test
    public void verifyRequestHandlerFactoryRedirect() throws Exception {
        String data = "GET /redirect HTTP/1.1";
        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(data);

        assertTrue(handler instanceof RedirectHandler);
    }

    @Test
    public void verifyRequestHandlerFactoryAuthenticate() throws Exception {
        String data = "GET /logs HTTP/1.1";
        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(data);
        assertTrue(handler instanceof AuthenticateHandler);
    }
}

