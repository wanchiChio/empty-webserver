package com.bulls;

/**
 * Created by wanchi.chio on 9/29/14.
 */
public class MethodOptionHandler extends RequestHandler {
    public boolean processRequest(String data) {

        response = new Response("200", "Allowed: GET,HEAD,POST,OPTIONS,PUT");

        if(this.getHttpMethod() != null && this.getHttpMethod().equals("OPTIONS")) {
            response.addHeader("Allow", "GET,HEAD,POST,OPTIONS,PUT");
        }

        return true;
    }
}
