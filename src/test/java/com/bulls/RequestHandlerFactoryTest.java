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
        Request request = new Request(data);
        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(request);

        assertTrue(handler instanceof NotFoundHandler);
    }

    @Test
    public void verifyRequestHandlerFactoryRoot() throws Exception {
        String data = "GET / HTTP/1.1";
        Request request = new Request(data);

        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(request);

        assertTrue(handler instanceof DirectoryHandler);
    }

    @Test
    public void verifyRequestHandlerFactoryRedirect() throws Exception {
        String data = "GET /redirect HTTP/1.1";
        Request request = new Request(data);

        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(request);

        assertTrue(handler instanceof RedirectHandler);
    }

    @Test
    public void verifyRequestHandlerFactoryAuthenticate() throws Exception {
        String data = "GET /logs HTTP/1.1";
        Request request = new Request(data);

        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(request);
        assertTrue(handler instanceof AuthenticateHandler);
    }

    @Test
    public void verifyRequestHandlerFactoryMethodOptions() throws Exception
    {
        String data = "OPTIONS /method_options HTTP/1.1";
        Request request = new Request(data);

        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(request);
        assertTrue(handler instanceof MethodOptionHandler);
    }
    @Test
    public void verifyRequestHandlerFactoryFormHandlerPut() throws Exception
    {
        String data = "PUT /form HTTP/1.1";
        Request request = new Request(data);

        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(request);
        assertTrue(handler instanceof FormHandler);
    }

    @Test
    public void verifyRequestHandlerFactoryFormHandlerPost() throws Exception
    {
        String data = "POST /form HTTP/1.1";
        Request request = new Request(data);

        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(request);
        assertTrue(handler instanceof FormHandler);
    }



    @Test
    public void verifyRequestHandlerFactoryFileHandlerPut() throws Exception
    {
        String data = "PUT /file1 HTTP/1.1";
        Request request = new Request(data);

        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(request);
        assertTrue(handler instanceof FileHandler);
    }

    @Test
    public void verifyRequestHandlerFactoryFileHandlerPost() throws Exception
    {
        String data = "POST /text-file.txt HTTP/1.1";
        Request request = new Request(data);

        RequestHandler handler = RequestHandlerFactory.generateRequestHandler(request);
        assertTrue(handler instanceof FileHandler);
    }
}

