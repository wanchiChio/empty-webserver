package com.bulls;

/**
 * Created by anton.perez on 9/23/14.
 */
public class RedirectHandler extends RequestHandler {

    @Override
    public boolean processRequest(String data) {
        response = new Response("303", "");
        response.addHeader("Location", "http://localhost:5000/");

        return true;
    }
}
