package com.bulls;

/**
 * Created by Lucien.Minot on 9/23/2014.
 */
public class FourOhFourHandler extends RequestHandler {

    @Override
    public boolean processRequest() {
        responseCode = "404";
        return true;
    }
}
