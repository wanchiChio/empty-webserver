package com.bulls;

/**
 * Created by Lucien.Minot on 9/29/2014.
 */
public class FormHandler extends RequestHandler{

    @Override
    public boolean processRequest(String data) {
        response = new Response("200", "");
        return true;
    }
}
