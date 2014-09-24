package com.bulls;

public class AuthenticateHandler extends RequestHandler {

    @Override
    public boolean processRequest() {
        response = new Response("401", "", "Authentication required");
        return true;
    }




}
