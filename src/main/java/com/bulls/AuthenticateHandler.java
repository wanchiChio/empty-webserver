package com.bulls;

public class AuthenticateHandler extends RequestHandler {

    @Override
    public boolean processRequest() {

        responseCode = "401";
        return true;
    }
}
