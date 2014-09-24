package com.bulls;

/**
 * Created by anton.perez on 9/24/14.
 */
public class MockRequestHandler extends RequestHandler {

    @Override
    public boolean processRequest() {
        responseCode = "888";
        requestPath = "/mock";
        return false;
    }
}
