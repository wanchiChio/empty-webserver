package com.bulls;

/**
 * Created by anton.perez on 9/24/14.
 */
public class MockRequestHandler extends RequestHandler {

    @Override
    public boolean processRequest() {
        response = new Response("888", "/mock", "");
        return false;
    }
}
