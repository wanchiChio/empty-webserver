package com.bulls;

/**
 * Created by Lucien.Minot on 9/23/2014.
 */
public class DefaultHandler extends RequestHandler {

    @Override
    public boolean processRequest(String data) {
        String[] lines = data.split("\n");

        response = new Response("200", lines[0]);
        return true;
    }

}
