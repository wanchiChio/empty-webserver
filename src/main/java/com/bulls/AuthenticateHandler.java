package com.bulls;

public class AuthenticateHandler extends RequestHandler {

    private String requestHeaders;

    @Override
    public boolean processRequest() {
        response = new Response("401", "", "Authentication required");
        return true;
    }


    public void setRequestHeaders(String requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public String getRequestHeaders() {
        return requestHeaders;
    }
}
